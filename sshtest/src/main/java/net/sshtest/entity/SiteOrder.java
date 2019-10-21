package net.sshtest.entity;

import java.util.Date;

public class SiteOrder {
    private Integer sorder_id;
    private Date site_rent_star_time;
    private Date order_time;
    private Integer rent_time;

    private User userid;
    private StateInfo state;
    private Site site_id;

    public Integer getSorder_id() { return sorder_id; }

    public void setSorder_id(Integer sorder_id) {
        this.sorder_id = sorder_id;
    }

    public Date getSite_rent_star_time() {
        return site_rent_star_time;
    }

    public void setSite_rent_star_time(Date site_rent_star_time) {
        this.site_rent_star_time = site_rent_star_time;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Integer getRent_time() {
        return rent_time;
    }

    public void setRent_time(Integer rent_time) {
        this.rent_time = rent_time;
    }

    public User getUserid() { return userid; }

    public void setUserid(User userid) { this.userid = userid; }

    public StateInfo getState() {
        return state;
    }

    public void setState(StateInfo state) {
        this.state = state;
    }

    public Site getSite_id() {
        return site_id;
    }

    public void setSite_id(Site site_id) {
        this.site_id = site_id;
    }
}