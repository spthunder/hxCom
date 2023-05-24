package com.example.hxcom.entity;

public class Collect {
    private int id;
    private int user;
    private int event;
    private String userName;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
}
