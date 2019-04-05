import java.util.ArrayList;

class Cliente {
	float saldo;
	String id;
	String fullname;
	
	public Cliente(float saldo, String id, String fullname) {
		this.saldo = 0;
		this.id = id;
		this.fullname = fullname
	}
	
	//rastreia se os pontos do c�digo de uma classe sobrescrita foi alterada ou removida
	@Override
	public String toString() {
		return this.id + ":" + this.fullname + ":" + this.saldo;
	}
}

class Sistema {
	float saldo;
	//criando uma lista de clientes
	ArrayList<Cliente> clientes;
	
	public Sistema(float saldo) {
		this.saldo = saldo;
		this.clientes = new Arraylist<Cliente()>;
	}
	
	void cadastrar(Cliente clientes) {
		//find encontra um elemento na lista
		//null se usa quando quer dizer que o argumento � nulo/cancelado
		if(this.findCliente(cliente.id) != null) {
			System.out.println("fail: id ja existe");
		return;
		}
		clientes.add(cliente);
	}
	
	Cliente findCliente(String id){
        //":" percorre todos os elementos da lista
		for(Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
        return null;
	}
	
	void emprestar(String id, float saldo){
        Cliente cli = findCliente(id);
        if(cli == null){
            System.out.println("fail: cliente nao existe");
            return;
        }
        this.saldo -= saldo;
        cli.saldo += saldo;
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

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                sistema = new Sistema(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("show")){
                System.out.println(sistema);
            }else if(ui[0].equals("emprestar")){
                sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
            }else if(ui[0].equals("cadastrar")){
                String id = ui[1];
            }
        }
    }
}