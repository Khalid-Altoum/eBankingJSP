/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import com.soen.ebanking.utils.JodaDateTimeConverter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;


@Entity
public class ClientCard implements Serializable {

    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long clientCardId;

    private String cardNumber;

   // @Convert(converter= JodaDateTimeConverter.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expiryDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client relatedClient;

    public ClientCard() {
    }

    public ClientCard(String cardNumber, Date expiryDate, Client client) {

        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.relatedClient = client;
    }

    public Long getClientCardId() {
        return clientCardId;
    }

    public void setClientCardId(Long clientCardId) {
        this.clientCardId = clientCardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Client getRelatedClient() {
        return relatedClient;
    }

    public void setRelatedClient(Client relatedClient) {
        this.relatedClient = relatedClient;
    }

    public void saveClientCard() {
        ObjectDao<ClientCard> dao = new ObjectDao<ClientCard>();
        dao.addObject(this);
        updateRelatedClientUserName(this.relatedClient);
    }

    private void updateRelatedClientUserName(Client relatedClient) {
        relatedClient.setUserName(this.cardNumber);
        relatedClient.updateUser();
    }

    public void updateClientCard() throws IllegalAccessException, InvocationTargetException {
        ObjectDao<ClientCard> accountDao = new ObjectDao<ClientCard>();
        accountDao.updateObject(this, this.getClientCardId(), ClientCard.class);
        updateRelatedClientUserName(this.relatedClient);
    }

    public void deleteClientCard() throws IllegalAccessException, InvocationTargetException {
        ObjectDao<ClientCard> accountDao = new ObjectDao<ClientCard>();
        accountDao.deleteObject(this, this.getClientCardId(), ClientCard.class);
    }

    public static ClientCard getClientCardById(long id) {
        ObjectDao<ClientCard> dao = new ObjectDao<ClientCard>();
        return dao.getObjectById(id, ClientCard.class);
    }
}
