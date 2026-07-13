package com.backend.entity;

public class SystemHealth {
    private String name;
    private String hospital;

    public SystemHealth(String name, String hospital){
        this.hospital = hospital;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getHospital(){
        return hospital;
    }
    public void setHospital(String hospital){
        this.hospital = hospital;
    }


}
