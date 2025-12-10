package com.example.accioShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name="adress Details")  // khud ka name dena database m table ka name
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String houseNo;

    @Column
    private int pinCode;

    @Column
    private String city;

    @Column
    private String state;


    @OneToOne // cardinalty
    @JoinColumn(name="customer_id") //foreign key && Uni-Directional Relation
    Customer customer;


}
