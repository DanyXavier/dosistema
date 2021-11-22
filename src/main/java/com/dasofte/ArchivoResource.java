package com.dasofte;

import com.dasofte.modelos.Archivos;
import com.dasofte.modelos.Directorios;
import com.dasofte.modelos.Empleados;
import com.dasofte.modelos.Usuario;
import com.dasofte.modelos.form.Data;
import com.dasofte.services.UploadFileService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Path("/archivo")
public class ArchivoResource {

    @Inject
    UploadFileService service;

    @GET
    @Path("todos")
    public Response obtenerArchivos(){
        return Response.ok(Archivos.listAll()).build();
    }

    @POST
    @Path("save")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response guardarArchivo(@MultipartForm Data data){
        System.out.println(data);
        Archivos archivo = new Archivos();
        archivo.area = Long.parseLong(data.area);
        archivo.descripcion = data.descripcion;
        archivo.estado = Boolean.parseBoolean(data.estado);
        //archivo.nombre = data.nombre;
        archivo.fechaCreacion = LocalDate.parse(data.fechaCreacion) ;
        archivo.fechaSubida = LocalDate.parse(data.fechaSubida) ;
        archivo.importancia = Long.parseLong(data.importancia);
        archivo.nota = data.nota;
        archivo.tipoDocumento = Long.parseLong(data.tipo);
        archivo.ubicacionFisica = data.ubicacionFisica;
        Directorios directorio = new Directorios();
        directorio.id = Long.parseLong(data.directorioId);
        archivo.directorio = directorio;
        archivo.archivo = service.guardarArchivo(data.file, data.dirName);
                //UploadFileService.guardarArchivo(data.files, data.dirName);
        archivo.persist();
        return Response.ok(archivo).build();
    }

    @GET
    @Path("find_by_nombre")
    public Response obtenerArchivosPorNombre(@QueryParam("nombre") String nombre){
        return Response.ok(Archivos.findByNombre(nombre)).build();
    }
}
