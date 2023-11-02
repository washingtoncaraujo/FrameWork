package com.bddev.bd_semana3.repository;

import com.bddev.bd_semana3.model.Category;
import com.bddev.bd_semana3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    // Método de consulta para encontrar produtos por categoria.
    List<Product> findByCategory(Category category);

    // Consulta personalizada via SQL nativo para encontrar produtos com preço abaixo de um valor máximo
    @Query(value = "SELECT x FROM product p WHERE p.price < :maxPrice", nativeQuery = true)

    List<Product> findProductsBelowMaxPrice(@Param("maxPrice") double maxPrice);

}

