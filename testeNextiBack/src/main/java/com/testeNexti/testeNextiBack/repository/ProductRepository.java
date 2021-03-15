package com.testeNexti.testeNextiBack.repository;

import com.testeNexti.testeNextiBack.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
