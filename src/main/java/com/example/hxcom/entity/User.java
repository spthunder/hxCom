package com.example.hxcom.entity;

public class User {
    private int id;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    private String img;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", tag=" + tag +
                ", password='" + password + '\'' +
                ", collectList='" + collectList + '\'' +
                ", inProcess='" + inProcess + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }

    private String tel;
    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    private int tag;
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String password;
    private String collectList;
    private String inProcess;
    private int age;

    public String getCollectList() {
        return collectList;
    }

    public void setCollectList(String collectList) {
        this.collectList = collectList;
    }

    public String getInProcess() {
        return inProcess;
    }

    public void setInProcess(String inProcess) {
        this.inProcess = inProcess;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int role;
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
