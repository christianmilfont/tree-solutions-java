package org.example.resource;

import org.example.bo.PessoaAdminBO;
import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admin")
public class PessoaAdminResource {

    private final PessoaAdminBO pessoaAdminBO;

    public PessoaAdminResource() {
        this.pessoaAdminBO = new PessoaAdminBO();
    }

    // Atualizar Pessoa Física
    @PUT
    @Path("/atualiza/fisica")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarPessoaFisica(@HeaderParam("usuarioId") String usuarioId, PessoaFisica pessoaFisica) {
        try {
            PessoaFisica atualizada = pessoaAdminBO.atualizarPessoaFisica(usuarioId, pessoaFisica);
            return Response.ok(atualizada).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }

    // Atualizar Pessoa Jurídica
    @PUT
    @Path("/atualiza/juridica")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarPessoaJuridica(@HeaderParam("usuarioId") String usuarioId, PessoaJuridica pessoaJuridica) {
        try {
            PessoaJuridica atualizada = pessoaAdminBO.atualizarPessoaJuridica(usuarioId, pessoaJuridica);
            return Response.ok(atualizada).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }

    // Deletar Pessoa Física
    @DELETE
    @Path("/delete/fisica/{cpf}")
    public Response deletarPessoaFisica(@HeaderParam("usuarioId") String usuarioId, @PathParam("cpf") String cpf) {
        try {
            pessoaAdminBO.deletarPessoaFisica(usuarioId, cpf);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }

    // Deletar Pessoa Jurídica
    @DELETE
    @Path("/delete/juridica/{cnpj}")
    public Response deletarPessoaJuridica(@HeaderParam("usuarioId") String usuarioId, @PathParam("cnpj") String cnpj) {
        try {
            pessoaAdminBO.deletarPessoaJuridica(usuarioId, cnpj);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
        }
    }
}
