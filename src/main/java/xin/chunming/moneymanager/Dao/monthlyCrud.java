package xin.chunming.moneymanager.Dao;

import xin.chunming.moneymanager.pojo.monthly;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface monthlyCrud {
/* @Select("SELECT * from perDay where MONTH(date) = #{month} and YEAR(date) = #{year}")
    public List<perDay> findPerDay(@Param("month") int month,@Param("year") int year);*/
    @Select("SELECT * from monthly where MONTH(countTo) = #{month} and YEAR(countTo) = #{year} order by date ASC , conbinationId ASC ")
    public List<monthly> findAllMonthly(@Param("month") int month, @Param("year") int year);
    @Select("SELECT * from monthly where MONTH(countTo) = #{month} and YEAR(countTo) = #{year} order by price desc")

    public List<monthly> findAllMonthlybyPrice(@Param("month") int month, @Param("year") int year);
    @Select("select sum(price)  from monthly where MONTH(countTo)=#{month} and year(countTo)=#{year}")
    public Double countAllKaiZhi_Monthly(@Param("month") Integer month, @Param("year") Integer year);


    @Insert("insert into monthly (name,date,price,conbinationId,countTo,comment) VALUES (#{name}, #{date} ,#{price},#{conbinationId},#{countTo},#{comment})")
    public void insert(monthly m);
    @Update("update monthly set name = #{name},date=#{date} ,price=#{price},conbinationId = #{conbinationId},countTo = #{countTo},comment = #{comment} where id = #{id}")
    public void update(monthly m);
    @Delete("delete from monthly where id = #{id}")
    public void delete(int id);


}
