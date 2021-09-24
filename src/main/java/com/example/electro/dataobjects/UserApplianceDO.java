package com.example.electro.dataobjects;

import java.util.ArrayList;
import java.util.List;

public class UserApplianceDO {
    private Long id;
    private String name;
    private String address;
    private List<ApplianceDO> appliances = new ArrayList<>();
    private String connectionStatus;

    public UserApplianceDO(Long id, String name, String address, String connectionStatus, List<ApplianceDO> appliances) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.appliances = appliances;
        this.connectionStatus  = connectionStatus;
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

    public List<ApplianceDO> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<ApplianceDO> appliances) {
        this.appliances = appliances;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    @Override
    public String toString() {
        return "UserApplianceDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", appliances=" + appliances +
                ", connectionStatus='" + connectionStatus + '\'' +
                '}';
    }
}
