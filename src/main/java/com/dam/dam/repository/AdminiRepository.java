package com.dam.dam.repository;

import com.dam.dam.entity.Admini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminiRepository extends JpaRepository<Admini,Integer> {
    @Query(value = "select t from Admini t where t.adname = ?1 and t.adpassword=?2")
    Admini queryadminiget(String adname, String adpassword);

    @Modifying
    @Query(value = "update Admini k set k .adname = ?1,k.adpassword = ?2 where k.id=?3")
    int updateusermsg(String name,String pas,int id);

    @Query(value = "select k from Admini k where k.id=?1")
    List<Admini> getadminmsg(int id);
}


