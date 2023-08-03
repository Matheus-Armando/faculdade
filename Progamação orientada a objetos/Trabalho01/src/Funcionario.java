public class Funcionario extends Pessoa {
	public String calcularIdade (Integer Idade) throws ExcessaoIdade {
		if (Idade >= 16 && Idade < 18) {
			return "Colaborador poderá ser vinculado a empresa como Menor Aprendiz";
		} else if (Idade >= 18) {
			return "Colaborador poderá ser vinculado a empresa com contrato efetivo";
		} else {
			throw new ExcessaoIdade("Não poderá ter um vinculo a empresa");
		}
		
	}
}