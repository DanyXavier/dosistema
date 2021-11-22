package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sucursal")
@Entity
public class Sucursal extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String id;

    @Column(name = "sucursal", length = 40)
    public String sucursal;
}