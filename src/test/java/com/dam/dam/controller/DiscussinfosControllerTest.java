package com.dam.dam.controller;

import com.dam.dam.entity.Discussinfos;
import com.dam.dam.repository.DiscussinfosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
//import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.HashMap;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscussinfosControllerTest {

    @Autowired
    DiscussinfosRepository discussinfosRepository;

    @Transactional
    @Test
    void returndis(){
    List<Discussinfos> getreun = discussinfosRepository.returndiscussinfos(2);
        System.out.println("getreun:");
    System.out.println(getreun);

    }

    @Test
    void sortbydianzan(){
        Sort dianzanSort = Sort.by(Sort.Direction.DESC ,"dianzan");
        List<Discussinfos> getrun = discussinfosRepository.findAll(dianzanSort);
        System.out.println("dianzan sort :"+getrun);
    }

    @Test
    void returncat(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date();
        String timesis = formatter.format(date);
        System.out.println("look at me ");
        System.out.println(timesis);
    }
    @Test
    void reutnrcatis(){
        List<Discussinfos> returnTJ = discussinfosRepository.selectTJ("猫","猫");
        System.out.println(returnTJ);

    }

    @Test
    void testdesc(){

        String creatdate = "";
        int dianzan =2;
        String username="";
        String discussinfos ="";
        String otherdiscussinfos ="";
        List<Discussinfos> getquery = discussinfosRepository.selectbyadmindesc(creatdate,username,discussinfos,otherdiscussinfos,dianzan);
        System.out.println("what is this");
        System.out.println(getquery);

    }
    //page
    @Test
    void page(){
        int getid = 2;
        List<Discussinfos> rusltbyid = discussinfosRepository.querybyidadmindiscuss(getid);
        System.out.println("rusltbyid:"+rusltbyid);
    }

}