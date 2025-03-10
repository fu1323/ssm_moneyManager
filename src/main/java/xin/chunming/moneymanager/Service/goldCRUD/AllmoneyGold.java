package xin.chunming.moneymanager.Service.goldCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.chunming.moneymanager.Dao.AllmoneyGoldkucrud;
import xin.chunming.moneymanager.exception.DataNotEditableException;
import xin.chunming.moneymanager.exception.convertException;
import xin.chunming.moneymanager.pojo.Allmoneies;
import xin.chunming.moneymanager.pojo.login.user;
import xin.chunming.moneymanager.tools.ExpressionEvaluator;

import java.util.List;

@Service
public class AllmoneyGold {

    @Autowired
    private AllmoneyGoldkucrud gold;

    public List<Allmoneies> queryAll(user u) {
        return gold.queryAll(u);
    }

    public void delete(int id,user u) {
        gold.delete(id,u);
    }

    public void insert(Allmoneies am) throws convertException {
        try {
            double caculate = ExpressionEvaluator.caculate(am.getPrice());
            am.setPrice(String.valueOf(caculate));
        } catch (Exception e) {
            throw new convertException("不合法表达式");
        }


        am.setEditable(true);

        gold.insert(am);
    }

    public void update(Allmoneies am) throws convertException {

        try {
            double caculate = ExpressionEvaluator.caculate(am.getPrice());
            if (gold.queryEditable(am.getId(),am.getU())) {
                am.setPrice(String.valueOf(caculate));
                gold.update(am);
            } else throw new DataNotEditableException("该数据不可修改");



        }catch (Exception e){
            throw new convertException("不合法表达式");
        }

    }

    public int selectallprice(user u) {
        return gold.allprice(u);
    }
}
