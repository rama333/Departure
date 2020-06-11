package com.labs.robots.departure.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Departures implements Serializable {
    @SerializedName("name")
    String name;
    @SerializedName("ip")
    String ip;
    @SerializedName("services")
    String services;
    @SerializedName("time")
    String time;
    @SerializedName("equipment")
    String equipment;
    @SerializedName("addres")
    String addres;

    public Departures(String name, String ip, String services, String time, String equipment, String addres) {
        this.name = name;
        this.ip = ip;
        this.services = services;
        this.time = time;
        this.equipment = equipment;
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
