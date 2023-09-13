var pacientes = document.querySelectorAll(".paciente");

for(let i=0; i < pacientes.length; i++){
    const paciente = pacientes[i];

    var tdPeso = paciente.querySelector(".info-peso");
    var peso = tdPeso.textContent;

    var tdAltura = paciente.querySelector(".info-altura");
    var altura = tdAltura.textContent;

    var tdImc = paciente.querySelector(".info-imc");

    var pesoEhvalido = true;
    var alturaEhValida = true;

    if( peso <=0 || peso >= 300){
        pesoEhvalido = false;
        tdImc.textContent = "Peso inválido";
        paciente.classList.add("paciente-invalido");
    }

    if (peso<=0 || altura >= 3){
        alturaEhValida = false;
        tdImc.textContent = "Altura Invalida";
        paciente.classList.add("paciente-invalido");

    }

    if (pesoEhvalido && alturaEhValida) {
        const imcCalculado = calcularImc(peso, altura);

        tdImc.textContent = imcCalculado;
    }

    function calcularImc(peso, altura){
        var imc = 0;
        imc = peso / (altura * altura);
        return imc.toFixed(2);
    }
}