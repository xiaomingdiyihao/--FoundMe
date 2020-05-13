package com.dam.dam.repository;


import com.dam.dam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// select t from User t等价于sql select t.* from user as t
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select t from User t where t.password=?1 and t.name=?2")
    User selectid(String password,String name);

    @Query(value = "select  q from User q where q.name like %?1% or q.age = ?2  or q.sex like %?3% or q.address like %?4%  or q.email like %?5% or q.tel like ?6")
    List<User> queryusermsg(String name, int age, String sex, String address, String email,String tel);

    @Query(value = "select n from User n where n.id=?1")
    List<User> getbyidmsg(int id);

    @Modifying
    @Query(value = "update User k set k.name=?1,k.password=?2,k.age=?3,k.tel=?4,k.address=?5,k.email=?6,k.iconurl=?7,k.createdate=?8,k.introduce=?9,k.sex=?10 where k.id=?11")
    int updateuser(String name,String password,int age,String tel,String address,String email,String iconurl,String createdate,String introduce,String sex,int id );

    @Query(value = "select k from User k where k.tel = ?1")
    List<User> islogintel(String tel);

}
