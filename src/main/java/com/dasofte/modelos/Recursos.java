package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "recursos")
@Entity
public class Recursos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_recursos")
    @SequenceGenerator(name = "sq_recursos", sequenceName = "sq_recursos_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "recurso", length = 100)
    public String recurso;

    @Column(name = "estado_recurso", length = 50)
    public String estadoRecurso;

    @Column(name = "estado")
    public Boolean estado;

    @Column(name = "costo")
    public BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "tipo")
    public TipoRecurso tipo;

    @Override
    public String toString() {
        return "Recursos{" +
                "id=" + id +
                ", recurso='" + recurso + '\'' +
                ", estadoRecurso='" + estadoRecurso + '\'' +
                ", estado=" + estado +
                ", costo=" + costo +
                ", tipo=" + tipo +
                '}';
    }
    public static Recursos findByRecurso(String recurso){
        return find("recurso",recurso).firstResult();
    }
}