package com.dam.dam.entity;

import javax.persistence.*;

@Table(name = "admini")
@Entity
public class Admini {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String adname;
    private  String adpassword;

    @Override
    public String toString() {
        return "Admini{" +
                "id=" + id +
                ", adname='" + adname + '\'' +
                ", adpassword='" + adpassword + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAdpassword() {
        return adpassword;
    }

    public void setAdpassword(String adpassword) {
        this.adpassword = adpassword;
    }
}
