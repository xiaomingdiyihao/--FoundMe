package com.dam.dam.controller;

import com.dam.dam.entity.AllInfos;
import com.dam.dam.repository.AllInfosRepository;
//import com.sun.org.apache.xml.internal.security.Init;
//import jdk.nashorn.internal.runtime.Undefined;
//import javafx.scene.control.Tab;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
//import java.awt.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.Global.undefined;

@RestController
@RequestMapping("/allinfos")
public class AllInfosController {
    @Resource
    private AllInfosRepository allInfosRepository;

    @GetMapping("/alluserinfos/{page}/{size}")
    public Page<AllInfos> allUserInfo(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page, size);
        System.out.println("userRepo"+allInfosRepository.findAll(request));
        return allInfosRepository.findAll(request);
    }

    @PostMapping("/checkinfo")
    public List<AllInfos> checkinfo(@RequestBody AllInfos allInfos){

        System.out.println("post user:"+allInfos);
        List<AllInfos> allInfos2 = allInfosRepository.checkinfo(allInfos.getInfoid(),"2");
        System.out.println("allInfos2 re:"+allInfos2);
        if(allInfos2 != null){
            return allInfos2;
        }else{
            return  allInfos2;
        }
    }
    @PostMapping("/getallinfo")
    public List<AllInfos> getallinfo(@RequestBody AllInfos queryallInfos){
        System.out.println("post user:"+queryallInfos);
        System.out.println("post time  user:"+queryallInfos.getTime());
        String area= queryallInfos.getArea();
        System.out.println("area no1 :"+area);
//        id=0, infoid='null', img='null', area='重庆市九龙坡区', time=undefined, infocontent='', name='', classify='猫', age='', searchdata='null'
        String infocontent = queryallInfos.getInfocontent();
        String classify = queryallInfos.getClassify();
        String name = queryallInfos.getName();
        String age = queryallInfos.getAge();
        String time = queryallInfos.getTime();

        String intage1 = "100";
        String intage2 = "0";

        String time1="";
        String time2="";

        if(area.equals("")){
            area = "错误";
            System.out.println("area no2 :"+area);
        }
        if(infocontent.equals("")){
            infocontent="错误";
        }
        String [] timeara= time.split(",");

        if(time == null || time.isEmpty() || time == undefined ||time.equals("undefined")){
            time="错误";
        }else{
            String [] times = time.split(",");

            time1 = times[0]+"00:00:00";
            time2 = times[1]+"00:00:00";

            System.out.println("time1:"+time1);
            System.out.println("time2:"+time2);
        }

        if(classify.equals("")){
            classify="错误";
        }
        if(name.equals("")){
            name="错误";
        }
        if(age.equals("")){
            age="错误";
        }
        if(!age.equals("错误")){
            System.out.println("cuowuwllalal");
        }else {
            System.out.println("!!!!!!!!!kanwo kanwo ");
        }
        if(classify.equals("男") || classify.equals("女") && !age.equals("错误")){
            if(!age.equals("错误")){
                intage1 =String.valueOf( Integer.valueOf(age)-1);
                intage2 =String.valueOf( Integer.valueOf(age)-10);
            }

        }else if(classify.equals("猫")||classify.equals("狗")||classify.equals("其他动物") && !age.equals("错误") ){
            if(!age.equals("错误")){
                intage1 = String.valueOf( Integer.valueOf(age));
                intage2 = String.valueOf( Integer.valueOf(age)-2);
                if(Integer.valueOf(age) == 1){
                    intage1 ="1";
                    intage2 ="0";
                }
            }


        }

        System.out.println("post new data :"+area+" : "+infocontent+":"+classify+":"+name+":"+age+":"+time);
        //    AllInfos selectdata(String infoid,String area,String infocontent,String classify,String name,String age,String time);
         List<AllInfos> getqueryAllinfos = allInfosRepository.selectdata(area,infocontent,classify,name,intage1,intage2,time);
//        List rows = allInfosRepository.selectdata(_infoid,area,infocontent,classify,name,age,time);
        System.out.println("value:"+getqueryAllinfos);
//        AllInfos allInfos2 = allInfosRepository.checkinfo(allInfos.getInfoid());
//        List<AllInfos> getthisinfosdata = allInfosRepository.querythisdata(classify);
//        System.out.println("getthisinfosdata classify :"+getthisinfosdata);

        return getqueryAllinfos;
    }


    @PostMapping("/getallinfoisthis")
    public Map checkuser(@RequestBody AllInfos user){
//        StringArray returnrninfos;//返回
        Map<String,String> map =new HashMap<>();
        System.out.println("post checkuser:"+user);
        map.put("rescode", "100");
        System.out.println("return map:"+map);
        return  map;
    }
    @PostMapping("/save")
    public String save(@RequestBody AllInfos foundsave){
        System.out.println("before save allinfos foundsave:"+foundsave);
     //   String getimgthis = foundsave.getImg();
       // foundsave.setImg("/img/"+getimgthis);
        AllInfos user1 = allInfosRepository.save(foundsave);
        System.out.println("after save allinfos user1:"+user1);
        return  "true";
    }
    @PostMapping("/delete")
    public  String delete(@RequestBody  AllInfos delekey){
        System.out.println("before delte allinfos :"+delekey);
        System.out.println("before delte allinfos getid:"+delekey.getId());
        allInfosRepository.deleteById(delekey.getId());
        return "true";
    }
