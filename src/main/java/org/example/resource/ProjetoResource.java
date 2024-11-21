package org.example.resource;

import org.example.bo.ProjetoBO;
import org.example.model.Projeto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/projetos")
public class ProjetoResource {

    private final ProjetoBO projetoBO;

    public ProjetoResource() throws Exception {
        this.projetoBO = new ProjetoBO();
    }

    // Criar um projeto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/criar")
    public Response criarProjeto(Projeto projeto) {
        try {
            boolean criado = projetoBO.criarProjeto(projeto);
            if (criado) {
                return Response.status(Response.Status.CREATED).entity("Projeto criado com sucesso!").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Falha ao criar o projeto.").build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar o projeto: " + e.getMessage()).build();
        }
    }

    // Buscar projeto por ID
    @GET
    @Path("/busca/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarProjetoPorId(@PathParam("id") int id) {
        try {
            Projeto projeto = projetoBO.buscarProjetoPorId(id);
            return Response.ok(projeto).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
