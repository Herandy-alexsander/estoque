package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.UsuarioBO;
import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    @Inject
    Template login;

    @Inject
    UsuarioBO usuarioBO;

    @POST
    @Path("/autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        return usuarioBO.autenticar(autenticacaoDTO);
    }
    /**
     * Endpoint para cadastrar um usuário.
     *
     * @param dto Objeto com os dados do usuário a ser cadastrado
     * @return Resposta com o status e mensagem do resultado da operação
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/salvar")
    public Response cadastra(UsuarioDTO dto) {
        RespostaDTO respostaDTO = usuarioBO.cadastrarUsuario(dto);

        return Response
                .status(respostaDTO.getStatus())
                .entity(respostaDTO)
                .build();
    }

    }
