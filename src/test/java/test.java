import xin.chunming.moneymanager.Dao.monthlyCrud;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
   private monthlyCrud mcf;

    public monthlyCrud getMcf() {
        return mcf;
    }

    public void setMcf(monthlyCrud mcf) {
        this.mcf = mcf;
    }

    public test() {
    }

//    @Test
//    public void a01(){
//        List<monthly> allMonthly = mcf.findAllMonthly();
//        System.out.println(allMonthly);
//    }
}
