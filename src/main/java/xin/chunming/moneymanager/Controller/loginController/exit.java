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
import java.util.Iterator;

@Controller
public class exit {

    @RequestMapping(value = "/exit")
    public void querylog(HttpServletRequest hsr, HttpServletResponse hsp) throws IOException {

        Iterator<String> iterator = hsr.getSession().getAttributeNames().asIterator();
        while (iterator.hasNext()) {
            hsr.getSession().removeAttribute(iterator.next());
        }

        hsp.sendRedirect("/login.jsp");
    }
}


