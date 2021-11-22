package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "empleados")
@Entity
public class Empleados extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_empleados")
    @SequenceGenerator(name = "sq_empleados", sequenceName = "sq_empleados_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "cargo")
    public Cargos cargo;

    @ManyToOne
    @JoinColumn(name = "area")
    public Areas area;

    @Column(name = "sueldo")
    public BigDecimal sueldo;

    @Column(name = "fecha_ingreso")
    public LocalDate fechaIngreso;

    @Column(name = "comentario", length = 200)
    public String comentario;

    @Column(name = "fecha_nacimiento")
    public LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "persona")
    public Persona persona;
}