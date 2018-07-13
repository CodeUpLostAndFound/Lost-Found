package com.codeup.lostfound.models;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="categories")
public class Category {

        @Id
        @GeneratedValue
        private int id;

        @Column(nullable = false)
        private String name;

        @ManyToMany(mappedBy = "categories")
        private List<Item> items;


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
}
