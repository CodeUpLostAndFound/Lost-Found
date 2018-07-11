package com.codeup.lostfound.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "lost_or_found", nullable = false)
    private boolean lost;

    @Column
    private String img;

    @Column
    private String address_1;

    @Column
    private String address_2;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipcode;

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="Items_cats",
//            joinColumns={@JoinColumn(name="item_id")},
//            inverseJoinColumns={@JoinColumn(name="category_id")}
//        )
    @JoinTable
    private List<Category> categories;


    public Item() {
    }


    //    new item
    public Item(String title, String description, boolean lost, String img, String address_1, String address_2, String city, String state, String zipcode, List<Category> categories) {

        this.title = title;
        this.description = description;
        this.lost = lost;
        this.img = img;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.categories = categories;
    }

    public Item(int id, String title, String description, boolean lost, String img, String address_1, String address_2, String city, String state, String zipcode, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lost = lost;
        this.img = img;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.categories = categories;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void save(Item item) {
    }
}