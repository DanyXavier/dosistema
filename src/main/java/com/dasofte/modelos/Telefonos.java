package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "telefonos")
@Entity
public class Telefonos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_telefonos")
    @SequenceGenerator(name = "sq_telefonos", sequenceName = "sq_telefonos_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "extension", length = 5)
    public String extension;

    @Column(name = "telefono", length = 10)
    public String telefono;
}