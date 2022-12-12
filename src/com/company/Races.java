package com.company;

import java.io.Serializable;
import java.util.Date;

public class Races implements Serializable {
    private Date date;
    private String id;
    private int place;
    public Races() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
