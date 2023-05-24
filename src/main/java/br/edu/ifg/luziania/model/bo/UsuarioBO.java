package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.entity.Usuario;
import br.edu.ifg.luziania.model.util.TipoUsuario;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@Dependent
public class UsuarioBO {
    @Inject
    UsuarioDAO usuarioDAO;
    @Transactional
    public RespostaDTO cadastrarUsuario(UsuarioDTO dadoDTO) {
        RespostaDTO respostaDTO = new RespostaDTO();

        // Criar uma instância da entidade Usuario
        Usuario entity = new Usuario();
        System.out.println(dadoDTO.getEmail());
        entity.setEmail(dadoDTO.getEmail());
        entity.setNomeUsuario(dadoDTO.getNome());
        entity.setSenha(dadoDTO.getSenha());
        entity.setTipoUsuario(TipoUsuario.ADMIN); // Definir o tipo de usuário, por exemplo, ADMIN

        try {
            // Inserir a entidade no banco de dados usando o DAO
            usuarioDAO.insert(entity);

            // Configurar a resposta de sucesso
            respostaDTO.setStatus(200);
            respostaDTO.setMensagem("Usuário salvo com sucesso!");
            respostaDTO.setUrl("/");
        } catch (Exception e) {
            // Configurar a resposta de erro
            respostaDTO.setStatus(500);
            respostaDTO.setMensagem("Falha ao salvar usuário!");
            respostaDTO.setUrl("/");
        }

        return respostaDTO;
    }
}
