package com.jalgoz.ventas.repository;

import com.jalgoz.ventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

// Al heredar de JpaRepository tendremos acceso a todas las operaciones CRUD que necesita el cliente
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{
}
