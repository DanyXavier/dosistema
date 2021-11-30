package com.dasofte;

import com.dasofte.modelos.*;
import com.dasofte.modelos.form.Data;
import com.dasofte.modelos.form.Paginacion;
import com.dasofte.services.UploadFileService;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/archivo")
public class ArchivoResource {

    @Inject
    UploadFileService service;

    @GET
    @Transactional
    public Response obtenerArchivos(){
        return Response.ok(Archivos.listAll()).build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response guardarArchivo(@MultipartForm Data data){
        System.out.println(data);
        Archivos archivo = new Archivos();
        Areas area = new Areas();
        area.id =Long.parseLong(data.area);
        archivo.area = area;
        archivo.descripcion = data.descripcion;
        archivo.estado = Boolean.parseBoolean(data.estado);
        archivo.fechaCreacion = LocalDate.parse(data.fechaCreacion) ;
        archivo.fechaSubida = LocalDate.parse(data.fechaSubida) ;
        Importancia importancia = new Importancia();
        importancia.id = Long.parseLong(data.importancia);
        archivo.importancia = importancia;
        archivo.nota = data.nota;
        archivo.ubicacionFisica = data.ubicacionFisica;
        Directorios directorio = new Directorios();
        directorio.id = Long.parseLong(data.directorioId);
        archivo.directorio = directorio;
        archivo.archivo = service.guardarArchivo(data.file, data.dirName);
        archivo.persist();
        return Response.ok(archivo).build();
    }

    @GET
    @Path("find_by_nombre")
    public Response obtenerArchivosPorNombre(@QueryParam("nombre") String nombre){
        return Response.ok(Archivos.findByNombre(nombre)).build();
    }
}
