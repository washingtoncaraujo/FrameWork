package com.dev.backend_render;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Product, Long>{ // Método de consulta para encontrar produtos por categoria.
    
    @Query(value = "SELECT * FROM cliente ORDER BY name", nativeQuery = true)
    List<Cliente> findClienteOrder();

   
}

