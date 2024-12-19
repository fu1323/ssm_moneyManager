package xin.chunming.moneymanager.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import xin.chunming.moneymanager.pojo.monthlyAll;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface monthlyAllDao {
    @Select("select * from monthlyAll where month = #{month} and year = #{year}")
    public monthlyAll selectByid(@Param("month") int month, @Param("year") int year);

    @Insert("insert into monthlyAll (id, year, month, first, allMoney) VALUES ( #{a.id},#{a.year} ,#{a.month} ,#{a.first} ,#{a.allMoney}) on duplicate key update first = #{a.first},allMoney = #{a.allMoney}")
    public void updateByMonthYear(@Param("a") monthlyAll a);

    /*查询结果 不存在就创建*/

    @Update("update monthlyAll set allKaiZhi = #{akz} where month = #{month} and year = #{year}")
    public void updateallKaiZhi(@Param("akz") double akz, @Param("month") Integer month, @Param("year") Integer year);

    @Update("update monthlyAll set yu_e = #{yu_e} where month = #{month} and year = #{year}")
    public void updateYu_e(@Param("yu_e") Double yu_e,@Param("month") Integer month,@Param("year") Integer year);

    @Insert("insert into monthlyAll (month,year) value (#{month},#{year})")
    public void insert_firstnew(@Param("month") int month,@Param("year") int year);

    @Select("select yu_e  from monthlyAll where month = #{month} and year = #{year} ")
    public Double countAuto(@Param("month") Integer month, @Param("year") Integer year);

}
