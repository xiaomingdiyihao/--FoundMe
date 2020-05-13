package com.dam.dam.controller;

import com.dam.dam.entity.User;
import com.dam.dam.repository.UserRepository;
//import com.sun.xml.fastinfoset.util.StringArray;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserRepository userRepository;


    @GetMapping("/all/{page}/{size}")
    public Page<User> allUsers(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page, size);
        System.out.println("userRepository.findAll(request):"+userRepository.findAll(request));
        return userRepository.findAll(request);

    }
    @PostMapping("/save")
    public int save(@RequestBody User user){

        String num = user.getTel();
        System.out.println("post num:"+num);
        List<User> retur = userRepository.islogintel(num);
        System.out.println("post retur:"+retur);
        System.out.println("post isempty:"+retur.isEmpty() );
        if(!retur.isEmpty() ){
            return -100;
        }else{
            User user1 = userRepository.save(user);
            if(user1 != null){
                return user1.getId();
            }else{
                return -200;
            }
        }

    }
    @PostMapping("/checkuser")
    public int checkuser(@RequestBody User user){
//        StringArray returnrninfos;//返回
        Map<String,String> map =new HashMap<>();
        System.out.println("post checkuser:"+user);
        System.out.println("post checkuser.name:"+user.getName());
        User selectuser = userRepository.selectid(user.getPassword(), user.getName());
        if(selectuser==null){
            return 0;
        }
        return selectuser.getId();

    }


    @PostMapping("/queryusermsg")
    public List<User> queryusermsg (@RequestBody User queryuser){
    String name = queryuser.getName();
    int age = queryuser.getAge();
    String sex = queryuser.getSex();
    String address = queryuser.getAddress();
    String email =queryuser.getEmail();
    String tel = queryuser.getTel();

        if(name.equals("")){
            name="错误";
        }
        if(sex.equals("")){
            sex="错误";
        }
        if(address.equals("")){
            address="cuo";
        }
        if(email.equals("")){
            email="cuowu";
        }
        if(tel.equals("")){
            tel="cuowu";
        }

    System.out.println("post new data :"+name+":"+age+":"+sex+":"+address+":"+email+":"+tel);
    List<User> querymsg = userRepository.queryusermsg(name,age,sex,address,email,tel);
    System.out.println("the  querymsg :"+querymsg);
        return querymsg;

    }
    @PostMapping("/delete")
    public  String delete(@RequestBody User deleteuser){
        System.out.println("before deleteuser deleteuser :"+deleteuser);
        System.out.println("before deleteuser deleteuser getid:"+deleteuser.getId());
        userRepository.deleteById(deleteuser.getId());
        return "true";
    }
@PostMapping("/getusermsgbyid")
    public List<User> getusermsgbyid(@RequestBody User getbyid){
        System.out.println("before getbyid getbyid :"+getbyid);
        System.out.println("before getbyid getbyid getbyid:"+getbyid.getId());
//        List<User> getmsg = userRepository.getbyidmsg(getbyid.getId());
        return userRepository.getbyidmsg(getbyid.getId());
}
@Transactional
@PostMapping("/updatemsgbyid")
    public String updatemsgbyid(@RequestBody User userid){
//    int updateuser(String name,String password,int age,String tel,String address,String email,String iconurl,String createdate,String introduce,String sex,int id );
       String name = userid.getName();
        String password = userid.getPassword();
        int age =userid.getAge();
        String tel = userid.getTel();
        String address = userid.getAddress();
        String email =userid.getEmail();
        String iconurl = userid.getIconurl();
        String createdate =userid.getCreatedate();
        String introduce = userid.getIntroduce();
        String sex= userid.getSex();
        int getid = userid.getId();
    System.out.println("before userid userid :"+userid);
    System.out.println("before userid userid userid:"+userid.getId());
        int returnmsg = userRepository.updateuser(name,password,age,tel,address,email,iconurl,createdate,introduce,sex,getid);
    System.out.println("user update returnmsg :"+returnmsg);
       if(returnmsg != 0){
            System.out.println("bser update returnmsg :"+returnmsg);
        }
        return "true";
}

//注销用户账号并不真正的注销


}