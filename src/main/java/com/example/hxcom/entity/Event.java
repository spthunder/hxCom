package com.example.hxcom.entity;

import java.util.Date;

public class Event {
    private Integer id;
    private String title;
    private String name;
    private String location;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", love=" + love +
                ", collect=" + collect +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", tag='" + tag + '\'' +
                ", type=" + type +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    private Integer love;
    private Integer collect;

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String img;
    private String content;
    private String time;
    private String tag;
    private Integer type;
    private String tel;

    public int getId() {
        return id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String  getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