@PostMapping("/updatequerydata")
    public List<AllInfos> updataquerydata(@RequestBody AllInfos updatekeyid){
    System.out.println("before delte updatekeyid :"+updatekeyid);
    System.out.println("before delte updatekeyid id:"+updatekeyid.getId());
    List<AllInfos> updatedata = allInfosRepository.updatequerydata(updatekeyid.getId());
    System.out.println("before delte updatekeyid updatedata id:"+ allInfosRepository.updatequerydata(updatekeyid.getId()));
    return updatedata;
}
@Transactional
@PostMapping("/updateinfo")
    public String updateinfo(@RequestBody AllInfos updateinfo){
    System.out.println("before updatenew updatenew :"+updateinfo);
    System.out.println("before updatenew updatenew id:"+updateinfo.getId());
    String area= updateinfo.getArea();
    String infocontent = updateinfo.getInfocontent();
    String classify = updateinfo.getClassify();
    int id = updateinfo.getId();
    String name = updateinfo.getName();
    String age = updateinfo.getAge();
    String time = updateinfo.getTime();
    int updatenew = allInfosRepository.updatedata(area,infocontent,name,classify,age,time,id);
    System.out.println("new updatenew updatenew :"+updatenew);
        return "true";
}

@PostMapping("/getallinfosbyall")
    public List<AllInfos> getallinfosbyall (){

      List<AllInfos> returnlist = allInfosRepository.queryallsearchday("2");
      System.out.println("returnlist : "+returnlist );
        return returnlist;
}

//分类查询发布的信息
    // 1 女 2男 3 猫 4狗 5其他
    @PostMapping("/queryByClssify")
    public List<AllInfos> queryByClssify(@RequestBody Object TtablNum){
        System.out.println("tablNum:"+TtablNum);
        if(TtablNum == null){
            TtablNum="0";
        }

        System.out.println("tablNum:"+TtablNum);

        if(TtablNum.equals(1)){
            List<AllInfos> returnClass = allInfosRepository.queryByClssify("女");
            return returnClass;
        }else  if(TtablNum.equals(2)){
            List<AllInfos> returnClass = allInfosRepository.queryByClssify("男");
            System.out.println("returnClass:"+returnClass);
            return returnClass;
        }else if(TtablNum.equals(3)){
            List<AllInfos> returnClass = allInfosRepository.queryByClssify("猫");
            return returnClass;
        }else if(TtablNum.equals(4)){
            List<AllInfos> returnClass = allInfosRepository.queryByClssify("狗");
            return returnClass;
        }else{
            List<AllInfos> returnClass = allInfosRepository.queryByClssify("");
            return returnClass;
        }
    }
    //用户初始化数据infos
    @PostMapping("/selectByinfoid")
    public  List<AllInfos> selectByinfoid(@RequestBody Object infoid){

        int getinfoid = Integer.parseInt(infoid.toString());
        List<AllInfos> resultiinfodi = allInfosRepository.checkinfo(getinfoid,"2");
        System.out.println("resultiinfodi:"+resultiinfodi);
        return resultiinfodi;

    }
    @PostMapping("/getUserAllDianzan")
    public  int getUserAllDianzan (@RequestBody Object infoid){
        int getinfoid = Integer.parseInt(infoid.toString());
        int resultUserDZ = allInfosRepository.selectcount(getinfoid);
        System.out.println("resultUserDZ:"+resultUserDZ);
        return  resultUserDZ;
    }
//    public  int reuserallid (@RequestBody Object infoid){
//
//
//        return 1;
//    }

//用户假清空全部数据
    @PostMapping("/userdeleteallinfo")
    public  String userdeleteallinfo (@RequestBody Object infoid){
        int getinfoid = Integer.parseInt(infoid.toString());
        int ruslt = allInfosRepository.userdelete("0", getinfoid);
        return "true";

    }
 //用户删除一条数据
 @Transactional
    @PostMapping("/userdeleteone")
    public  String userdeleteone (@RequestBody Object infoids){
        int id = Integer.valueOf(infoids.toString());
        System.out.println("id:"+id);

        int ruslt = allInfosRepository.userdeleteofone("0",id);
        System.out.println("reuslt:");
        System.out.println(ruslt);
        return "true";

    }




}
