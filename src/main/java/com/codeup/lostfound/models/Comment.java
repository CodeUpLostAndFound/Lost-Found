package com.codeup.lostfound.models;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}