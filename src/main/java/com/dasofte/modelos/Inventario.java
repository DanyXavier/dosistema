package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "inventario")
@Entity
public class Inventario extends PanacheEntityBase {
    @Id
    @Column(name = "codigo", nullable = false, length = 10)
    public String id;

    @Column(name = "producto", length = 100)
    public String producto;

    @Column(name = "referencia", length = 100)
    public String referencia;

    @ManyToOne
    @JoinColumn(name = "marca")
    public Marca marca;

    @ManyToOne
    @JoinColumn(name = "unidad_medida")
    public UnidadMedida unidadMedida;

    @Column(name = "costo")
    public BigDecimal costo;

    @Column(name = "precio")
    public BigDecimal precio;

    @Column(name = "activo")
    public Boolean activo;

    @ManyToOne
    @JoinColumn(name = "categoria")
    public Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "sucursal")
    public Sucursal sucursal;

}