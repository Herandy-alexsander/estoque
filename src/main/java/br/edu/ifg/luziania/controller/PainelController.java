package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.util.Redirecinar;


import br.edu.ifg.luziania.model.util.Sessao;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/")
public class PainelController {

    @Inject
    Template painel;
    @Inject
    Sessao sessao;
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance principal() {
     System.out.println(sessao.isSessaoAtiva());
        if (sessao.isSessaoAtiva())
            return Redirecinar.valores("/");
        return painel.instance().data("title", "Mary");
    }
}


