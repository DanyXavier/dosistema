package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "pais")
@Entity
public class Pais extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pais")
    @SequenceGenerator(name = "sq_pais", sequenceName = "sq_pais_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "pais", length = 100)
    public String pais;
}