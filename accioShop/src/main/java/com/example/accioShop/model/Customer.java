package com.example.accioShop.model;


import com.example.accioShop.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
// entity use to map with database table
public class Customer {
    @Id
    private int id;
    private String name;
    private int age;

    // Enumerated used for showing string value same as given in gender
    @Enumerated(value = EnumType.STRING)
    Gender gender=Gender.FEMALE;

    @Column(unique = true)
   private String email;

    @Column(length = 10)
    private String mobNo;


//    @OneToOne(mappedBy = "customer") // Bi-Directional relation
//    Address address;

//    @CreationTimestamp
//    Date createdAt;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;


    @OneToMany(mappedBy = "customer")
    List<Review> reviews=new ArrayList<>();


}
