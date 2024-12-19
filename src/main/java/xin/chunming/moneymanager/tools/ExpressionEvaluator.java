package xin.chunming.moneymanager.tools;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ExpressionEvaluator {
   public static double caculate(String expre){
        Expression exp = new ExpressionBuilder(expre).build();
        return exp.evaluate();  // 计算结果
//        int resultInt = (int) result;  // 转换为int类型
//        System.out.println("计算结果: " + resultInt);
    }
}