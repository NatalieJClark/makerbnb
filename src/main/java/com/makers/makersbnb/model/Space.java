package com.makers.makersbnb.model;

import jakarta.persistence.*;

// @Entity - instances of this class map to database records
@Entity
// @Table - those records can ve found in the spaces table
@Table
public class Space {
    // the following field (id) is the primary key for this Entity
    @Id
    //the value of id is generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // a second field that holds the name of each space
    private String name;

    // a zero-arguments constructor
    public Space() {}

    // a one-argument constructor
    public Space(String name) {
        this.name = name;
    }

    // methods that get and set name
    public String getName() { return this.name; }
    public void setname(String name) { this.name = name; }
}
