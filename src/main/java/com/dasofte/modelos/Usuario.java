package com.dasofte.modelos;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity
public class Usuario extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuarios")
    @SequenceGenerator(name = "sq_usuarios", sequenceName = "sq_usuarios_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "usuario", length = 50)
    public String usuario;

    @Column(name = "clave", length = 30)
    public String clave;

    @Column(name = "autorizado")
    public Boolean autorizado;

    @Column(name = "activo")
    public Boolean activo;


}