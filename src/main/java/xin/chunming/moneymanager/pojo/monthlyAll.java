package xin.chunming.moneymanager.pojo;

import xin.chunming.moneymanager.pojo.login.user;

public class monthlyAll {
    private Integer id;
    private int month;
    private int year;
    private  double first;
    private double allKaizhi;

    public double getAllKaizhi() {
        return allKaizhi;
    }

    public void setAllKaizhi(double allKaizhi) {
        this.allKaizhi = allKaizhi;
    }

    private double allMoney;
    private double yu_e;
    private user u;


    @Override
    public String toString() {
        return "monthlyAll{" +
                "id=" + id +
                ", month=" + month +
                ", year=" + year +
                ", first=" + first +
                ", allKaizhi=" + allKaizhi +
                ", allMoney=" + allMoney +
                ", yu_e=" + yu_e +
                ", u=" + u +
                '}';
    }

    public user getU() {
        return u;
    }

    public void setU(user u) {
        this.u = u;
    }

    public monthlyAll() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(double allMoney) {
        this.allMoney = allMoney;
    }

    public double getYu_e() {
        return yu_e;
    }

    public void setYu_e(double yu_e) {
        this.yu_e = yu_e;
    }
}
