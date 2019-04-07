import java.util.Scanner;

class Carro {
	int pessoasMax;
	int pessoas;
	float km;
	float gas;
	float gasMax;
	
	public Carro(int pessoas, float km, float gas) { //Construtor
		this.pessoas = pessoas;
		this.km = km;
		this.gas = gas;
		this.gasMax = 10;
		this.pessoasMax = 2;
	}
	
	public String toString() { //Método de mostrar o carro
		return "pass: " + (this.pessoas) + "/" + this.pessoasMax + " gas: " + this.gas + 
										   "/" + this.gasMax + " km: " + this.km;
	}

	public void inserir(int pessoas){ //Inserir pessoas //Todo if ou for tem {
		if(this.pessoas < this.pessoasMax) {
			this.pessoas += 1;
		}else {
		System.out.println("fail: limite de pessoas atingidos");
		}
	}	
	
	public void tirar(int pessoas) { //Inserir pessoas //Todo if ou for tem {
		if(this.pessoas > 0) {
			this.pessoas -= 1;
		}else{
			System.out.println("fail: nao ha ninguem no carro");
		}
	}
	
	public void abastecer(float qtd) {
		this.gas += qtd;
		if(this.gas >= this.gasMax) 
			gas = gasMax;
		
	}

	public void andar(float distancia) {
		float disPreciso = distancia/10; 
		if(pessoas <= 0) {
			System.out.println("fail: nao ha ninguem no carro");
			return;
		}else if(this.gas >= disPreciso) {
			this.km += distancia;
			this.gas -= disPreciso;
		}else{
			System.out.println("fail: gasolina insuficiente");
		}
	}
}

public class Main{
	public static void main(String[] args) {
		Carro carro = new Carro(0, 0, 0);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine();
			String[] ui = line.split(" ");
			if(ui[0].equals("end")) {
				break;
			}else if(ui[0].equals("show")) {
				System.out.println(carro);
			}else if(ui[0].equals("in")) {
				carro.inserir(0);
			}else if(ui[0].equals("out")) {
				carro.tirar(1);
			}else if(ui[0].equals("fuel")) {
				carro.abastecer(Float.parseFloat(ui[1]));
			}else if(ui[0].equals("drive")) {
				carro.andar(Float.parseFloat(ui[1]));
			}else {
				System.out.println("comando invalido");
		}
	}
}}
