package com.restaurant.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.restaurant.management.entities.Transport;

public interface TransportRepository extends JpaRepository<Transport, Long>, QuerydslPredicateExecutor<Transport> {

}
