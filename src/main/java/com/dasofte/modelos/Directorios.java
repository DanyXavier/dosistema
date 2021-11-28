package com.dasofte.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy = "directorio")
    @JsonIgnoreProperties("directorio")
    public Set<Archivos> archivos;

    @Override
    public String toString() {
        return "Directorios{" +
                "id=" + id +
                ", directorio='" + directorio + '\'' +
                ", archivos=" + archivos +
                '}';
    }
}