package com.example.electro.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Appliance> appliances = new ArrayList<>();

    public User() {
    }

    public User(String name, String address, List<Appliance> appliances) {
        this.name = name;
        this.address = address;
        this.appliances = appliances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", appliances=" + appliances +
                '}';
    }
}
