class Conta {
	int conta;
	int saques;
	double saldo;
	int deposito;
	
	public Conta(int conta, int saques, double saldoInicial, int deposito) {
		this.conta = conta;
		this.saques = 0;
		this.saldo = saldoInicial;
		this.deposito = deposito
	}
	
	@Override
	public String toString() {
		return "conta:" + this.conta + "saldo:" + this.saldo;
	}
	
	public void extrato() {
		System.out.println("abertura:" + "0:" + "0" );
		System.out.println("deposito:" + this.deposito);
		System.out.println("saque:" + this.saques);
	}
	
	boolean sacar(double valor) {
		if(this.saldo < valor) {
			return false;
			System.out.println("fail: saldo insuficiente");
		}else {
			this.saldo -= valor
		}
	}
	
	public void depositar(double valor) {
		this.saldo += valor;		
	}
}

public class Controller {
	public static void main(String[] args) {
		Conta conta = new Conta();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String line = scanner.nextLine();
			String[] ui = line.split("");
			
			if ui(ui[0].equals("end")) {
				break;
			}else if(ui[0].equals("show")) {
				System.out.println("conta");
			}else if(ui[0].equals("deposito")) {
				conta.deposito(ui)[1];
			}	
		}
	}
}
