package com.example.accioShop.model;

import com.example.accioShop.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    int id;

    @Column
    String name;

    @Column
    int price;

    @Column
            @Enumerated(value=EnumType.STRING)
    Category category;

    @ManyToOne
            @JoinColumn(name="seller_id")
    Seller seller;

    @OneToMany(mappedBy = "product")
    List<Review> reviews=new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<orderEntity> orders=new ArrayList<>();

}
