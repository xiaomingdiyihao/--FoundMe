package com.dam.dam.controller;


import com.dam.dam.entity.Discussinfos;
import com.dam.dam.repository.DiscussinfosRepository;
//import jdk.nashorn.internal.runtime.Undefined;
//import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discussinfos")
public class DiscussinfosController {
    @Resource
    DiscussinfosRepository discussinfosRepository;

    @PostMapping("/getalldiscussinfo")
    public List<Discussinfos> getalldiscussinfo(){
        //搜索所有非删除信息
//        System.out.println("getallths:"+getallths);
        List<Discussinfos> getreun = discussinfosRepository.returndiscussinfos(2);

        System.out.println("getalldisinfos:"+getreun);
        return getreun;
    }
    @PostMapping("/save")
    public String save(@RequestBody Discussinfos dissave){
    //用户发布信息
        System.out.println("dissave:"+dissave);
        Discussinfos savereturn = discussinfosRepository.save(dissave);
        System.out.println("savereturn"+savereturn);
        return "true";
    }

//用户更新点赞数
    @Transactional
    @PostMapping("/updatedianzan")
    public  String updatedianzan(@RequestBody Discussinfos updatedianzans ){
        System.out.println("updatedianzans:"+updatedianzans);
        int dianzan = updatedianzans.getDianzan();
        int id = updatedianzans.getId();
        System.out.println("id:"+id);
       int updateDianZ = discussinfosRepository.updateDianZ(dianzan,id);
        System.out.println("updateDianZ:"+updateDianZ);
        return  "true";
    }
//其他用户增加评论
    @Transactional
    @PostMapping("/updateDisInfos")
    public  String updateDisInfos(@RequestBody Discussinfos updateDisInfos){
        System.out.println("updateDisInfos:"+updateDisInfos);
        int updateOtherDisR = discussinfosRepository.updateOtherDisInfos(updateDisInfos.getOtherdiscussinfos(),updateDisInfos.getId());
        System.out.println("updateOtherDis:"+updateOtherDisR);
        return "true";
    }

    /*
    * 根据标签来显示
    * 1: 最热根据点赞数排序
    *2：猫
    * 3：今天
    * 4：狗
    *5：女
    * 6：男
    */

    @PostMapping("/accodingToTabl")
    public  List<Discussinfos> accodingToTabl(@RequestBody Object tablNum){

        System.out.println("tablNum:"+tablNum);
        if(tablNum == null){
            tablNum="0";
        }

        System.out.println("tablNum:"+tablNum);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date();
        String timesis = formatter.format(date);
        if(tablNum.equals(1)){ //点赞
            Sort dianzanSort = Sort.by(Sort.Direction.DESC ,"dianzan");
            List<Discussinfos> returnTJ = discussinfosRepository.findAll(dianzanSort);
            return returnTJ;
        }else if(tablNum.equals(2)){ //猫
            List<Discussinfos> returnTJ = discussinfosRepository.selectTJ("猫","猫");
            return returnTJ;
        }else if(tablNum.equals(3) ){//今天
            List<Discussinfos> returnTJ =discussinfosRepository.selectToday(timesis);
            return returnTJ;
        }else if(tablNum.equals(4)){//狗
            List<Discussinfos> returnTJ = discussinfosRepository.selectTJ("狗","狗");
            return returnTJ;
        }else if(tablNum.equals(5)){//女
            List<Discussinfos> returnTJ = discussinfosRepository.selectTJ("女","女");
            return returnTJ;
        }else if(tablNum.equals(6)){//男
            List<Discussinfos> returnTJ = discussinfosRepository.selectTJ("男","男");
            return returnTJ;
        }else{ //返回全部
            List<Discussinfos> returnTJ =discussinfosRepository.findAll();
            return returnTJ;
        }

    }

    //用户删除 不真删除，只做隐藏处理
    @Transactional
    @PostMapping("/userdelete")
    public  String userdelete(@RequestBody Discussinfos userdelete){
        int getdisid = userdelete.getDiscussid();
        int di = userdelete.getId();

        int refalsede = discussinfosRepository.refalsedelete(0,getdisid,di);
        System.out.println("refalsede"+refalsede);
        return "true";
    }

//用户更新讨论
    @Transactional
    @PostMapping("/userupdatemsg")
    public  String userupdatemsg(@RequestBody Discussinfos userupdatethis){

        System.out.println("userupdate:"+userupdatethis);
        int userupdate = discussinfosRepository.userupdatemsg(userupdatethis.getDiscussinfos(),userupdatethis.getDiscussid(),userupdatethis.getId());
        System.out.println("userupdate:"+userupdate);
        return "true";
    }

//管理查看所有信息
    @PostMapping("/findalladmin")
    public List<Discussinfos> findalladmin(){

     List<Discussinfos> getallmsgadmin = discussinfosRepository.findAll();
        System.out.println("findalladmin:"+getallmsgadmin);
        return getallmsgadmin;
    }
//管理员删除信息
    @PostMapping("adminDeleteDis")
    public String deleteDisMsg(@RequestBody Object num){
       int idvalue= Integer.valueOf(num.toString()) ;
      discussinfosRepository.deleteById(idvalue);
      return"true";
    }

