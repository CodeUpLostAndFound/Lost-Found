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
    private String addressOne;

    @Column
    private String addressTwo;

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

    @JoinTable
    private List<Comment> comments;


    public Item() {
    }


    //    new item
    public Item(String title, String description, boolean lost, String img, String addressOne, String addressTwo, String city, String state, String zipcode, List<Category> categories, List<Comment> comments) {

        this.title = title;
        this.description = description;
        this.lost = lost;
        this.img = img;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.categories = categories;
        this.comments = comments;
    }

    public Item(int id, String title, String description, boolean lost, String img, String addressOne, String addressTwo, String city, String state, String zipcode, List<Category> categories, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lost = lost;
        this.img = img;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.categories = categories;
        this.comments = comments;

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

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void save(Item item) {
    }
}