package xin.chunming.moneymanager.Controller.goldCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.chunming.moneymanager.Service.goldCRUD.AllmoneyGold;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.Allmoneies;
import xin.chunming.moneymanager.tools.ExpressionEvaluator;

import java.util.List;

@Controller
@RequestMapping("/gold")
public class goldController {

    @Autowired
    private AllmoneyGold allmoneyGold;
    @RequestMapping(value = "/price", produces = "application/json")
    @ResponseBody
    public String queryPrice() {
        return "{\"price\":\""+allmoneyGold.selectallprice()+"\"}";
    }
    @RequestMapping(value = "/query", produces = "application/json")
    @ResponseBody
    public List<Allmoneies> query() {
        return allmoneyGold.queryAll();
    }

    @RequestMapping(value = "/insert", produces = "application/json")
    @ResponseBody
    public String insert(Allmoneies ag) throws convertException {

        allmoneyGold.insert(ag);
        return "{\"code\":\"200\"}";
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public String update(Allmoneies ag) throws convertException {
        ag.setEditable(true);
        allmoneyGold.update(ag);
        return "{\"code\":\"200\"}";
    }
    @RequestMapping(value = "/delete", produces = "application/json")
    @ResponseBody
    public String delete(int id) {
        allmoneyGold.delete(id);
        return "{\"code\":\"200\"}";
    }

}