 //管理员修改数据
    @Transactional
   @PostMapping("/adminUpdateMsgbydis")
   public String adminUpdateMsgbydis(@RequestBody Discussinfos getdisvalue){
        String username = getdisvalue.getUsername();
        int dianzan = getdisvalue.getDianzan();
        String otherdiscussinfos = getdisvalue.getOtherdiscussinfos();
        String discussinfos = getdisvalue.getDiscussinfos();
        int getid = getdisvalue.getId();
        int getnumm = discussinfosRepository.updateByAdmin(username,dianzan,otherdiscussinfos,discussinfos,getid);
       System.out.println("getnumm:"+getnumm);
        return "true";

   }
   //管理员根据ID查询讨论
//
    @PostMapping("/querymsgByidall")
    public  List<Discussinfos> querymsgByidall(@RequestBody Object numid){
        int getid = Integer.valueOf(numid.toString());
      List<Discussinfos> rusltbyid = discussinfosRepository.querybyidadmindiscuss(getid);
        System.out.println("rusltbyid:"+rusltbyid);

        return rusltbyid;

    }


   /* @Transactional
    @PostMapping("/adminupdatemsg")
    public  String adminupdatemsg (@RequestBody Discussinfos adminupdate){
        System.out.println("adminupdate:"+adminupdate);
        String username = adminupdate.getUsername();
        String typetoken = adminupdate.getTypetoken();
        String typestatus = adminupdate.getTypestatus();
        String discussinfos = adminupdate.getDiscussinfos();
        String otherdiscuss = adminupdate.getOtherdiscussinfos();
        String url =adminupdate.getIconurl();
        int dianzan = adminupdate.getDianzan();
        int discussid = adminupdate.getDiscussid();
        int adminupdatereturn = discussinfosRepository.adminupdate(username,typetoken,typestatus,discussinfos,otherdiscuss,dianzan,discussid);
        System.out.println("adminupdatereturn:"+adminupdatereturn);
        return "true";
    }*/

    //根据user表id 查询discussid 返回用户的评论
@PostMapping("/resultByDisid")
    public  List<Discussinfos> resultByDisid (@RequestBody Object Number){
        if(Number == null){
            Number ="";
        }
        System.out.println("Number :"+Number);

         int discussid = Integer.parseInt(Number.toString());

          System.out.println("discussid :"+discussid);

        List<Discussinfos> resultById = discussinfosRepository.selectAllByDisId(discussid,2);

        System.out.println("resultById :"+resultById);

        return  resultById;
}
//根据idscussid 获取点赞数
//
    @PostMapping("/getDianzanNum")
    public  int getDianzanNum (@RequestBody Object Num){
        if(Num == null){
            Num ="";
        }
        System.out.println("Number :"+Num);
        int getinfoid = Integer.parseInt(Num.toString());
        List<Discussinfos> dianznaOne = discussinfosRepository.selectAllByDisId(getinfoid,2);
        int Count = 0;
        for (int i = 0; i <dianznaOne.size() ; i++) {
            System.out.println(dianznaOne.get(i));
            Discussinfos s = dianznaOne.get(i);
            Count= Count+ s.getDianzan();
        }
        System.out.println("Count="+Count);
        return Count;
    }
//管理员查询讨论数据
    //降序或升序排列
@PostMapping("/selectDisByadmin")
    public List<Discussinfos> selectDisByadmin (@RequestBody Discussinfos selectbyadmin){
       String creatdate = selectbyadmin.getCreatedate();
       int dianzan =selectbyadmin.getDianzan();
       String username=selectbyadmin.getUsername();
       String discussinfos = selectbyadmin.getDiscussinfos();
        String otherdiscussinfos = selectbyadmin.getOtherdiscussinfos();

        if(dianzan == 1){
            List<Discussinfos> getquery = discussinfosRepository.selectbyadmin(creatdate,username,discussinfos,otherdiscussinfos,dianzan);
            return getquery;
        }else{
            List<Discussinfos> selectbyadmindesc = discussinfosRepository.selectbyadmindesc(creatdate,username,discussinfos,otherdiscussinfos,dianzan);
            return selectbyadmindesc;
        }

    }

    //分页查询
    @GetMapping("/findpage/{page}/{size}")
    public Page<Discussinfos> queryDisByPage(@PathVariable("page") Integer page, @PathVariable("size")Integer size){
        PageRequest request = PageRequest.of(page, size);
        System.out.println("userRepository.findAll(request):"+discussinfosRepository.findAll(request));
        return discussinfosRepository.findAll(request);
    }

}
