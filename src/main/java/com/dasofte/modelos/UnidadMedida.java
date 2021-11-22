package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "unidad_medida")
@Entity
public class UnidadMedida extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_unidad_medida")
    @SequenceGenerator(name = "sq_unidad_medida", sequenceName = "sq_unidad_medida_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "simbolo", length = 5)
    public String simbolo;

    @Column(name = "medida", length = 15)
    public String medida;

}