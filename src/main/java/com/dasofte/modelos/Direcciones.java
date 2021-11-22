package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "direcciones")
@Entity
public class Direcciones extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_direcciones")
    @SequenceGenerator(name = "sq_direcciones", sequenceName = "sq_direcciones_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "direccion", length = 100)
    public String direccion;

    @ManyToOne
    @JoinColumn(name = "pais")
    public Pais pais;

    @ManyToOne
    @JoinColumn(name = "provincia")
    public Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "ciudad")
    public Ciudades ciudad;

    @Column(name = "referencia", length = 100)
    public String referencia;

}