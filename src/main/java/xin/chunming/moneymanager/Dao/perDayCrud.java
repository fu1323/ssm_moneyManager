package xin.chunming.moneymanager.Dao;

import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.perDay;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface perDayCrud {
    @Select("SELECT * from perDay where MONTH(date) = #{month} and YEAR(date) = #{year} and userid = #{u.id} order by date asc")
    public List<perDay> findPerDay(@Param("month") int month, @Param("year") int year, @Param("u") user u);

    @Insert("insert into perDay (date, price, comment,userid) VALUES (#{date}, #{price} ,#{comment},#{u.id})")
    public void insert(perDay p);

    @Update("update perDay set date = #{date},price=#{price},comment = #{comment}  where id = #{id} and userid = #{u.id}")

    public void update(perDay p);


    @Delete("delete from perDay where id = #{id} and userid = #{u.id}")
    public void delete(int id,@Param("u")user u);



    @Select("select sum(price) from perDay where MONTH(date)=#{month} and year(date)=#{year} and userid = #{u.id}")
    public Double countAllKaiZhi_MonthlyperDay(@Param("month") Integer month,@Param("year") Integer year,@Param("u") user u);


}


