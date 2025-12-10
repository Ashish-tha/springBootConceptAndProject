package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Seller {

    @Id
    private int sId;

    @Column(length = 10,unique = true)
    private String panCard;


    @Column
   private String sellerName;


    @Enumerated(EnumType.STRING)
    Gender gender=Gender.FEMALE;

    @Column(unique = true)
    private String email;


    @Column(length = 10)
   private String mobNo;


    @OneToMany(mappedBy = "seller")
    List<Product> products=new ArrayList<>();

}
