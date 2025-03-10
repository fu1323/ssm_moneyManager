package xin.chunming.moneymanager.Dao;

import org.apache.ibatis.annotations.*;
import xin.chunming.moneymanager.Service.goldCRUD.AllmoneyGold;
import xin.chunming.moneymanager.pojo.Allmoneies;
import xin.chunming.moneymanager.pojo.login.user;

import java.util.List;

public interface AllmoneyGoldkucrud {
    @Select("select * from Allmoneies where userid = #{u.id} order by date asc")
    public List<Allmoneies> queryAll(@Param("u")user u);
    @Delete("delete from Allmoneies where id = #{id} and userid=#{u.id}")
    public void delete(int id,@Param("u")user u);
    @Update("update Allmoneies set name = #{name}, date = #{date},price=#{price},comment=#{comment} where id=#{id} and userid = #{u.id} ")
    public void update(Allmoneies am);
    @Insert("insert into Allmoneies (name,date, price, comment,editable,userid) VALUES (#{name},#{date}, #{price} ,#{comment},#{editable},#{u.id})")
    public void insert(Allmoneies am);
    @Select("select sum(price)  from Allmoneies where userid = #{id}")
    public int allprice(user u);
    @Insert("insert into Allmoneies (id,price,date,name,comment,editable,userid) VALUES ( #{id},#{price},#{date},#{name} ,#{comment} ,0,#{u.id}) on duplicate key update price = #{price}")
    public void insertAuto(Allmoneies au);
    @Select("select * from Allmoneies where editable = 0 and YEAR(date)=#{year} and MONTH(date)=#{month} and userid = #{u.id}")
    public List<Allmoneies> queryAuto(@Param("year") Integer year,@Param("month") Integer month,@Param("u")user u);

    @Select("select editable from Allmoneies where id=#{id} and userid = #{u.id}")
    public boolean queryEditable(@Param("id")int id,@Param("u")user u);
}
