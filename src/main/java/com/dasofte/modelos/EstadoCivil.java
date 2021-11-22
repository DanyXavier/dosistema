package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "estado_civil")
@Entity
public class EstadoCivil extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_estado_civil")
    @SequenceGenerator(name = "sq_estado_civil", sequenceName = "sq_estado_civil_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "estado", length = 30)
    public String estado;

}