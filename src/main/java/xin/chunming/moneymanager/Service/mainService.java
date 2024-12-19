package xin.chunming.moneymanager.Service;

import org.springframework.stereotype.Service;
import xin.chunming.moneymanager.pojo.monthyear;

import java.util.Date;

@Service
public class mainService {
    public monthyear now(){
        Date date = new Date();
        int month = date.getMonth();
        int year = date.getYear();
        year+=1900;
        month++;
        return new monthyear(month,year);

    }

}
