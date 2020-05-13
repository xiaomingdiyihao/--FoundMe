package com.dam.dam.controller;

import com.dam.dam.entity.Admini;
//import com.dam.dam.repository.AdminiRepository;
import com.dam.dam.repository.AdminiRepository;
//import com.fasterxml.jackson.databind.util.JSONPObject;
////import javafx.geometry.Pos;
////import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
//import java.util.List;

@RestController
@RequestMapping("/admini")
public class AdminiController {
    @Resource
    private AdminiRepository adminiRepository;

    @PostMapping("/checkadmini")
    public int checkadmini(@RequestBody Admini  data){
        System.out.println("checkadminimsg  ids:   "+data);
        System.out.println("checkadminimsg: "+data);

       String name = data.getAdname();
       String password = data.getAdpassword();
      Admini ids=adminiRepository.queryadminiget(name,password);
        System.out.println("checkadminimsg  ids:   "+ids);
        if(ids == null){
            return 0;
        }
            return ids.getId();
    }
    @PostMapping("/check")
    public String check (@RequestBody Admini checkmsg){
        System.out.println("checkadminimsg: "+checkmsg);
        return  "false";
    }
    @Transactional
    @PostMapping("/updateadmin")
    public String updateadmin(@RequestBody Admini num){

        String nam=num.getAdname();
        String pas = num.getAdname();
        int id =num.getId();
        int ruslt = adminiRepository.updateusermsg(nam,pas,id);
        System.out.println(ruslt);
      return  "true";

    }
   // 获取
    @PostMapping("/getadminmsg")
    public List<Admini> getadminmsg (@RequestBody Object adminmsg){
        int getid = Integer.valueOf(adminmsg.toString());

        List<Admini> ruslt = adminiRepository.getadminmsg(getid);
        System.out.println(ruslt);
        return ruslt;

    }

}
