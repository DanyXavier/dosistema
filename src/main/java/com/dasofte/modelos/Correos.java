package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "correos")
@Entity
public class Correos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_correos")
    @SequenceGenerator(name = "sq_correos", sequenceName = "sq_correos_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "correo", length = 150)
    public String correo;
}