package com.dasofte;

import com.dasofte.modelos.Usuario;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {

    @GET
    @Path("todos")
    public Response obtenerUsuarios(){
        return Response.ok(Usuario.listAll()).build();
    }

    @POST
    @Path("save")
    @Transactional
    public Response guardarUsuario(Usuario usuarios){
        usuarios.persist();
        return Response.ok(usuarios).build();
    }
}
/*
@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
 @RegisterRestClient
 public interface MultipartService {

 @POST
 @Consumes(MediaType.MULTIPART_FORM_DATA)
 @Produces(MediaType.TEXT_PLAIN)
 String sendMultipartData(@MultipartForm MultipartBody data);
 # Your configuration properties
org.acme.rest.client.multipart.MultipartService/mp-rest/url=http://localhost:8080/
 */