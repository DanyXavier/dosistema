package com.dasofte;

import com.dasofte.modelos.Directorios;
import com.dasofte.modelos.Importancia;
import com.dasofte.services.UploadFileService;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/directorio")
public class DirectorioResource {
    @Inject
    UploadFileService service;
    @GET
    public Response obtenerLosDirectorios(){
        return Response.ok(Directorios.listAll()).build();
    }
    @POST
    @Transactional
    public Response guardarDirectorio(Directorios directorio){
         if (service.crearDirectorio(directorio)== null){
             return Response.ok("no se creo el directorio").build();
         }
        directorio.persist();
        return Response.ok(directorio).build();
    }
    @POST
    @Path("importancia")
    @Transactional
    public Response guardarImportancia(Importancia importancia){
        importancia.persist();
        return Response.ok(importancia).build();
    }
    @GET
    @Path("importancia")
    public Response obtenerImportancia(){
        return Response.ok(Importancia.listAll()).build();
    }
}
