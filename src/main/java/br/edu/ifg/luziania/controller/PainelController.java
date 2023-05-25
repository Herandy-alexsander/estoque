package br.edu.ifg.luziania.controller;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/panel")
public class PainelController {
    @Inject
    Template painel;

    @GET
    public TemplateInstance showLoginPage() {
        return painel.instance().data("title", "Mary");
    }

}
