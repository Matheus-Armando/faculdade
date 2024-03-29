import 'package:t1/venda.dart';
import 'cliente.dart';
import 'package:intl/intl.dart';

class Relatorio{
  void relatorioCliente(CadastroClientes cadastroCliente){
    cadastroCliente.clientes.sort((a, b) => a.nome.compareTo(b.nome));
    print('------------------------------------------------------');
    print('----------------Relatório de Clientes-----------------');
    print('------------------------------------------------------');
    print('-------------------Ordem Alfabética-------------------');
    print('------------------------------------------------------');
    for (var cliente in cadastroCliente.clientes) {
      if (cliente.deleted == false){
        print('Código: ${cliente.id} - Nome: ${cliente.nome}');
        print('______________________________________________________');
      }
    }
    print('------------------------------------------------------');
    print('--------------------------------Data atual: ${DateFormat('dd/MM/yyyy').format(DateTime.now())}');
  }

  void relatorioVenda(RealizaVenda realizaVenda){
    print('------------------------------------------------------');
    print('-----------------Relatório de Vendas------------------');
    for (var venda in realizaVenda.vendas) {
      print('------------------------------------------------------');
      print('Código: ${venda.id} - Valor: ${venda.valorTotal} - Desconto: ${venda.desconto}');
      print('Cliente: ${venda.nomeCliente}');
      print('_________________Produtos Vendidos__________________');
      for (var produto in venda.produtosVendidos) {
        print('Produto: ${produto.descricao} - Quantidade: ${produto.qtde}\nPreço: ${produto.preco} - Total: ${produto.qtde * produto.preco}');
        print('______________________________________________________');
      }
    }
    print('------------------------------------------------------');
    print('--------------------------------Data atual: ${DateFormat('dd/MM/yyyy').format(DateTime.now())}');
  }
}