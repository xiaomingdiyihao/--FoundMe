package com.dam.dam.repository;

import com.dam.dam.entity.AllInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import java.util.Date;
import java.util.List;

@Repository
public interface AllInfosRepository  extends JpaRepository<AllInfos,Integer> {
    @Query(value = "select t from AllInfos t where t.infoid = ?1 and t.searchdata =?2 ")
    List<AllInfos> checkinfo(int infoid, String searchddata);

    @Query(value= "select m from AllInfos m where m.area like %?1%  or m.infocontent like %?2% or m.name like %?4%  or m.classify like %?3% or m.age<=?5 and m.age >=?6 or m.time like %?7%  ")
    List<AllInfos>  selectdata(String area, String infocontent, String classify, String name, String age1,String age2, String time);

    @Query(value = "select n from AllInfos n where n.id = ?1")
    List<AllInfos> updatequerydata(int id);

    @Modifying
    @Query(value = "update AllInfos k set k.area=?1,k.infocontent=?2,k.name=?3,k.classify=?4,k.age=?5,k.time=?6  where k.id=?7")
    int updatedata(String area,String infocontent,String name,String clasify,String age,String time,int id);

    @Query(value = "select k from AllInfos k where k.classify like %?1% or k.infocontent like %?1% ")

    List<AllInfos> queryByClssify(String classify);

    //查询指定用户的点赞数
    @Query(value = "select count(k)  from AllInfos k where k.infoid = ?1")
    int selectcount(int infoid);

    @Modifying
    @Query(value = "update  AllInfos  k set k.searchdata = ?1 where k.infoid=?2")
    int userdelete(String seaerch,int infoid);

    @Modifying
    @Query(value = "update  AllInfos  k set k.searchdata = ?1 where k.id=?2")
    int userdeleteofone(String seaerch,int id);

    @Query(value = "select t from AllInfos  t  where  t.searchdata = ?1")
    List<AllInfos> queryallsearchday(String searchadata);

}
