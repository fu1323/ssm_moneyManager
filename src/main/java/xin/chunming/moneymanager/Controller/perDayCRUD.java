package xin.chunming.moneymanager.Controller;

import jakarta.servlet.http.HttpSession;
import xin.chunming.moneymanager.Service.perDayService;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.monthyear;
import xin.chunming.moneymanager.pojo.perDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/day")
public class perDayCRUD {
    @Autowired
    private perDayService pds;

    @RequestMapping("/query")
    @ResponseBody
    public List<perDay> lim(Integer month, Integer year, HttpSession hs) {
        System.out.println(month);
        hs.setAttribute("monthyear",new monthyear(month,year));
        user user = (user) hs.getAttribute("user");

        List<perDay> days = pds.listDay(month,year,user);
        return days;

    }
    @RequestMapping(value = "/insert", produces = "application/json",method= RequestMethod.POST)
    @ResponseBody
    public String insert(perDay p,HttpSession hs) throws convertException {
        p.setU((user)hs.getAttribute("user"));
        System.out.println(p);
        pds.insertDay(p);
        return "{\"code\":\"200\"}";

    }
    @RequestMapping(value = "/update", produces = "application/json",method= RequestMethod.POST)
    @ResponseBody
    public String update(perDay p,HttpSession hs) throws convertException {
        System.out.println(p);
        p.setU(((user) hs.getAttribute("user")));
        pds.updateDay(p);
        String a = "{\"code\":\"200\"}";
        return a;

    }
    @RequestMapping(value = "/delete", produces = "application/json",method = RequestMethod.DELETE)
    @ResponseBody

    public String delete(Integer id,HttpSession hs){
        System.out.println(id);
        pds.delete(id,(user) hs.getAttribute("user"));

        return "{\"code\":\"200\"}";
    }
}




