package xin.chunming.moneymanager.Controller.loginController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.Service.login.loginService;
import xin.chunming.moneymanager.pojo.login.user;

import java.io.IOException;
import java.net.http.HttpResponse;

@Controller
public class exit {

    @RequestMapping(value = "/exit")
    public void querylog(HttpServletRequest hsr, HttpServletResponse hsp) throws IOException {
        hsr.getSession().removeAttribute("user");

        hsp.sendRedirect("/login.jsp");
    }
}


