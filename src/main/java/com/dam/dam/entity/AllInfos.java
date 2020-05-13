package com.dam.dam.entity;

import javax.persistence.*;
//import java.util.Date;

@Entity
@Table(name = "allinfos")
public class AllInfos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int infoid;
    private String img;
    private  String area;
    private String infocontent;
    private String name;
    private String classify;
    private String age;
    private String searchdata;
    private String time;

    public int getInfoid() {
        return infoid;
    }

    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }

    @Override
    public String toString() {
        return "AllInfos{" +
                "id=" + id +
                ", infoid='" + infoid + '\'' +
                ", img='" + img + '\'' +
                ", area='" + area + '\'' +
                ", time=" + time +
                ", infocontent='" + infocontent + '\'' +
                ", name='" + name + '\'' +
                ", classify='" + classify + '\'' +
                ", age='" + age + '\'' +
                ", searchdata='" + searchdata + '\'' +
                '}';
    }

    public String getSearchdata() {
        return searchdata;
    }

    public void setSearchdata(String searchdata) {
        this.searchdata = searchdata;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInfocontent() {
        return infocontent;
    }

    public void setInfocontent(String infocontent) {
        this.infocontent = infocontent;
    }





    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }


}
