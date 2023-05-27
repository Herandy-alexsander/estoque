package br.edu.ifg.luziania.model.util;


import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Sessao implements Serializable {

    private String usuario;
    private Integer id;

    private TipoUsuario tipoUsuario;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getId(Integer id) {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isSessaoAtiva() {
        return usuario != null && !usuario.isEmpty();
    }
}