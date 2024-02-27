/* 
  02 - Impletar um algoritmo em que seja realizada as operações básicas bancárias.
    A - Realizar um saque de um determinado valor;
    B - Realizar um depósito de um determinado valor;
    C - Mostrar o extrato bancário de um determinado cliente.
*/
import 'dart:collection';

class Cliente {
  String nome;
  double saldo;

  Cliente({required this.nome, required this.saldo});
}

class Banco {
  HashMap<String, Cliente> clientes = HashMap<String, Cliente>();

  void adicionarCliente(Cliente variavel) {
    clientes[variavel.nome] = variavel;
  }

  void realizarSaque(String nomeCliente, double valor) {
    if (clientes.containsKey(nomeCliente)) {
      clientes[nomeCliente]!.saldo -= valor;
      print(
          '$nomeCliente realizou o saque com suceso no valor de R\$ ${valor.toStringAsFixed(2)}!');
    } else {
      print('Cliente não encontrado!');
    }
  }

  void realizarDeposito(String nomeCliente, double valor) {
    if (clientes.containsKey(nomeCliente)) {
      clientes[nomeCliente]!.saldo += valor;
      print(
          '$nomeCliente realizou o depósito com suceso no valor de R\$ ${valor.toStringAsFixed(2)}!');
    } else {
      print('Cliente não encontrado!');
    }
  }

  void mostrarSaldo(String nomeCliente) {
    if (clientes.containsKey(nomeCliente)) {
      print(
          'Extrato bancário do cliente $nomeCliente: R\$ ${clientes[nomeCliente]!.saldo.toStringAsFixed(2)}!');
    } else {
      print('Cliente não encontrado!');
    }
  }
}

void main() {
  Banco banco = new Banco();

  Cliente cliente1 = new Cliente(nome: 'João', saldo: 1000);
  Cliente cliente2 = new Cliente(nome: 'Maria', saldo: 500);

  print('------------------------------------------------------');
  banco.adicionarCliente(cliente1);
  banco.adicionarCliente(cliente2);

  print('------------------------------------------------------');
  banco.mostrarSaldo('João');
  banco.realizarSaque('João', 200.00);
  banco.mostrarSaldo('João');

  print('------------------------------------------------------');
  banco.mostrarSaldo('Maria');
  banco.realizarDeposito('Maria', 300.00);
  banco.mostrarSaldo('Maria');
  print('------------------------------------------------------');
}
