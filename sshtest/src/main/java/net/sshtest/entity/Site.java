package net.sshtest.entity;

public class Site {
    private int site_id;
    private String site_name;
    private String site_type;
    private String site_location;
    private String site_mrentprice;
    private StateInfo state;

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getSite_type() {
        return site_type;
    }

    public void setSite_type(String site_type) {
        this.site_type = site_type;
    }

    public String getSite_location() {
        return site_location;
    }

    public void setSite_location(String site_location) {
        this.site_location = site_location;
    }

    public String getSite_mrentprice() {
        return site_mrentprice;
    }

    public void setSite_mrentprice(String site_mrentprice) {
        this.site_mrentprice = site_mrentprice;
    }

    public StateInfo getState() {
        return state;
    }

    public void setState(StateInfo state) {
        this.state = state;
    }
}
