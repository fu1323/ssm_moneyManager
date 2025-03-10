package xin.chunming.moneymanager.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import xin.chunming.moneymanager.pojo.login.user;

import java.time.LocalDate;
import java.util.Date;

public class monthly {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String comment;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date countTo;
    private long conbinationId;
    private String price;
    private user u;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public user getU() {
        return u;
    }

    public void setU(user u) {
        this.u = u;
    }

    @Override
    public String toString() {
        return "monthly{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", countTo=" + countTo +
                ", conbinationId=" + conbinationId +
                ", price='" + price + '\'' +
                ", u=" + u +
                '}';
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCountTo() {
        return countTo;
    }

    public void setCountTo(Date countTo) {
        this.countTo = countTo;
    }

    public long getConbinationId() {
        return conbinationId;
    }

    public void setConbinationId(long conbinationId) {
        this.conbinationId = conbinationId;
    }

    public monthly() {
    }
}
