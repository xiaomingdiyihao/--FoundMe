package com.dam.dam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private int age;
    private String password;
    private String  tel;
    private String address;
    private  String email;
    private  String leavmsgid;
    private String iconurl;
    private String createdate;
    private String personalleav;
    private String historyselect;
    private  String introduce;
    private String sex;

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", leavmsgid='" + leavmsgid + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", createdate=" + createdate +
                ", personalleav='" + personalleav + '\'' +
                ", historyselect='" + historyselect + '\'' +
                ", introduce='" + introduce + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLeavmsgid() {
        return leavmsgid;
    }

    public void setLeavmsgid(String leavmsgid) {
        this.leavmsgid = leavmsgid;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }
    public String getPersonalleav() {
        return personalleav;
    }

    public void setPersonalleav(String personalleav) {
        this.personalleav = personalleav;
    }

    public String getHistoryselect() {
        return historyselect;
    }

    public void setHistoryselect(String historyselect) {
        this.historyselect = historyselect;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
