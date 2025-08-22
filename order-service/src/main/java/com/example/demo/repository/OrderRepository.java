package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;


@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {



}
