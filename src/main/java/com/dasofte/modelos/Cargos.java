package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "cargos")
@Entity
public class Cargos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cargos")
    @SequenceGenerator(name = "sq_cargos", sequenceName = "sq_cargos_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "cargo", length = 100)
    public String cargo;

}