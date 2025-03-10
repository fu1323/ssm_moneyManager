package xin.chunming.moneymanager.Controller;

import jakarta.servlet.http.HttpSession;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.monthly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.pojo.monthyear;

import java.util.List;

@Controller
@RequestMapping("/monthly")
public class permonthCRUD {
    @Autowired
    private xin.chunming.moneymanager.Service.monthlyService monthlyService;

    @RequestMapping("/query")
    @ResponseBody
    public List<monthly> lim(Integer month, Integer year, HttpSession hs) {
        hs.setAttribute("monthyear",new monthyear(month,year));
      return    monthlyService.monthlyQuery(month, year,(user)hs.getAttribute("user"));


    }
    @RequestMapping("/querybyprice")
    @ResponseBody
    public List<monthly> querybyprice(Integer month, Integer year,HttpSession hs) {
        hs.setAttribute("monthyear",new monthyear(month,year));
        return monthlyService.monthlyQueryByprice (month, year,(user)hs.getAttribute("user"));
//        return monthlies;

    }

    @RequestMapping(value = "/insert", produces = "application/json")
    @ResponseBody
    public String insert(monthly m,HttpSession hs) throws convertException {
        m.setU((user)hs.getAttribute("user"));
        monthlyService.monthlyInsert(m);

        return "{\"code\":\"200\"}";
    }
    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public String update(monthly m,HttpSession hs) throws convertException {
        m.setU((user)hs.getAttribute("user"));
        monthlyService.monthlyUpdate(m);

        return "{\"code\":\"200\"}";
    }
    @RequestMapping(value = "/delete", produces = "application/json",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(Integer id,HttpSession hs) throws convertException {
        monthlyService.monthlyDelete(id,(user)hs.getAttribute("user"));

        return "{\"code\":\"200\"}";
    }
}
