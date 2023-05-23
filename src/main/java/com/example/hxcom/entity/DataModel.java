package com.example.hxcom.entity;

public class DataModel {
    private int userId;
    private int itemId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "userId=" + userId +
                ", itemId=" + itemId +
                ", score=" + score +
                '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;
}
