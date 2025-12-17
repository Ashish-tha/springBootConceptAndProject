package com.example.zwigato.model;

import com.example.zwigato.utility.enums.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

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
}
