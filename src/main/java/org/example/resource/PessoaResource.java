package org.example.resource;

import org.example.bo.PessoaBO;
import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/pessoa")
public class PessoaResource {

    private PessoaBO pessoaBO = new PessoaBO();

    @POST
    @Path("/fisica/criar")
    @Consumes("application/json")
    public Response salvarPessoaFisica(PessoaFisica pessoaFisica) {
        Boolean resultado = pessoaBO.criarPessoaFisica(pessoaFisica);
        return Response.status(201).entity(resultado).build();
    }

    @POST
    @Path("/juridica/criar")
    @Consumes("application/json")
    public Response salvarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        Boolean resultado = pessoaBO.criarPessoaJuridica(pessoaJuridica);
        return Response.status(201).entity(resultado).build();
    }



    // BUSCANDO PESSOA FISICA POR ID
    @GET
    @Path("/fisica/{id}")
    @Produces("application/json")
    public Response getPessoaFisica(@PathParam("id") int id) {
        PessoaFisica pf = pessoaBO.buscarFisicoPorId(id);
        if(pf.equals(null)){
            return Response.status(Response.Status.BAD_REQUEST).entity("ID nao encontradoou nao existe").build();
        }else {
            return Response.ok(pf).build();
        }
    }


    // BUSCANDO PESSOA JURIDICA POR ID
    @GET
    @Path("/juridica/{id}")
    @Produces("application/json")
    public Response getPessoaJuridica(@PathParam("id") int id) {
        PessoaJuridica pj = pessoaBO.buscarJuridicoPorId(id);
        if(pj.equals(null)){
            return Response.status(Response.Status.BAD_REQUEST).entity("ID nao encontrado ou nao existe").build();
        }else{
            return Response.ok(pj).build();
        }
    }


    // BUSCANDO PESSOA FISICA POR CPF
    @GET
    @Path("/busca/{cpf}")
    @Produces("application/json")
    public Response getPessoaFisica(@PathParam("cpf") String cpf) {
        PessoaFisica pf = pessoaBO.buscarFisicoPorCpf(cpf);
        if(pf.equals(null)){
            return Response.status(Response.Status.BAD_REQUEST).entity("CPF nao encontrado ou nao existe").build();
        }else{
            return Response.ok(pf).build();
        }
    }




    // BUSCANDO PESSOA JURIDICA POR CNPJ
    @GET
    @Path("/buscar/{cnpj}")
    @Produces("application/json")
    public Response getPessoaJuridica(@PathParam("cnpj") String cnpj) {
        PessoaJuridica pj = pessoaBO.buscarJuridicaPorCnpj(cnpj);
        if(pj.equals(null)){
            return Response.status(Response.Status.BAD_REQUEST).entity("CNPJ nao encontrado ou nao existe").build();
        }else{
            return Response.ok(pj).build();
        }
    }
}


