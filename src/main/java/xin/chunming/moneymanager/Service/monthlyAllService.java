package xin.chunming.moneymanager.Service;

import xin.chunming.moneymanager.Dao.monthlyAllDao;
import xin.chunming.moneymanager.Dao.monthlyCrud;
import xin.chunming.moneymanager.Dao.perDayCrud;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.pojo.monthlyAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class monthlyAllService {
    @Autowired
    private monthlyAllDao mad;
    @Autowired
    private perDayCrud pdc;
    @Autowired
    private monthlyCrud mc;

    public monthlyAll select(int month, int year, user u) {
        Double i = mc.countAllKaiZhi_Monthly(month, year,u);
        Double v = pdc.countAllKaiZhi_MonthlyperDay(month, year,u);
        if (i != null || v != null) {
            i=i==null?0:i;
            v=v==null?0:v;
            mad.updateallKaiZhi ((i + v), month, year,u);

            monthlyAll monthlyAll = mad.selectByid(month, year,u);
            if (monthlyAll!=null){
            Double allMoney = monthlyAll.getAllMoney();
                mad.updateYu_e((allMoney - i - v), month, year,u);
            }
            else mad.insert_firstnew(month,year,u);
        }
//        BigDecimal.valueOf();

        return mad.selectByid(month, year,u);
    }

    public void update(monthlyAll ma) {
        if (ma.getId() == -8) {
            ma.setId(null);
        }


        mad.updateByMonthYear(ma);
    }
}
