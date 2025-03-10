package xin.chunming.moneymanager.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.monthlyAll;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface monthlyAllDao {
    @Select("select * from monthlyAll where month = #{month} and year = #{year} and userid = #{u.id}")
    public monthlyAll selectByid(@Param("month") int month, @Param("year") int year,@Param("u")user u);

    @Insert("insert into monthlyAll (id, year, month, first, allMoney,userid) VALUES ( #{a.id},#{a.year} ,#{a.month} ,#{a.first} ,#{a.allMoney},#{a.u.id}) on duplicate key update first = #{a.first},allMoney = #{a.allMoney}")
    public void updateByMonthYear(@Param("a") monthlyAll a);

    /*查询结果 不存在就创建*/

    @Update("update monthlyAll set allKaiZhi = #{akz} where month = #{month} and year = #{year} and userid = #{u.id}")
    public void updateallKaiZhi(@Param("akz") double akz, @Param("month") Integer month, @Param("year") Integer year,@Param("u")user u);

    @Update("update monthlyAll set yu_e = #{yu_e} where month = #{month} and year = #{year} and userid = #{u.id}")
    public void updateYu_e(@Param("yu_e") Double yu_e,@Param("month") Integer month,@Param("year") Integer year,@Param("u")user u);

    @Insert("insert into monthlyAll (month,year,userid) value (#{month},#{year},#{u.id})")
    public void insert_firstnew(@Param("month") int month,@Param("year") int year,@Param("u")user u);

    @Select("select yu_e  from monthlyAll where month = #{month} and year = #{year} and userid = #{u.id} ")
    public Double countAuto(@Param("month") Integer month, @Param("year") Integer year, @Param("u")user u);

}
