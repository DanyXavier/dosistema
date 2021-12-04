package com.dasofte;

import com.dasofte.modelos.Areas;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/area")
public class AreaResource {

    @POST
    @Transactional
    public Response guardarImportancia(Areas areas){
        areas.persist();
        return Response.ok(areas).build();
    }
    @GET
    public Response obtenerAreas(){
        return Response.ok(Areas.listAll()).build();
    }
}
