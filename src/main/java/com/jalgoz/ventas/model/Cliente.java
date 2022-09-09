package com.jalgoz.ventas.model;


import javax.persistence.*;

// Para decirle que se creará con esta clase una tabla con el nombre cliente
@Entity
@Table(name = "cliente")
public class Cliente {

    // Le decimos que el será el ID y que se generara automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Column(name = "direccion", nullable = true, length = 150)
    private String direccion;

    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;

    // Aunque no especifiquemos el nombre de la columna se creará con el nombre del atributo
    @Column(nullable = false, length = 150)
    private String email;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
