package com.example.electro.dataobjects;

public class ApplianceDO {
    private String aid;
    private String lastOnline;
    private String factoryNumber;

    public ApplianceDO(String aid, String lastOnline, String factoryNumber) {
        this.aid = aid;
        this.lastOnline = lastOnline;
        this.factoryNumber = factoryNumber;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    @Override
    public String toString() {
        return "ApplianceDO{" +
                "aid='" + aid + '\'' +
                ", lastOnline='" + lastOnline + '\'' +
                ", factoryNumber='" + factoryNumber + '\'' +
                '}';
    }
}
