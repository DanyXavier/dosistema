package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "sexo")
@Entity
public class Sexo extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_sexo")
    @SequenceGenerator(name = "sq_sexo", sequenceName = "sq_sexo_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "sexo", length = 20)
    public String sexo;

}