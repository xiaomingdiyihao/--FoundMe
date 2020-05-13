package com.dam.dam;

import com.dam.dam.entity.AllInfos;
import com.dam.dam.entity.User;
import com.dam.dam.repository.AllInfosRepository;
import com.dam.dam.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;



@SpringBootTest
class DamApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<User> page = userRepository.findAll(pageRequest);
        int i = 0;
        System.out.println("userrepository page:"+page);

    }


//    @Test
//    void queryusermsg(){
////        List<User> querymsg = userRepository.queryusermsg(name,age,sex,address,email,tel);
//        List<User> listuser = userRepository.queryusermsg("",21,"","", "", "");
//        System.out.println("listuser :"+listuser);
//
//    }
//    @Test
//    void update(){
//       int reutrn= userRepository.updateuser("xiaom","123",12,"183166554","小明","email","imgcon","jieshao","男",20);
//        System.out.println("reutrn return result :"+reutrn);
//    }

    @Autowired
    AllInfosRepository allInfosRepository;

    @Test
    void allinfor(){
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<AllInfos> page = allInfosRepository.findAll(pageRequest);
        int i = 0;
        System.out.println("page:"+page);
    }
//    @Test
//    void selectinfor(){
//        AllInfos all3 = allInfosRepository.checkinfo("");
//        System.out.println("all infoid:"+all3);
//    }
    @Test
    void getstirngto(){
        AllInfos gettostringall =new AllInfos();
        System.out.println("thisis :"+    allInfosRepository.findAll());
        System.out.println("tostring allinfos  :"+gettostringall.toString());
//        System.out.println("return img :");
    }
//    @Test
//    void updatecheck(){
//        AllInfos gettostringall =new AllInfos();
//        List<AllInfos> allinfoseit = allInfosRepository.updatequerydata(1);
//    }
/*@Test
   List<AllInfos> getallinfo(){
        AllInfos all5 = new AllInfos();
    List<AllInfos> thisisall =allInfosRepository.findAll();
  //  System.out.println("findall length :"+allInfosRepository.findAll());
    System.out.println("thisisall:"+thisisall);
    return thisisall;

}*/


}
