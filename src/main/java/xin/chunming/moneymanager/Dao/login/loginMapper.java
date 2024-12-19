package xin.chunming.moneymanager.Dao.login;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xin.chunming.moneymanager.pojo.login.loginlog;
import xin.chunming.moneymanager.pojo.login.user;

import java.util.List;

public interface loginMapper {
    /*/*#{time} >= NOW() - INTERVAL 1 DAY and #{time} <= NOW()*/
    @Select("select * from loginlog where ipaddress=#{ipaddress} and success=0")
    public List<loginlog> querylog(loginlog ll);
    @Select("select * from user where name = #{name} and password = #{password} ")
    public List<user> queryUser(user u);
    @Insert("INSERT INTO loginlog(time, success, ipaddress, name) VALUES (#{time},#{success},#{ipaddress},#{name})")
    public void insertlog(loginlog ll);
}
/* SELECT *
FROM your_table_name
WHERE datetime_column >= NOW() - INTERVAL 1 DAY
  AND datetime_column <= NOW();
*/