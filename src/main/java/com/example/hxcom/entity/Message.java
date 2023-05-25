package com.example.hxcom.entity;

public class Message {
    private int id;
    private String admin;
    private int user;
    private String message;
    private String img;
    private String time;

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", admin='" + admin + '\'' +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", img='" + img + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
