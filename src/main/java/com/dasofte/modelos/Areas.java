package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "areas")
@Entity
public class Areas extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_areas")
    @SequenceGenerator(name = "sq_areas", sequenceName = "sq_areas_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "area", length = 100)
    public String area;
}