package xin.chunming.moneymanager.Dao;

import org.apache.ibatis.annotations.*;
import xin.chunming.moneymanager.Service.goldCRUD.AllmoneyGold;
import xin.chunming.moneymanager.pojo.Allmoneies;

import java.util.List;

public interface AllmoneyGoldkucrud {
    @Select("select * from Allmoneies order by date asc")
    public List<Allmoneies> queryAll();
    @Delete("delete from Allmoneies where id = #{id}")
    public void delete(int id);
    @Update("update Allmoneies set name = #{name}, date = #{date},price=#{price},comment=#{comment} where id=#{id}")
    public void update(Allmoneies am);
    @Insert("insert into Allmoneies (name,date, price, comment,editable) VALUES (#{name},#{date}, #{price} ,#{comment},#{editable})")
    public void insert(Allmoneies am);
    @Select("select sum(price)  from Allmoneies ")
    public int allprice();
    @Insert("insert into Allmoneies (id,price,date,name,comment,editable) VALUES ( #{id},#{price},#{date},#{name} ,#{comment} ,0) on duplicate key update price = #{price}")
    public void insertAuto(Allmoneies au);
    @Select("select * from Allmoneies where editable = 0 and YEAR(date)=#{year} and MONTH(date)=#{month}")
    public List<Allmoneies> queryAuto(@Param("year") Integer year,@Param("month") Integer month);

    @Select("select editable from Allmoneies where id=#{id}")
    public boolean queryEditable(int id);
}
