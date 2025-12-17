package com.example.zwigato.model;


import com.example.zwigato.utility.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private double totalCost;

    @Column
    @CreationTimestamp
    Date createdAt;

    @Column
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderItem> orderItems;

}
