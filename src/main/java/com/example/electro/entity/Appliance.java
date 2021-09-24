package com.example.electro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Appliance {

    @Id
    private String aid;
    private Timestamp lastOnline;
    private String factoryNumber;

    public Appliance() {
    }

    public Appliance(String aid, String factoryNumber, Timestamp lastOnline) {
        this.aid = aid;
        this.factoryNumber = factoryNumber;
        this.lastOnline = lastOnline;
    }

    public Appliance(String aid, Timestamp lastOnline) {
        this.aid = aid;
        this.lastOnline = lastOnline;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public Timestamp getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Timestamp lastOnline) {
        this.lastOnline = lastOnline;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "aid='" + aid + '\'' +
                ", lastOnline=" + lastOnline +
                ", factoryNumber='" + factoryNumber + '\'' +
                '}';
    }
}
