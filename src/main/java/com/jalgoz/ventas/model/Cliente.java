package com.jalgoz.ventas.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Para decirle que se creará con esta clase una tabla con el nombre cliente
@Entity
@Table(name = "cliente")
public class Cliente {

    // Le decimos que el será el ID y que se generara automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull(message = "El nombre es obligatorio") // Validación al momento de ingresar los datos
    @NotBlank(message = "El nombre es obligatorio") // Validación al momento de ingresar los datos
    @Size(min = 2, max = 70, message = "El nombre debe ser mayor a 2 carácteres y menor a 70 carácteres") // Validación al momento de ingresar los datos
    @Column(name = "nombre", nullable = false, length = 70) // Validaciones de la base de datos
    private String nombre;

    @NotNull(message = "El apellido es obligatorio") // Validación al momento de ingresar los datos
    @NotBlank(message = "El apellido es obligatorio") // Validación al momento de ingresar los datos
    @Size(min = 2, max = 70, message = "El apellido debe ser mayor a 2 carácteres y menor a 70 carácteres") // Validación al momento de ingresar los datos
    @Column(name = "apellidos", nullable = false, length = 70) // Validaciones de la base de datos
    private String apellidos;

    @Size(max = 150, message = "La dirección debe ser menor a 150 carácteres") // Validación al momento de ingresar los datos
    @Column(name = "direccion", nullable = true, length = 150) // Validaciones de la base de datos
    private String direccion;

    @Size(max = 12, message = "El telefono debe ser mayor a 8 carácteres y menor que 12 carácteres") // Validación al momento de ingresar los datos
    @Column(name = "telefono", nullable = true, length = 12) // Validaciones de la base de datos
    private String telefono;

    // Aunque no especifiquemos el nombre de la columna se creará con el nombre del atributo
    @NotNull(message = "El email es obligatorio") // Validación al momento de ingresar los datos
    @NotBlank(message = "El email es obligatorio") // Validación al momento de ingresar los datos
    @Size(min = 8, max = 150, message = "El email debe tener al menos 8 carácteres y menor a 150 carácteres") // Validación al momento de ingresar los datos
    @Email(message = "El email ingresado no tiene el formato válido")
    @Column(nullable = false, length = 150) // Validaciones de la base de datos
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
