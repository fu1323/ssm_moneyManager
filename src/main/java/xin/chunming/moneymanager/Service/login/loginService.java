package xin.chunming.moneymanager.Service.login;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.chunming.moneymanager.Dao.login.loginMapper;
import xin.chunming.moneymanager.exception.loginfailException;
import xin.chunming.moneymanager.pojo.login.loginlog;
import xin.chunming.moneymanager.pojo.login.user;

import java.util.Date;
import java.util.List;

@Service
public class loginService {
    @Autowired
    private loginMapper lm;
private List<user> users;
    public boolean login(user u, HttpServletRequest hsr) {
        String ipadderss = hsr.getRemoteAddr();

        loginlog lg = new loginlog();
        lg.setIpaddress(ipadderss);
        lg.setTime(new Date());
        System.out.println(lg.getTime());
        System.out.println(lg.getIpaddress());
        List<loginlog> querylog = lm.querylog(lg);
        for (loginlog loginlog : querylog) {
            System.out.println(loginlog);
        }
        users = lm.queryUser(u);


        System.out.println(querylog.size());
        if (querylog.size() >= 3) {
            throw new loginfailException("您已被永久封锁");
        } else {
            if (!users.isEmpty()) {
                hsr.getSession().setAttribute("user", users.get(0));
//                lg.setSuccess(true);
//                lg.setName(u.getName());

//                lm.insertlog(lg);
                return true;
            } else {
                lg.setSuccess(false);
                lm.insertlog(lg);
                throw new loginfailException("用户名密码错误");
            }
        }

    }
}
