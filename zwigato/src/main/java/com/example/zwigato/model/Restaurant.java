package com.example.zwigato.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private String location;

    boolean isOpen;

    @CreationTimestamp
    Date registeredAt;

    @ManyToMany(mappedBy = "restaurants")
    @JsonIgnore
    private List<MenuItem> menuItems;



}
