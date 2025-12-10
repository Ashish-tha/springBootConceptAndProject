package com.example.accioShop.repository;

import com.example.accioShop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
