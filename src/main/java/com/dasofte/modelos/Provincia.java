package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "provincia")
@Entity
public class Provincia extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_provincia")
    @SequenceGenerator(name = "sq_provincia", sequenceName = "sq_provincia_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "provincia", length = 60)
    public String provincia;
}