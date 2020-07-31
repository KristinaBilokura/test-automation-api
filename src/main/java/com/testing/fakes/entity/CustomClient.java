package com.testing.fakes.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="np_key_secrets")
public class CustomClient extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String firstName;
    private String lastName;

    public Integer getTemperature() {
        return temperature;
    }

    public CustomClient setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    private Integer temperature;

    public Long getId() {
        return id;
    }

    public CustomClient setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CustomClient setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CustomClient setCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomClient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomClient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public Map<String, Object> map() {
        return null;
    }
}
