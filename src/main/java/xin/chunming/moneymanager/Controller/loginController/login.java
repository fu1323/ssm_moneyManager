package xin.chunming.moneymanager.Controller.loginController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.Service.login.loginService;
import xin.chunming.moneymanager.exception.loginfailException;
import xin.chunming.moneymanager.pojo.login.loginlog;
import xin.chunming.moneymanager.pojo.login.user;

@Controller
public class login {
    @Autowired
    private loginService ls;

    @RequestMapping(value = "/tologin", produces = "application/json")
    @ResponseBody
    public String querylog(HttpServletRequest hsr, user u) {


        boolean login = ls.login(u, hsr);
        if (login) {

            return "{\"message\":\"成功\"}";

        }
else return "{\"message\":\"失败\"}";
    }
}
