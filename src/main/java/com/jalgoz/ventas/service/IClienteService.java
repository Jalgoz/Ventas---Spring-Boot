package com.jalgoz.ventas.service;

import com.jalgoz.ventas.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    // Para obtener todos los datos de la tabla cliente
    List<Cliente> findAll();

    // Para obtener un cliente según su ID
    Optional<Cliente> findByID(Integer id);

    // Para crear al cliente
    Cliente create(Cliente cliente);

    // Para actualizar
    Cliente update(Cliente cliente);

    // Para eliminar cliente
    void delete (Integer id);
}
