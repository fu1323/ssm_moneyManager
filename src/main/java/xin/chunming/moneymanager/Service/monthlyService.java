package xin.chunming.moneymanager.Service;

import xin.chunming.moneymanager.Dao.AllmoneyGoldkucrud;
import xin.chunming.moneymanager.Dao.monthlyAllDao;
import xin.chunming.moneymanager.Dao.monthlyCrud;
import xin.chunming.moneymanager.exception.NullDateException;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.Allmoneies;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.monthly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.chunming.moneymanager.tools.ExpressionEvaluator;

import java.util.Date;
import java.util.List;

@Service
public class monthlyService {
    @Autowired
    private monthlyCrud mcf;
    @Autowired
    private AllmoneyGoldkucrud ag;
    @Autowired
    private monthlyAllDao mc;

    public List<monthly> monthlyQuery(int month, int year, user u) {
        List<Allmoneies> allmoneies1 = ag.queryAuto(year, month,u);

        if (allmoneies1.isEmpty()) {
            String s = String.valueOf(mc.countAuto(month, year,u));

            if (s!=null&&!s.equals("null")) {
                Allmoneies allmoneies = new Allmoneies();
                allmoneies.setPrice(s);
                allmoneies.setName(year + "年" + month + "月" + "结余");
                allmoneies.setComment("系统自动计算");
                allmoneies.setDate(new Date(year - 1900, month - 1, 01));
                System.out.println(mc.countAuto(month, year,u));
                System.out.println(allmoneies);

                ag.insertAuto(allmoneies);
            }
        } else {
            allmoneies1.get(0).setPrice(String.valueOf(mc.countAuto(month, year,u)));
            ag.insertAuto(allmoneies1.get(0));
        }


        return mcf.findAllMonthly(month, year,u);
    }

    public List<monthly> monthlyQueryByprice(int month, int year,user u) {
        return mcf.findAllMonthlybyPrice(month, year,u);
    }

    public void monthlyInsert(monthly m) throws convertException {
        if (m.getDate() == null) {
            throw new RuntimeException("时间不可为空");
        } else {
            if (m.getCountTo() == null) {
                m.setCountTo(m.getDate());
            }


            try {
                String price = m.getPrice();
                double caculate = ExpressionEvaluator.caculate(price);
                m.setPrice(String.valueOf(caculate));
            } catch (Exception e) {
                throw new convertException("不合法表达式");
            }


            mcf.insert(m);

        }
    }

    public void monthlyUpdate(monthly m) throws convertException {
        if (m.getCountTo() == null) {
            if (m.getDate() == null) {
                m.setDate(new Date());
            }
            m.setCountTo(m.getDate());
        }
        try {
            String price = m.getPrice();
            double caculate = ExpressionEvaluator.caculate(price);
            m.setPrice(String.valueOf(caculate));
        } catch (Exception e) {
            throw new convertException("不合法表达式");
        }

        mcf.update(m);

    }

    public void monthlyDelete(int id,user u) {
        mcf.delete(id,u);
    }
}
