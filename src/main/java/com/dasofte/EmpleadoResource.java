package com.dasofte;

import com.dasofte.modelos.Empleados;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/empleado")
public class EmpleadoResource {
    @GET
    @Path("todos")
    public Response obtenerEmpleados(){
        return Response.ok(Empleados.listAll()).build();
    }

    @POST
    @Path("save")
    @Transactional
    public Response guardarEmpleado(Empleados empleado){
        empleado.persist();
        return Response.ok(empleado).build();
    }
}
