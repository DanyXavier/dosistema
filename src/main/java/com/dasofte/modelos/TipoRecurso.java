package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "tipo_recurso")
@Entity
public class TipoRecurso extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tipo_recurso")
    @SequenceGenerator(name = "sq_tipo_recurso", sequenceName = "sq_tipo_recurso_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "stock")
    public Long stock;

    @Column(name = "tipo", length = 50)
    public String tipo;

}