package com.example.zwigato.model;

import com.example.zwigato.utility.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column(nullable = false,length = 10)
    private String mobNo;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Address> address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderEntity> orders;

}
