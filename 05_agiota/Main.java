package agiota;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Transacao{
	int id;
	float valor;
	String clienteId;
	
	public Transacao(int id, float valor, String clienteId) {
		this.id = id;
		this.valor = valor;
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "" + this.id + ":" + this.valor + ":" + this.clienteId;
	}
}

class Cliente {
	float saldo;
	String id;
	String fullname;
	
	public Cliente(String id, String fullname) {
		this.saldo = 0;
		this.id = id;
		this.fullname = fullname;
	}
	
	//rastreia se os pontos do código de uma classe sobrescrita foi alterada ou removida
	@Override
	public String toString() {
		return this.id + ":" + this.fullname + ":" + this.saldo;
	}
}

class Sistema {
	float saldo;
	//criando uma lista de clientes
	ArrayList<Cliente> clientes;
	//criando uma lista de tranaçoes
	ArrayList<Transacao> transacoes;
    int nextId;
	
	public Sistema(float saldo) {
		this.saldo = saldo;
		this.clientes = new ArrayList<Cliente>();
		this.transacoes = new ArrayList<Transacao>();
		this.nextId = 0;
	}
	
	void cadastrar(Cliente cliente) {
//		//find encontra um elemento na lista
//		//null se usa quando quer dizer que o argumento é nulo/cancelado
//		if(this.findCliente(cliente.id) != null) {
//			System.out.println("fail: id ja existe");
//		return;
//		}
//		clientes.add(cliente);
		try {
			this.findCliente(cliente.id);
			throw new RuntimeException("cliente ja existe");
		}catch(RuntimeException re) {
			clientes.add(cliente);
		}
	}
	
	Cliente findCliente(String id){
        //":" percorre todos os elementos da lista
		for(Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
		
        //return null;
		throw new RuntimeException("fail: cliente nao existe");
	}
	
	void addTransacao(float valor, String clienteId) {
		this.transacoes.add(new Transacao(nextId, valor, clienteId));
		nextId = nextId + 1;
	}
	
	void emprestar(String id, float saldo){
		//encontrar cliente
        Cliente cli = findCliente(id);
        if(cli == null){
            System.out.println("fail: cliente nao existe");
            return;
        }
        this.saldo = this.saldo - saldo;
        cli.saldo += saldo;
        addTransacao(-saldo, id);
    }
	
	void receber(String id, float saldo) {
		//encontrar cliente
        Cliente cli = findCliente(id);
//        if(cli == null) {
//        	System.out.println("fail: cliente nao existe");
//        	return;
//        }
        if(cli.saldo < saldo){
            System.out.println("fail: pagamento maior que divida");
            return;
        }
//        this.transacoes.add(new Transacao(nextId, saldo, id));
//        nextId += 1;
        addTransacao(saldo, id);
        cli.saldo -= saldo;
        this.saldo += saldo;
    }
        
	ArrayList<Transacao> getExtrato() {
		return transacoes;
	}
	
	@Override
    public String toString() {
        String saida = "";
        for(Cliente cliente : clientes)
            saida += cliente + "\n";
        saida += "saldo:" + this.saldo;
        return saida;
    }
}

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try {
	            if(ui[0].equals("end")){
	                break;
	            }else if(ui[0].equals("init")){
	                sistema = new Sistema(Float.parseFloat(ui[1]));
	            }else if(ui[0].equals("show")){
	                System.out.println(sistema);
	            }else if(ui[0].equals("emprestar")){
	                sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
	            }else if(ui[0].equals("extrato")){
	                ArrayList<Transacao> extrato = sistema.getExtrato();
	                for(Transacao transacao : sistema.getExtrato()) {
	                	System.out.println(transacao);
	                }
	            }else if(ui[0].equals("cadastrar")){
	                String id = ui[1];
	                
	                String[] subarray = Arrays.copyOfRange(ui, 2, ui.length);
	                String fullname = String.join(" ", subarray);
	                sistema.cadastrar(new Cliente(id, fullname));
	            }else {
	            	System.out.println("comando invalido");
	            }
            }catch(RuntimeException re){
            	System.out.println(re.getMessage());
            }
        }
    }
}