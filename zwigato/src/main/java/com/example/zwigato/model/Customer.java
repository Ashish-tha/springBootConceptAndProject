package com.example.zwigato.model;

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
