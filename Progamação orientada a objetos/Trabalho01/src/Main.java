import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws ExcessaoIdade{
		System.out.println("Bem vindo ao SuperMax, para iniciar o cadastro insira o tipo do cadastro que deseja fazer: ");
		
		int tipoCadastro = 0;
		Strings s = new Strings();
		
		System.out.println("");
		System.out.println(s.getCadFunc());
		System.out.println(s.getCadCli());
		System.out.println(s.getCadSair());
		
		while (tipoCadastro != 3) {
			
			Scanner scanner = new Scanner(System.in);
			tipoCadastro = scanner.nextInt();
			
			if (tipoCadastro == 1) {
				
				Funcionario f = new Funcionario();
				System.out.println("Informe o nome do funcionario");
				f.setNome(scanner.next());
				
				System.out.println("Informe a idade do funcionario: ");
				f.setIdade(scanner.nextInt()); 
				
				String retorno=f.calcularIdade(f.getIdade());	
				System.out.println(retorno);
								
				System.out.println("");
				System.out.println(s.getCadFunc());
				System.out.println(s.getCadCli());
				System.out.println(s.getCadSair());
				
			} else if (tipoCadastro == 2) {
				
				Cliente c = new Cliente();
				
				System.out.println("Informe o nome do cliente: ");
				c.setNome(scanner.next());
				
				System.out.println("Informe a idade do cliente: ");
				c.setIdade(scanner.nextInt());
				
				String retorno=c.calcularIdade(c.getIdade());	
				System.out.println(retorno);
				
				System.out.println("");
				System.out.println(s.getCadFunc());
				System.out.println(s.getCadCli());
				System.out.println(s.getCadSair());
				
			} else {
				
				scanner.close();
				
				System.out.println("\n------------------");
				System.out.println("Sistema finalizado");	
			}
		}
	}
}