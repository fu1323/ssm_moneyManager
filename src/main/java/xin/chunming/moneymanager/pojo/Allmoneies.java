package xin.chunming.moneymanager.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Allmoneies {
    private Integer id;
    private String name;
    private Boolean editable;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String comment;
    private String price;


    @Override
    public String toString() {
        return "Allmoneies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", editable=" + editable +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Allmoneies() {
    }
}
