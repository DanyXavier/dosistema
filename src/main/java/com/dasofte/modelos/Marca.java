package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "marca")
@Entity
public class Marca extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_marca")
    @SequenceGenerator(name = "sq_marca", sequenceName = "sq_marca_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Lob
    @Column(name = "marca")
    public String marca;
}