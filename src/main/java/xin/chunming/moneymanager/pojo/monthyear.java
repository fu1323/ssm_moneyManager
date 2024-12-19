package xin.chunming.moneymanager.pojo;

public class monthyear {
    private int month;
    private int year;

    @Override
    public String toString() {
        return "monthyear{" +
                "month=" + month +
                ", year=" + year +
                '}';
    }

    public monthyear(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
