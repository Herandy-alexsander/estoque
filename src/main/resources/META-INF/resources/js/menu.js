$(document).ready(function () {
    // Ao clicar em um item do menu
    $("#menu a").click(function (event) {
        event.preventDefault();

        // Remove a classe 'active' de todos os itens do menu
        $("#menu a").removeClass("active");

        // Adiciona a classe 'active' ao item do menu clicado
        $(this).addClass("active");

        // Obtém o valor do atributo 'data-target' do item do menu clicado
        var target = $(this).data("target")
        // Carrega o conteúdo correspondente ao item selecionado
        if (target === "cadastro") {
            if (!$('div.cadatro').length > 0) {
                $('div.login').remove();
                renderCadastroForm();
            } else {
                alert("Já selecionado");
            }
        } else if (target === "login") {
            if (!$('div.login').length > 0) {
                $('div.cadatro').remove();
                renderLoginForm();
            } else {
                alert("Já selecionado");
            }
        }


    });



    // Carrega o conteúdo do primeiro item do menu ao carregar a página


});