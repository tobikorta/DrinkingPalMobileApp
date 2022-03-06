package com.ts.tk.drinkingpalmobileapp.dtos;

import java.util.Date;

public class Event {

    private Long id;
    private Date date;
    private Bar bar;
    private UserData creator;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public UserData getCreator() {
        return creator;
    }

    public void setCreator(UserData creator) {
        this.creator = creator;
    }
}
