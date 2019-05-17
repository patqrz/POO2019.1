import java.util.ArrayList;

class Funcionario {
	protected String nome;
	protected String cpf;
	protected double salario;
	
	public Funcionario(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	public double getBonificacao() {
		return this.salario * 0.10;
	}

	@Override
	public String toString() {
		return "nome: " + this.nome + " | " + "CPF: " + this.cpf + " | " + "salario: " + this.salario;
	}	
}

class Gerente extends Funcionario {
	int senha;
	String nomeFuncionarioGerenciados;
	
	public Gerente(String nome, String cpf, double salario, int senha, String nomeFuncionarioGerenciados) {
		super(nome, cpf, salario);
		this.senha = senha;
		this.nomeFuncionarioGerenciados = nomeFuncionarioGerenciados;
		
	}


	public double getBonificacao() {
		return this.salario * 0.15;
	}
	
	@Override
    public String toString() {
        return super.toString() + " | senha: " + this.senha + " | " + "nomeFuncionarioGerenciado: " + this.nomeFuncionarioGerenciados;
    }
}

class Diretor extends Gerente {
	double salarioExtra;
	
	public Diretor(String nome, String cpf, double salario, int senha, String nomeFuncionarioGerenciados,double salarioExtra) {
		super(nome, cpf, salario, senha, nomeFuncionarioGerenciados);
		this.salarioExtra = salarioExtra;
	}
	
	public double getBonificacao() {
		return this.salario + this.salarioExtra * 0.20;
	}

	@Override
    public String toString() {
        return super.toString() + " | salarioExtra: " + this.salarioExtra;
    }
}

public class Controller {

	public static void main(String[] args) {

		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("nat", "123", 1500));
		funcionarios.add(new Gerente("kess", "123", 2500, 321, "kessia"));
		funcionarios.add(new Diretor("kassi", "456", 3500, 123, "kassiane", 500));
		
		for(Funcionario i : funcionarios) {
			System.out.println(i);
		}
	}
}