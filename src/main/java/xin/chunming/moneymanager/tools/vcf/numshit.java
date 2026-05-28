package xin.chunming.moneymanager.tools.vcf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class numshit {
    int counter;
    BufferedWriter bufferedWriter;
    File file;

    public numshit(int counter) throws IOException {

        String property = System.getProperty("user.home");
        file = new File(property + "/" + "out" + ".vcf");
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        //  this.bufferedWriter = bufferedWriter;
        this.counter = counter;
        for (int i = 0; i < counter; i++) {
            extracted();
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void extracted() throws IOException {
        Random random = new Random();
        String[] num = new String[]{"13", "14", "15", "16", "17", "18", "19"};
//            String[] elm = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "A", "B", "C", "D", "E", "F",};
           /* StringBuilder stringBuilder = new StringBuilder();
            Random random = new Random();
            for (int in = 0; in < 15; in++) {
                stringBuilder.append("=");
                for (int i1 = 0; i1 < 2; i1++) {
                    Integer i2 = random.nextInt(0, elm.length);
                    stringBuilder.append(elm[i2]);
                }
            }*/


        int inn = random.nextInt(0, num.length);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(num[inn]);
        for (int i1 = 0; i1 < 9; i1++) {
            int i2 = random.nextInt(0, 10);
            stringBuilder1.append(i2);
        }
        Main1 main = new Main1();
        bufferedWriter.write("BEGIN:VCARD\n");
        bufferedWriter.write("VERSION:2.1\n");
        bufferedWriter.write("N;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;" + main.getNamer() + ";;;\n" +
                "FN;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + main.getNamer() + "\n");
        bufferedWriter.write("TEL;CELL:" + stringBuilder1.toString() + "\n");
        bufferedWriter.write("END:VCARD\n");
        bufferedWriter.flush();
    }

}
