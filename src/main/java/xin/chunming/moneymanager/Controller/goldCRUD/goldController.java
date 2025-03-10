package xin.chunming.moneymanager.Controller.goldCRUD;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.Service.goldCRUD.AllmoneyGold;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.Allmoneies;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.tools.ExpressionEvaluator;

import java.util.List;

@Controller
@RequestMapping("/gold")
public class goldController {

    @Autowired
    private AllmoneyGold allmoneyGold;
    @RequestMapping(value = "/price", produces = "application/json")
    @ResponseBody
    public String queryPrice(HttpServletRequest request) {

        HttpSession session = request.getSession();
        user user = (user) session.getAttribute("user");

        return "{\"price\":\""+allmoneyGold.selectallprice(user)+"\"}";
    }
    @RequestMapping(value = "/query", produces = "application/json")
    @ResponseBody
    public List<Allmoneies> query(HttpServletRequest request) {

        HttpSession session = request.getSession();
        user user = (user) session.getAttribute("user");
        return allmoneyGold.queryAll(user);
    }

    @RequestMapping(value = "/insert", produces = "application/json")
    @ResponseBody
    public String insert(Allmoneies ag,HttpServletRequest request) throws convertException {
        HttpSession session = request.getSession();
        user user = (user) session.getAttribute("user");
        ag.setU(user);
        allmoneyGold.insert(ag);
        return "{\"code\":\"200\"}";
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public String update(Allmoneies ag,HttpServletRequest request) throws convertException {
        ag.setEditable(true);
        HttpSession session = request.getSession();
        user user = (user) session.getAttribute("user");
        ag.setU(user);
        allmoneyGold.update(ag);
        return "{\"code\":\"200\"}";
    }
    @RequestMapping(value = "/delete", produces = "application/json")
    @ResponseBody
    public String delete(int id,HttpSession hs) {
        allmoneyGold.delete(id,(user)hs.getAttribute("user"));
        return "{\"code\":\"200\"}";
    }

}
