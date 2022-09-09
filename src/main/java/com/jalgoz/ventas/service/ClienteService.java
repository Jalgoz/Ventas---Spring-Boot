package com.jalgoz.ventas.service;

import com.jalgoz.ventas.model.Cliente;
import com.jalgoz.ventas.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Este estereotipo (@Service) se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación
// y ademas aglutina llamadas a varios repositorios de forma simultánea.
@Service
public class ClienteService implements IClienteService {

    // Inyección de dependencias, como vimos la interfaz del repository IClienteRepository tiene acceso a todas las operaciones del CRUD, por lo cual necesitamos eso acá
    @Autowired // Estara siempre disponible en el servicio de ClienteService
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Es Optional por que retorna un Optional
    @Override
    public Optional<Cliente> findByID(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}
