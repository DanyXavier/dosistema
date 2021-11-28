package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "importancia")
@Entity
public class Importancia extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_importancia")
    @SequenceGenerator(name = "sq_importancia", sequenceName = "sq_importancia_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "importancia", length = 20)
    public String importancia;

}