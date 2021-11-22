package com.dasofte;

import com.dasofte.modelos.Recursos;
import com.dasofte.modelos.TipoRecurso;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/recurso")
public class RecursoResource {

    @POST
    @Path("guardar_tipo_recurso")
    @Transactional
    public Response guardarTipoRecurso(TipoRecurso tipoRecurso){
        tipoRecurso.persist();
        return Response.ok(tipoRecurso).build();
    }
    @POST
    @Path("guardar_recurso")
    @Transactional
    public Response guardarRecurso(Recursos recursos){
        recursos.persist();
        return Response.ok(recursos).build();
    }
    @GET
    @Path("obtener_recurso")
    public Response obtenerRecursos(){
        return Response.ok(Recursos.listAll()).build();
    }
    @GET
    @Path("obtener_recurso/{recurso}")
    public Response obtenerRecurso(String recurso){
        return Response.ok(Recursos.findByRecurso(recurso)).build();
    }
}
