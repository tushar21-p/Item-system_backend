package com.tushar.g2g.g2g.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userModel {
    private long id;
    private String name;
    private double price;
    private String description;
    private boolean available;

}
