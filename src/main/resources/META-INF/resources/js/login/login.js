$(document).ready(function () {
    renderCadastroForm();
    $("#loginForm").submit(function (event) {
        event.preventDefault();

        var username = $('#username').val();
        var password = $('#password').val();

        var loginData = {
            email: username,
            senha: password
        };

        $.ajax({
            url: '/login',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(loginData),
            success: function (response) {
                alert('Login realizado com sucesso!');
            },
            error: function (error) {
                alert('Ocorreu um erro ao realizar o login.');
            }
        });
    });
    $('#cadastroForm').submit(function(e) {
        e.preventDefault();

        // Limpar mensagens de erro e estilos de campo inválido
        $('.form-group').removeClass('has-error');
        $('.help-block').remove();

        // Obter os valores dos campos
        var nome = $('#nome').val();
        var email = $('#email').val();
        var senha = $('#senha').val();
        var confirmarSenha = $('#Comfirmasenha').val();

        // Validar campos
        var isValid = true;

        if (nome.trim() === '') {
            isValid = false;
            $('#nome').closest('.form-group').addClass('has-error');
            $('#nome').after('<span class="help-block">Campo obrigatório</span>');
        }

        if (email.trim() === '') {
            isValid = false;
            $('#email').closest('.form-group').addClass('has-error');
            $('#email').after('<span class="help-block">Campo obrigatório</span>');
        } else if (!validateEmail(email)) {
            isValid = false;
            $('#email').closest('.form-group').addClass('has-error');
            $('#email').after('<span class="help-block">E-mail inválido</span>');
        }

        if (senha.trim() === '') {
            isValid = false;
            $('#senha').closest('.form-group').addClass('has-error');
            $('#senha').after('<span class="help-block">Campo obrigatório</span>');
        }

        if (confirmarSenha.trim() === '') {
            isValid = false;
            $('#Comfirmasenha').closest('.form-group').addClass('has-error');
            $('#Comfirmasenha').after('<span class="help-block">Campo obrigatório</span>');
        } else if (confirmarSenha !== senha) {
            isValid = false;
            $('#Comfirmasenha').closest('.form-group').addClass('has-error');
            $('#Comfirmasenha').after('<span class="help-block">As senhas não coincidem</span>');
        }

        // Submeter o formulário se todos os campos forem válidos
        if (isValid) {
            // Faça o que for necessário com os dados do formulário
            alert('Cadastro enviado!');
        }
    });

    // Função para validar o formato do e-mail usando regex
    function validateEmail(email) {
        var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }

});


