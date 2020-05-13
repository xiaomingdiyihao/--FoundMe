package com.dam.dam.repository;

import com.dam.dam.entity.Discussinfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import javax.validation.constraints.Max;
import java.util.List;

@Repository
public interface DiscussinfosRepository extends JpaRepository<Discussinfos,Integer> {

    @Query(value = "select t from Discussinfos t where t.deleteid=?1")
    List<Discussinfos> returndiscussinfos(int deleteid);

    //用户删除信息
    @Modifying
    @Query(value = "update Discussinfos  k set k.deleteid=?1 where k.discussid=?2 and k.id=?3")
    int refalsedelete(int deleteid,int discussid,int id);

    //用户更改信息
    @Modifying
    @Query(value = "update Discussinfos  k  set k.discussinfos=?1 where  k.discussid=?2 and k.id=?3")
    int userupdatemsg(String discussinfos,int discussid,int id);

//    @Modifying
//    @Query(value = "update Discussinfos k set k.username=?1,k.typetoken=?2,k.typestatus=?3,k.discussinfos=?4,k.otherdiscussinfos=?5,k.dianzan=?6 where k.discussid=?7")
//    int adminupdate(String username,String typetoken,String typestatus,String discussinfos,String otherdiscussinfos,int dianzan,int discussid);

    @Modifying
    @Query(value = "update Discussinfos  k  set k.dianzan = ?1 where k.id = ?2")
    int updateDianZ(int dianzan,int id);

    @Modifying
    @Query(value = "update  Discussinfos  k set k.otherdiscussinfos=?1 where k.id = ?2")
    int updateOtherDisInfos(String otherdiscussinfos,int id);

    @Query(value = "select k from Discussinfos k where  k.discussid=?1 and k.deleteid = ?2")
    List<Discussinfos> selectAllByDisId(int discussid,int deleteid);
    //查询猫 狗 人
    @Query(value = "select  k from  Discussinfos  k where k.otherdiscussinfos like %?1% or  k.discussinfos like %?2% ")
    List<Discussinfos> selectTJ(String otherdiscussinfos,String discussinfos );
    //查询是否今天的
    @Query(value = "select k from Discussinfos  k where k.createdate like  ?1")
    List<Discussinfos> selectToday(String creatdate);
//    @Query(value = "select k)from Discussinfos k where k.discussid =?1")
//    List<Discussinfos> getdianzannum(int discussid);

//    String creatdate = selectbyadmin.getCreatedate();
//    int dianzan =selectbyadmin.getDianzan();
//    String username=selectbyadmin.getUsername();
//    String discussinfos = selectbyadmin.getDiscussinfos();
//    String otherdiscussinfos = selectbyadmin.getOtherdiscussinfos();
//管理员查询讨论数据
    @Query(value = "select  k from Discussinfos  k where k.createdate like %?1% or k.username like  %?2% or k.discussinfos like %?3% or k.otherdiscussinfos like %?4% order by k.dianzan")
    List<Discussinfos> selectbyadmin(String createdate,String username,String discussionfos,String otherdiscussinfo,int dianzan);

    //降序排序
    @Query(value = "select  k from Discussinfos  k where k.createdate like %?1% or k.username like  %?2% or k.discussinfos like %?3% or k.otherdiscussinfos like %?4% order by k.dianzan DESC ")
    List<Discussinfos> selectbyadmindesc(String createdate,String username,String discussionfos,String otherdiscussinfo,int dianzan);


    //管理员修改信息
    @Modifying
    @Query(value = "update Discussinfos  k set k.username = ?1,k.dianzan=?2,k.otherdiscussinfos=?3,k.discussinfos=?4 where k.id=?5")
    int updateByAdmin(String a,int b,String c,String d,int e);

    //管理员根据id 查找数据
    @Query(value = "select k from Discussinfos  k where k.id=?1")
    List<Discussinfos> querybyidadmindiscuss(int id);


    //管理员修改数据
//    username: '',
//    dianzan: '',
//    otherdiscussinfos: '',
//    discussinfos: '' 根据id修改

}
