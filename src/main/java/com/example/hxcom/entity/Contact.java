package com.example.hxcom.entity;

public class Contact {
    private int id;
    private int contact;
    private int beContacted;
    private String contactName;
    private String time;
    private int event;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contact=" + contact +
                ", beContacted=" + beContacted +
                ", contactName='" + contactName + '\'' +
                ", time='" + time + '\'' +
                ", event=" + event +
                '}';
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getBeContacted() {
        return beContacted;
    }

    public void setBeContacted(int beContacted) {
        this.beContacted = beContacted;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
