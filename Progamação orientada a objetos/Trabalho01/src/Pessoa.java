public class Pessoa {
	private String Nome;
	private Integer Idade;
	public String getNome() {return Nome;}	
	public void setNome(String Nome) {this.Nome = Nome;}
	public void setIdade(Integer Idade) {this.Idade = Idade;}
	public Integer getIdade() {return Idade;}
	public String calcularIdade (Integer Idade) throws ExcessaoIdade {
		
		if (Idade >= 16 && Idade < 18) {
			return "Maior que 16 e menor que 18";
		} else if (Idade >= 18) {
			return "Maior de idade";
		} else {
			return "Menor de idade";
		}
	}
}