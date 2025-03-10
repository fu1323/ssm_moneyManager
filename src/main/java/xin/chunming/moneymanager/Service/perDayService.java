package xin.chunming.moneymanager.Service;

import xin.chunming.moneymanager.Dao.AllmoneyGoldkucrud;
import xin.chunming.moneymanager.Dao.monthlyAllDao;
import xin.chunming.moneymanager.Dao.monthlyCrud;
import xin.chunming.moneymanager.Dao.perDayCrud;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.Allmoneies;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.perDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.chunming.moneymanager.tools.ExpressionEvaluator;

import java.util.Date;
import java.util.List;

@Service
public class perDayService {
    @Autowired
    private perDayCrud pdc;
    @Autowired
    private AllmoneyGoldkucrud ag;
    @Autowired
    private monthlyAllDao mc;

    public List<perDay> listDay(int month, int year,user u) {
        List<Allmoneies> allmoneies1 = ag.queryAuto(year, month,u);

        if (allmoneies1.isEmpty()) {
            String s = String.valueOf(mc.countAuto(month, year,u));
            if (s != null && !s.equals("null")) {
                Allmoneies allmoneies = new Allmoneies();
                allmoneies.setPrice(String.valueOf(mc.countAuto(month, year,u)));
                allmoneies.setName(year + "年" + month + "月" + "结余");
                allmoneies.setComment("系统自动计算");
                allmoneies.setDate(new Date(year - 1900, month - 1, 01));
                System.out.println(mc.countAuto(month, year,u));
                System.out.println(allmoneies);

                ag.insertAuto(allmoneies);
            }
        } else {
            if (mc.countAuto(month, year,u) != null) {
                allmoneies1.get(0).setPrice(String.valueOf(mc.countAuto(month, year,u)));
                ag.insertAuto(allmoneies1.get(0));
            }
        }

        List<perDay> lim = pdc.findPerDay(month, year,u);
        return lim;
    }

    public void insertDay(perDay p) throws convertException {
        try {


            String price = p.getPrice();
            p.setComment(price);
            Double caculate = ExpressionEvaluator.caculate(price);
            p.setPrice(caculate.toString());
            pdc.insert(p);
        } catch (Exception e) {
            throw new convertException("不合法表达式");
        }


    }

    public void updateDay(perDay p) throws convertException {

        try {
            String price = p.getPrice();
            p.setComment(price);
            Double caculate = ExpressionEvaluator.caculate(price);
            p.setPrice(caculate.toString());
            pdc.update(p);
        } catch (Exception e) {
            throw new convertException("不合法表达式");
        }
    }

    public void delete(int id,user u) {
        pdc.delete(id,u);
    }

}
