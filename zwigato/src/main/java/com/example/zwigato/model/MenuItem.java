package com.example.zwigato.model;


import com.example.zwigato.utility.enums.FoodCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column
    Boolean isVeg;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @OneToMany(mappedBy = "menuItem")
    @JsonIgnore
    private List<OrderItem> orderItems;

    @ManyToMany
    @JsonIgnore
    @JoinTable
    private List<Restaurant> restaurants;

}
