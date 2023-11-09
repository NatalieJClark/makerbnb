package com.makers.makersbnb.model;

import jakarta.persistence.*;

// @Entity - instances of this class map to database records
@Entity
// @Table - those records can be found in the spaces table
@Table
public class Space {
    // id field is the primary key for this Entity
    @Id
    //the value of id is generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // field which holds the name of each space
    private String name;

    // field which holds the description of each space
    private String description;

    // field which hold the price of each space
    private int price;


    // a zero-arguments constructor
    public Space() {}

    // constructor
    public Space(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // methods that get and set name
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    // methods that get and set description
    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    // methods that get and set price
    public int getPrice() { return this.price; }
    public void setPrice(int price) { this.price = price; }
}
