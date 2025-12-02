package com.bucannera.street;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Street {
    private @Id
    @GeneratedValue Long id;
    private String streetId;
    private String streetName;
    private String streetCity;

    Street() {}

    public Street(String streetId, String streetName, String streetCity) {
        this.streetId = streetId;
        this.streetName = streetName;
        this.streetCity = streetCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetCity() {
        return streetCity;
    }

    public void setStreetCity(String streetCity) {
        this.streetCity = streetCity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(id, street.id) &&
                Objects.equals(streetId, street.streetId) &&
                Objects.equals(streetName, street.streetName) &&
                Objects.equals(streetCity, street.streetCity);
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(this.id, this.streetId, this.streetName, this.streetCity);
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", streetId='" + streetId + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetCity='" + streetCity + '\'' +
                '}';
    }

}

