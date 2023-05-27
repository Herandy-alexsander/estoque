package br.edu.ifg.luziania.model.util;


import io.quarkus.qute.CheckedTemplate;

import io.quarkus.qute.TemplateInstance;


@CheckedTemplate
public class Redirecinar {
    public static native TemplateInstance proibido();

    public static native TemplateInstance login();


    public static TemplateInstance valores(String url) {
    if (url.equals("/")) {
            // Lógica para lidar com a URL raiz
            return login();
        } else {
            // Lógica para lidar com outras situações
            return proibido();
        }
    }
}
