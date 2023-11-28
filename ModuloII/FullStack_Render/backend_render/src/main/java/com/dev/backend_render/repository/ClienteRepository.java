package com.dev.backend_render.repository;


import com.dev.backend_render.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{ // Método de consulta para encontrar produtos por categoria.


    @Query(value = "SELECT * FROM cliente ORDER BY usuario", nativeQuery = true)
    List<Cliente> findClienteOrder();

}

