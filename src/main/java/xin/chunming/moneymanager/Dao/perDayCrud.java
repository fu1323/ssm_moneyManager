package xin.chunming.moneymanager.Dao;

import xin.chunming.moneymanager.pojo.perDay;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface perDayCrud {
    @Select("SELECT * from perDay where MONTH(date) = #{month} and YEAR(date) = #{year} order by date asc")
    public List<perDay> findPerDay(@Param("month") int month, @Param("year") int year);

    @Insert("insert into perDay (date, price, comment) VALUES (#{date}, #{price} ,#{comment})")
    public void insert(perDay p);

    @Update("update perDay set date = #{date},price=#{price},comment = #{comment}  where id = #{id}")

    public void update(perDay p);


    @Delete("delete from perDay where id = #{id}")
    public void delete(int id);



    @Select("select sum(price) from perDay where MONTH(date)=#{month} and year(date)=#{year}")
    public Double countAllKaiZhi_MonthlyperDay(@Param("month") Integer month,@Param("year") Integer year);


}


