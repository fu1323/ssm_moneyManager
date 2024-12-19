package xin.chunming.moneymanager.pojo.login;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class loginlog {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private boolean success;
    private String ipaddress;
    private String name;

    @Override
    public String toString() {
        return "loginlog{" +
                "id=" + id +
                ", time=" + time +
                ", success=" + success +
                ", ipaddress='" + ipaddress + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public loginlog() {
    }
}
