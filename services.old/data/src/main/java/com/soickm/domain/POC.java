package com.soickm.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

public class POC {
    private String _id;
    private String guid;
    private String account;
    private String campaign;
    private boolean isActive;
    private String amount;
    ArrayList< Object > product = new ArrayList < Object > ();
    private String comments;
    ArrayList < Object > people = new ArrayList < Object > ();
    ArrayList < Object > issues = new ArrayList < Object > ();
    ArrayList < Object > tags = new ArrayList < Object > ();

    // Getter Methods
    public String get_id() {
        return _id;
    }

    public String getGuid() {
        return guid;
    }

    public String getAccount() {
        return account;
    }

    public String getCampaign() {
        return campaign;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getAmount() {
        return amount;
    }

    public String getComments() {
        return comments;
    }

    // Setter Methods

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setAmount(String ammount) {
        this.amount = ammount;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public POC findByAccount(String account) {
        return new POC();
    }

}