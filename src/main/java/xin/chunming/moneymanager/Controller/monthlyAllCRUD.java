package xin.chunming.moneymanager.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.chunming.moneymanager.Service.monthlyAllService;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.monthlyAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.pojo.monthyear;

@Controller
@RequestMapping("/monthlyall")
public class monthlyAllCRUD {
    @Autowired
    public monthlyAllService mas;

    @RequestMapping("/select")
    @ResponseBody
    public monthlyAll select(int month, int year,HttpServletRequest request) {

        user user = (user) request.getSession().getAttribute("user");

        return mas.select(month, year,user);
    }

    @RequestMapping(value = "/updins",produces = "application/json",method= RequestMethod.POST)
    @ResponseBody
    public String update(monthlyAll m,HttpServletRequest request) {
        System.out.println(m);
        user user = (user) request.getSession().getAttribute("user");
        m.setU(user);
        mas.update(m);
        return "{\"code\":\"200\"}";
    }
}
