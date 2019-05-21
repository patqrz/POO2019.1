abstract class Conta {
	protected static int numero;
	protected static String nome;
	protected double saldo;
	double deposito;


	
	public Conta(int numero, String nome, double saldo, double deposito) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.deposito = deposito;

	}

    public double getSaldo() {
        return this.saldo;
    }
    
    boolean sacar(double valor) {
		if(this.saldo < valor) {
			return false;
			System.out.println("fail: saldo insuficiente");
		}else {
			this.saldo -= valor;
		}
	}
	
	public void depositar(double valor) {
		this.saldo += valor;		
	}
    	
	@Override
	public String toString() {
		return this.numero + ":" + this.nome + ":" + this.saldo;
	}
}

class ContaCorrente extends Conta {
	   
	   public ContaCorrente (int numeroConta, String titular) {
	      super(numero, nome, saldo);
	   }
	    
	   public void tarifa() {
	     saldo = saldo - 20.0;
	   }
	   
	   @Override
	    public String toString() {
	        return super.toString() + ":" + "CC";
	    }
}

class ContaPoupanca extends Conta {
	   
	   public ContaPoupanca (int numeroConta, String titular) {
	      super(numero, nome, saldo);
	   }
	    
	   public void aumento() {
	     saldo = saldo * 0.01;
	   }
	   
	   @Override
	    public String toString() {
	        return super.toString() + ":" + "CP";
	    }
}

public class Controller {

	public static void main(String[] args) {
		ArrayList<Conta> contas = new ArrayList<Conta>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("addCli")){
                contas.addConta(new Conta(Integer.parseInt(ui[1]), String(ui[2]), Double.parseDouble(ui[3])));
            }else if(ui[0].equals("show")){
                System.out.println(contas);
            }else if(ui[0].equals("deposito")){
				contas.depositar(ui[1]);
			}else if(ui[0].equals("saque")){
				contas.sacar(ui[1]);
			}
        }
	}
}
