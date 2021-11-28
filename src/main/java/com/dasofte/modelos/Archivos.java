package com.dasofte.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name = "archivos")
@Entity
public class Archivos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_archivos")
    @SequenceGenerator(name = "sq_archivos", sequenceName = "sq_archivos_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "archivo", length = 200)
    public String archivo;

    @Column(name = "ubicacion_fisica", length = 200)
    public String ubicacionFisica;

    @Column(name = "descripcion", length = 200)
    public String descripcion;

    @Column(name = "nota", length = 200)
    public String nota;

    @Column(name = "fecha_creacion")
    public LocalDate fechaCreacion;

    @Column(name = "fecha_subida")
    public LocalDate fechaSubida;

    @ManyToOne
    @JoinColumn(name = "importancia")
    public Importancia importancia;

    @ManyToOne
    @JoinColumn(name = "area")
    public Areas area;

    @Column(name = "estado")
    public Boolean estado;

    @ManyToOne
    @JoinColumn(name = "directorio")
    @JsonIgnoreProperties("archivos")
    public Directorios directorio;


    public static List<Archivos> findByNombre(String nombre){
        String contengan = "%"+nombre+"%";
        return Archivos.find("lower(arc_nombre) LIKE lower(?1)",contengan).list();
    }

    @Override
    public String toString() {
        return "Archivos{" +
                "id=" + id +
                ", archivo='" + archivo + '\'' +
                ", ubicacionFisica='" + ubicacionFisica + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nota='" + nota + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaSubida=" + fechaSubida +
                ", importancia=" + importancia +
                ", area=" + area +
                ", estado=" + estado +
                ", directorio=" + directorio +
                '}';
    }
}
