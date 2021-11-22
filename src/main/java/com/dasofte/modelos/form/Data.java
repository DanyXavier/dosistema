package com.dasofte.modelos.form;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.ws.rs.FormParam;

public class Data {
    @FormParam("directorioId")
    public String directorioId;
    @FormParam("dirName")
    public String dirName;
    @FormParam("nombre")
    public String nombre;
    @FormParam("ubicacionFisica")
    public String ubicacionFisica;
    @FormParam("area")
    public String area;
    @FormParam("importancia")
    public String importancia;
    @FormParam("descripcion")
    public String descripcion;
    @FormParam("fechaCreacion")
    public String fechaCreacion;
    @FormParam("fechaSubida")
    public String fechaSubida;
    @FormParam("tipo")
    public String tipo;
    //public Usuarios usId;
    @FormParam("nota")
    public String nota;
    //public Empleado empId;
    @FormParam("estado")
    public String estado;
    //public Directorio dirId;
    @FormParam("file")
    public InputPart file;

    public Data(String directorioId, String dirName, String nombre, String ubicacionFisica, String area, String importancia, String descripcion, String fechaCreacion, String fechaSubida, String tipo, String nota, String estado, InputPart file) {
        this.directorioId = directorioId;
        this.dirName = dirName;
        this.nombre = nombre;
        this.ubicacionFisica = ubicacionFisica;
        this.area = area;
        this.importancia = importancia;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaSubida = fechaSubida;
        this.tipo = tipo;
        this.nota = nota;
        this.estado = estado;
        this.file = file;
    }

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
                "directorioId='" + directorioId + '\'' +
                ", dirName='" + dirName + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacionFisica='" + ubicacionFisica + '\'' +
                ", area='" + area + '\'' +
                ", importancia='" + importancia + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaSubida='" + fechaSubida + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nota='" + nota + '\'' +
                ", estado='" + estado + '\'' +
                ", file=" + file +
                '}';
    }
}
