package com.codeup.lostfound.models;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="categories")
public class category {

        @Id
        @GeneratedValue
        private long id;

        @Column(nullable = false)
        private String category;

        @ManyToMany(mappedBy = "categories")
        private List<Item> items;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
