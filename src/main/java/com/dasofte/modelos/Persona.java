package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "persona")
@Entity
public class Persona extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_persona")
    @SequenceGenerator(name = "sq_persona", sequenceName = "sq_persona_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "nombre", length = 150)
    public String nombre;

    @Column(name = "apellido", length = 150)
    public String apellido;

    @ManyToOne
    @JoinColumn(name = "direccion")
    public Direcciones direccion;

    @Column(name = "cedula", length = 10)
    public String cedula;

    @ManyToOne
    @JoinColumn(name = "sexo")
    public Sexo sexo;

    @Column(name = "path_foto", length = 200)
    public String pathFoto;

}