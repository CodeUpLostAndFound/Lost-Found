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
        private String category;

        @ManyToMany(mappedBy = "categories")
        private List<Item> items;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
