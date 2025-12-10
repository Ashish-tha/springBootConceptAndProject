package com.example.accioShop.controller;


import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ReactiveOffsetScrollPositionHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        Customer savedCustomner=customerService.addCustomer(customer);
        return new ResponseEntity(savedCustomner, HttpStatus.CREATED);
    }

   // @GetMapping
//    public ResponseEntity getCustomerById(@RequestParam("id") int id){
//        try{
//            customerService.getCustomerById(id);
//        } catch (CustomerNotFoundException e);
//    }
}
