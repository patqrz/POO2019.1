import java.util.Scanner;

class Carro {
	int pessoasMax;
	int pessoas;
	float km;
	float gas;
	float gasMax;
	
	public Carro (int pessoas, float km, float gas, float qtdGas) { //Construtor
		this.pessoas = pessoas;
		this.km = km;
		this.gas = gas;
		this.gasMax = 10;
		this.pessoasMax = 2;
	}
	
	public String toString() { //Método de mostrar o carro
		return "pass: " + (this.pessoas) + "/" + this.pessoasMax + "gas: " + this.gas + 
										   "/" + this.gasMax + "km: " + this.km;
	}

	public void inserir(int pessoas){ //Inserir pessoas //Todo if ou for tem {
		if(this.pessoas >= this.pessoasMax) {
			System.out.println("fail: limite de pessoas atingidos");
		}
		pessoas += 1;
	}
	
	public void tirar(int pessoas){ //Inserir pessoas //Todo if ou for tem {
		if(this.pessoas <= 0) {
			System.out.println("fail: nao ha ninguem no carro");
		}
		pessoas -= 1;
	}
	
	public void abastecer(float gas) {
		if(this.gas >= this.gasMax) {
			gas = gasMax;
		}
		
		gas += gas;
	}

	public void andar(float distancia) {
		float disPreciso = distancia/10; 
		if(pessoas <= 0) {
			System.out.println("fail: nao ha ninguem no carro");
		}
		if(disPreciso <= gas) {
			System.out.println("fail: gasolina insuficiente");
		}
		gas -= 1;
		km += distancia;
	}
}

public class Controlar {
	public static void main(String[] args) {
		Carro carro = new Carro(0, 0, 0, 0);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine();
			String[] ui = line.split(" ");
			if(ui[0].equals("end")) {
				break;
			}else if(ui[0].equals("init")) {
				carro = new Carro(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));
			}else if(ui[0].equals("show")) {
				System.out.println(carro);
			}else if(ui[0].equals("in")) {
				carro.inserir();
			}else if(ui[0].equals("out")) {
				carro.tirar();
			}else if(ui[0].equals("fuel")) {
				carro.abastecer(Integer.parseInt(ui[1]));
			}else if(ui[0].equals("drive")) {
				carro.andar(Integer.parseInt(ui[1]));
			}else {
				System.out.println("comando invalido");
			
		}
	}
}

	private static float String(String string) {
		return 0;
	}
}
