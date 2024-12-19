package xin.chunming.moneymanager.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import xin.chunming.moneymanager.Service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.pojo.monthyear;

@Controller
public class mainController {
    @Autowired
    private mainService ms;
    @RequestMapping(value = "/main",produces = "application/json")
    @ResponseBody
    public String now(HttpSession hs) {
        monthyear now = ms.now();
        if (hs.getAttribute("monthyear")==null){
            hs.setAttribute("monthyear",now);
        }

        monthyear my = (monthyear)hs.getAttribute("monthyear");

        return "{\"month\":"+my.getMonth()+",\"year\":"+my.getYear()+"}";
    }
}
