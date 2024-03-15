import 'package:t1/cliente.dart';
import 'package:t1/produto.dart';
import 'package:t1/movimentacao.dart';
import 'package:t1/venda.dart';
import 'package:t1/relatorio.dart';

void main() {
  var cadastroCliente = CadastroClientes();
  var cadastroProduto = CadastroProdutos();
  var movimentacaoEstoque = Estoque(cadastroProduto);
  var movimentacaoVenda = RealizaVenda(cadastroProduto);
  var relatorio = Relatorio();
  

  cadastroCliente.inserir(Cliente(1, 'João', 'joao@gmail.com'));
  cadastroCliente.inserir(Cliente(2, 'Maria', 'maria@gmail.com'));
  cadastroCliente.inserir(Cliente(3, 'Carlos', 'carlos@gmail.com'));
  print('------------------------------------------------------');
  print('-----------------Cadastro de Clientes-----------------');
  print('------------------------------------------------------');
  cadastroCliente.imprimirClientes();

  var cliente = cadastroCliente.buscar('João');
  if (cliente != null) {
    print('Cliente encontrado: $cliente');
  } else {
    print('Cliente não encontrado');
  }

  cadastroCliente.deletar(2);

  print('Clientes após deletar:');
  cadastroCliente.imprimirClientes();

  print('------------------------------------------------------');
  print('-----------------Cadastro de Produtos-----------------');
  print('------------------------------------------------------');

  cadastroProduto.inserir(Produto(1, 'Pomada', 10, 5.0));
  cadastroProduto.inserir(Produto(2, 'Shampoo', 5, 7.0));
  cadastroProduto.inserir(Produto(3, 'Gel Fixador', 7, 4.0));

  print('Produtos após inserção:');
  cadastroProduto.imprimir();

  var produto = cadastroProduto.buscar('Pomada');
  if (produto != null) {
    print('Produto encontrado: $produto');
  } else {
    print('Produto não encontrado');
  }
  cadastroProduto.deletar(1);
  print("Produtos após deletar:");
  cadastroProduto.imprimir();

  print('------------------------------------------------------');
  print('----------------Movimentação de Estoque---------------');
  print('------------------------------------------------------');
  movimentacaoEstoque.alteraEstoque('Pomada', 15);
  movimentacaoEstoque.alteraEstoque('Shampoo', 10);
  movimentacaoEstoque.alteraPreco('Gel Fixador', 5.4);
  print('------------------------------------------------------');
  print('Produtos após movimentação:');
  cadastroProduto.imprimir();
   print('Movimentação do Estoque:');
  movimentacaoEstoque.imprimirMovimentacaoEstoque();

  print('------------------------------------------------------');
  print('------------------------Vendas------------------------');
  print('------------------------------------------------------');
  movimentacaoVenda.realizaVenda();
  print('Produtos após Venda');
  movimentacaoVenda.imprimir();

  print('------------------------------------------------------');
  relatorio.relatorioCliente(cadastroCliente);

  print(' ');
  relatorio.relatorioVenda(movimentacaoVenda);
}