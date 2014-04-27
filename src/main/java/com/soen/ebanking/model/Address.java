/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen.ebanking.model;

import com.soen.ebanking.dao.ObjectDao;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 * @author HMD
 */
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long addressId;
    private String streetNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address() {
    }

    public Address(String streetNumber, String streetName, String apartmentNumber, String city, String province, String postalCode, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void saveAddress() {
        ObjectDao<Address> addressDao = new ObjectDao<Address>();
        addressDao.addObject(this);
    }

    public void updateAddress()  {
        ObjectDao<Address> addressDao = new ObjectDao<Address>();
        addressDao.updateObject(this, this.addressId, Address.class);
    }

    public void deleteAddress()  {
        ObjectDao<Address> addressDao = new ObjectDao<Address>();
        addressDao.deleteObject(this, this.addressId, Address.class);
    }

    public ArrayList<Address> getAllAddresses() {
       
        ObjectDao<Address> addressDao = new ObjectDao<Address>();
         return addressDao.getAllObjects(Address.class, "Address");
    }
    
    public Address getAddressById(long id){
        
        ObjectDao<Address> dao = new ObjectDao<Address>();
        return dao.getObjectById(id, Address.class);
    
    }
}
