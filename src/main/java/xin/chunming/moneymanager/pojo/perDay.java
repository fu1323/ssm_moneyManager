package xin.chunming.moneymanager.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import xin.chunming.moneymanager.pojo.login.user;

import java.time.LocalDate;
import java.util.Date;

public class perDay {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String price;
    private String comment;
    private user u;

    @Override
    public String toString() {
        return "perDay{" +
                "id=" + id +
                ", date=" + date +
                ", price='" + price + '\'' +
                ", comment='" + comment + '\'' +
                ", u=" + u +
                '}';
    }

    public user getU() {
        return u;
    }

    public void setU(user u) {
        this.u = u;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public perDay() {
    }
}
