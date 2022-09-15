package com.jalgoz.ventas.controller;

import com.jalgoz.ventas.model.Cliente;
import com.jalgoz.ventas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Le decimos que será con el método get
    @GetMapping
    public ResponseEntity<List<Cliente>> findall() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    // Le decimos que será con el método get pero tambien recibirá un id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findByID(@PathVariable("id") Integer id) { // El id recibido sera el Integer id
        // Buscamos por ID en caso de ser encontrado OK, en cado de no ser encontrado error not found
        return clienteService.findByID(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Le decimos que utilizará el método de post
    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) { // EL @Valid es para que nos mande el código de error correcto en el caso de error, el @RequestBody es para decirle que el cliente estará en el cuerpo
        // Retornamos un nueva intancia de ResponseEntity al crear el cliente y retornaremos el estado de creado
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    // Le decimos que utilizará el método de put porque es para actualizar
    @PutMapping
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {
        // Para actualizar primero verificamos que exista el cliente
        return clienteService.findByID(cliente.getIdCliente())
                .map(c -> ResponseEntity.ok(clienteService.update(cliente))) // En caso de que el cliente si existe
                .orElseGet(() -> ResponseEntity.notFound().build()); // En caso de que el cliente no existe
    }

    // Le decimos que utilizará el método de delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer idCliente) {
        return clienteService.findByID(idCliente)
                .map(c -> {
                    clienteService.delete(idCliente);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
