package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.RetornoDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.entity.Usuario;

import br.edu.ifg.luziania.model.util.Sessao;
import br.edu.ifg.luziania.model.util.TipoUsuario;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;


@Dependent
public class UsuarioBO {

    @Inject
    UsuarioDAO usuarioDAO;
    @Inject
    Sessao sessao;

    public Response autenticar(AutenticacaoDTO autenticacaoDTO) {
        if (autenticacaoDTO == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Dados obrigatórios não presentes!").build();
        }

        Usuario usuario = usuarioDAO.findByEmailAndSenha(autenticacaoDTO.getEmail(), autenticacaoDTO.getSenha());
        if (usuario != null) {
            sessao.setNomeUsuario(usuario.getNomeUsuario());
            sessao.setId(usuario.getId());
            sessao.setTipoUsuario(usuario.getTipoUsuario());
            return Response.ok(new RetornoDTO("Bem vindo " + usuario.getNomeUsuario() + "!")).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(new RetornoDTO("Usuário não encontrado!")).build();
        }
    }

    public Response logout() {
        sessao.setNomeUsuario(null);
        sessao.setId(null);
        sessao.setTipoUsuario(null);
        return Response.ok(new RespostaDTO(200, "Usuário saiu", "/")).build();
    }

    @Transactional
    public Response cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNomeUsuario(usuarioDTO.getNome());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setTipoUsuario(TipoUsuario.ADMIN); // Definir o tipo de usuário, por exemplo, ADMIN

        try {
            usuarioDAO.insert(usuario);
            return Response.ok(new RespostaDTO(200, "Usuário salvo com sucesso!", "/")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new RespostaDTO(500, "Falha ao salvar usuário!", "/"))
                    .build();
        }
    }
}


