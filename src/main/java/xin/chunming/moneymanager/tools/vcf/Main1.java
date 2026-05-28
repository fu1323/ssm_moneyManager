package xin.chunming.moneymanager.tools.vcf;

import org.apache.commons.codec.net.QuotedPrintableCodec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Random;

//176-247         64-126
public class Main1 {
    public String getNamer() {
        return namer;
    }

    public void setNamer(String namer) {
        this.namer = namer;
    }

    public String namer = "";

    public Main1() throws UnsupportedEncodingException {
        int nameNum = random.nextInt(2, 10);
        if (nameNum==2){

        }else nameNum = 3;
        namer = encoder(nameGene(nameNum));
    }

    Random random = new Random();
    String[] frstnme = {"赵","赵","赵","赵", "鲍","钱", "曲", "苏","鄂","苏","阿","谭","彭","党","丁","罗", "柴","文","陶","苗","姚","苟","区","谢","耿","阎","巩","闫","于","于","佘","余","申","甄","洪", "蓝", "释", "高", "白", "武", "涂", "毕", "华", "邓", "梁", "薛", "孙","孙","孙","孙", "龙", "李","李","李","李","李","李", "周","周", "吴", "吴", "王","王","王", "郑","郑",  "黄", "崔", "宋","宋", "蒋", "董", "叶", "沈", "韩", "杨","杨","杨", "刘","刘","刘", "魏", "欧阳", "司马", "上官", "何", "张","张","张","张","张", "任", "马", "马", "朱", "田", "牛", "胡","胡", "夏", "金", "朴", "毛", "贾", "孔", "孟", "侯", "郭", "付", "肖", "姜", "江", "边", "林", "程", "霍", "翟", "孙","孙","孙", "蔡", "关", "邹", "姚","付占","富","张淑","弗拉基米尔","","屎","","祁",};

   /* public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("输入生成条数");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        for (int i1 = 0; i1 < i; i1++) {
            int nameNum = random.nextInt(2, 4);
//        System.out.println(i);

//            String s = " ";
//            encoder(s);
//            System.out.println(s);
            String name = nameGene(nameNum);
            System.out.println(name);

//        System.out.println("Hello world!");
//        Quot
        }
    }*/

    private String nameGene(int nameNum) {
        StringBuilder stringBuilder = new StringBuilder();
        int i1 = random.nextInt(frstnme.length - 1);
        stringBuilder.append(frstnme[i1]);
        for (int i = 0; i < nameNum - 1; i++) {
            stringBuilder.append(nameGbk());
        }
        return stringBuilder.toString();
    }

    private String encoder(String s) throws UnsupportedEncodingException {
        byte[] bytes = QuotedPrintableCodec.encodeQuotedPrintable(new BitSet(), s.getBytes(StandardCharsets.UTF_8));
        String ss = new String(bytes, "UTF-8");
        return ss;
    }

    private String nameGbk() {
//        176-247         64-126
//        Random random = new Random();
        int i1st = random.nextInt(176, 248);
        int i2nd = random.nextInt(161, 255);
       /* if (i2nd == 127) {
            i2nd = 126;
        }*/
        byte[] bytes = new byte[]{(byte) i1st, (byte) i2nd};
        try {
            return new String(bytes, "GB2312");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}