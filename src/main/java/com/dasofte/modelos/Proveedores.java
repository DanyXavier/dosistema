package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "proveedores")
@Entity
public class Proveedores extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_proveedores")
    @SequenceGenerator(name = "sq_proveedores", sequenceName = "sq_proveedores_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "razon_social", length = 20)
    public String razonSocial;

    @Column(name = "ruc", length = 14)
    public String ruc;

    @Column(name = "observacion", length = 200)
    public String observacion;

    @Column(name = "contacto")
    public Long contacto;

    @ManyToOne
    @JoinColumn(name = "direccion")
    public Direcciones direccion;
}