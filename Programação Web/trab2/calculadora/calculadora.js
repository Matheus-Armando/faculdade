let valorAtual = '';
let valorAnterior = '';
let operador = '';

function adicionarNumero(numero) {
  valorAtual += numero;
  atualizarResultado();
}

function adicionarOperador(op) {
  if (valorAtual !== '') {
    if (operador !== '') {
      calcular();
    }
    operador = op;
    valorAnterior = valorAtual;
    valorAtual = '';
    atualizarResultado();
  }
}

function adicionarDecimal(decimal) {
  if (valorAtual.indexOf('.') === -1) {
    valorAtual += decimal;
    atualizarResultado();
  }
}

function calcular() {
  if (valorAtual !== '' && valorAnterior !== '') {
    const num1 = parseFloat(valorAnterior);
    const num2 = parseFloat(valorAtual);

    switch (operador) {
      case '+':
        valorAtual = String(num1 + num2);
        break;
      case '-':
        valorAtual = String(num1 - num2);
        break;
      case '*':
        valorAtual = String(num1 * num2);
        break;
      case '/':
        if (num2 !== 0) {
          valorAtual = String(num1 / num2);
        } else {
          valorAtual = 'Erro';
        }
        break;
    }

    operador = '';
    valorAnterior = '';
    atualizarResultado();
  }
}

function limpar() {
  valorAtual = '';
  valorAnterior = '';
  operador = '';
  atualizarResultado();
}

function atualizarResultado() {
  document.getElementById('resultado').value = valorAtual;
}

// document.addEventListener('keydown', function(event) {
//     const teclaPressionada = event.key;
//     const teclaCode = event.code;
  
//     if (/[0-9+\-*/.=]|Enter/.test(teclaPressionada)) {
//       if (teclaPressionada === '.') {
//         adicionarDecimal(teclaPressionada);
//       } else if (teclaPressionada === '=' || teclaPressionada === 'Enter') {
//         calcular();
//       } else if (/[+\-*/]/.test(teclaPressionada)) {
//         adicionarOperador(teclaPressionada);
//       } else if (teclaCode === 'C' || teclaCode === 'c') {
//         limpar();
//       } else {
//         adicionarNumero(teclaPressionada);
//       }
//     }
//   });

  document.addEventListener('keydown', function(event) {
    const teclaPressionada = event.key;
    const teclaCode = event.code;
  
   switch(teclaPressionada){
    case '.' : adicionarDecimal(teclaPressionada)
      break;
    case '=' : 
    case'Enter': calcular();
      break;
    case 'c' :
    case 'C' : limpar();
      break;
    case '+':
    case '-':
    case '*':
    case '/':
      adicionarOperador(teclaPressionada)
      break;
    default : adicionarNumero(teclaPressionada);
   } 
  });
 