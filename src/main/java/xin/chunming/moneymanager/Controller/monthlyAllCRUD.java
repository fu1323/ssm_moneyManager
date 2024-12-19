package xin.chunming.moneymanager.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.chunming.moneymanager.Service.monthlyAllService;
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
    public monthlyAll select(int month, int year) {



        return mas.select(month, year);
    }

    @RequestMapping(value = "/updins",produces = "application/json",method= RequestMethod.POST)
    @ResponseBody
    public String update(monthlyAll m) {
        System.out.println(m);
        mas.update(m);
        return "{\"code\":\"200\"}";
    }
}
