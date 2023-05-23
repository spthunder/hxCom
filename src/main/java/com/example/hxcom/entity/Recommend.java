package com.example.hxcom.entity;

public class Recommend {
    private int id;
    private int userId;
    private int eventId;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id=" + id +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", score=" + score +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;
}
