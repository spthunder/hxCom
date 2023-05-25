package com.example.hxcom.entity;

public class Admin {
    private int id;
    private String name;
    private int password;
    private String img;
    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", img='" + img + '\'' +
                ", tel=" + tel +
                ", isSuper=" + isSuper +
                '}';
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(int isSuper) {
        this.isSuper = isSuper;
    }

    private int tel;
    private int isSuper;

}
