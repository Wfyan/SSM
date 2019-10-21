package net.sshtest.entity;

import java.sql.Date;
import java.sql.Time;

public class EquipmentOrder {
    private String order_id;
    private Time rent_time;
    private Time end_time;
    private Date order_date;
    private int use_time;
    private double total;
    private Equipment equipment;
    private User user;
    private StateInfo state;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Time getRent_time() {
        return rent_time;
    }

    public void setRent_time(Time rent_time) {
        this.rent_time = rent_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getUse_time() {
        return use_time;
    }

    public void setUse_time(int use_time) {
        this.use_time = use_time;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StateInfo getState() {
        return state;
    }

    public void setState(StateInfo state) {
        this.state = state;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
