var botaoPaciente = document.querySelector("#adicionar-paciente");

botaoPaciente.addEventListener('click', function (event) {
    event.preventDefault();
    //Buscar elemento do formulario
    var form = document.querySelector("#form-adiciona");
    var pacienteRetornado = obtemPacienteDoFormulario(form);
    var pacienteTr = montaLinha(pacienteRetornado);

    //buscar elemento da tabela

    var tabela = document.querySelector("#tabela-pacientes");

    // atribuir linha a tabela

    tabela.appendChild(pacienteTr);

});

function obtemPacienteDoFormulario(form) {
    //buscar os valores do formulario
    let paciente = {
        nome: form.nome.value,
        peso: form.peso.value,
        altura: form.altura.value,
        gordura: form.gordura.value,


        //TODO - fazer imc
        imc: calcularImc(form.peso.value, form.altura.value)
    };
    return paciente;
}

function montaLinha(pacienteRetornado){
    //Criar uma linha

    var pacienteTr = document.createElement("tr");
    pacienteTr.classList.add("paciente");

    pacienteTr.appendChild(montarColuna(pacienteRetornado.nome,"info-nome"));
    pacienteTr.appendChild(montarColuna(pacienteRetornado.peso,"info-peso"));
    pacienteTr.appendChild(montarColuna(pacienteRetornado.altura,"info-altura"));
    pacienteTr.appendChild(montarColuna(pacienteRetornado.gordura,"info-gordura"));
    pacienteTr.appendChild(montarColuna(pacienteRetornado.imc,"info-imc"));

    return pacienteTr
}

function montarColuna(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;

}