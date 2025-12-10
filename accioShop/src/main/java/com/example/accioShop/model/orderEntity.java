package com.example.accioShop.model;

import com.example.accioShop.enums.orderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class orderEntity {

    @Id
   private int id;

    @Column
   private int value;

    @Column
            @Enumerated(value = EnumType.STRING)
    orderStatus status;

    @ManyToMany
            @JoinTable
    List<Product> products=new ArrayList<>();
}
