package com.dam.dam.entity;


import javax.persistence.*;

@Entity
@Table (name = "discussinfos")
public class Discussinfos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String iconurl;
    private String typetoken;
    private  String typestatus;
    private  String discussinfos;
    private int discussid;
    private  String createdate;
    private  String otherdiscussinfos;
    private int deleteid;
    private int dianzan;
    private String discussname;

    public int getDiscussid() {
        return discussid;
    }

    public void setDiscussid(int discussid) {
        this.discussid = discussid;
    }

    @Override
    public String toString() {
        return "Discussinfos{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", typetoken='" + typetoken + '\'' +
                ", typestatus='" + typestatus + '\'' +
                ", discussinfos='" + discussinfos + '\'' +
                ", discussid=" + discussid +
                ", createdate='" + createdate + '\'' +
                ", otherdiscussinfos='" + otherdiscussinfos + '\'' +
                ", deleteid=" + deleteid +
                ", dianzan=" + dianzan +
                ", discussname='" + discussname + '\'' +
                '}';
    }

    public String getDiscussname() {
        return discussname;
    }

    public void setDiscussname(String discussname) {
        this.discussname = discussname;
    }


    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }


    public int getDianzan() {
        return dianzan;
    }

    public void setDianzan(int dianzan) {
        this.dianzan = dianzan;
    }

    public int getDeleteid() {
        return deleteid;
    }

    public void setDeleteid(int deleteid) {
        this.deleteid = deleteid;
    }


    public String getOtherdiscussinfos() {
        return otherdiscussinfos;
    }

    public void setOtherdiscussinfos(String otherdiscussinfos) {
        this.otherdiscussinfos = otherdiscussinfos;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getTypetoken() {
        return typetoken;
    }

    public void setTypetoken(String typetoken) {
        this.typetoken = typetoken;
    }

    public String getTypestatus() {
        return typestatus;
    }

    public void setTypestatus(String typestatus) {
        this.typestatus = typestatus;
    }

    public String getDiscussinfos() {
        return discussinfos;
    }

    public void setDiscussinfos(String discussinfos) {
        this.discussinfos = discussinfos;
    }



}
