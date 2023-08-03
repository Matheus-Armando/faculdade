public class Cliente extends Pessoa {
	public String calcularIdade (Integer Idade) throws ExcessaoIdade {
		
		if (Idade >= 16 && Idade < 18) {
			return "Cliente poderá ter um cadastro desde que tenha aprovação de um responsável";
		} else if (Idade >= 18) {
			return "Cliente podera ter um cadastro sujeito a consulta no SPC";
		} else {
			throw new ExcessaoIdade ("Não poderá ter um cadastro devido idade ser menor de 16 anos");
		}
	}
}