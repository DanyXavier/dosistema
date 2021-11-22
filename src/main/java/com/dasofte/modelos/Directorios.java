package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "directorios")
@Entity
public class Directorios extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_directorios")
    @SequenceGenerator(name = "sq_directorios", sequenceName = "sq_directorios_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "directorio", length = 60)
    public String directorio;

}