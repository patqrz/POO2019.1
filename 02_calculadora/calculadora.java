import java.util.Scanner;

class Calculadora {
	int bateria;
	int bateriaMax;
	
	public Calculadora(int bateria, int bateriaMax) {
		this.bateria = bateria;
		this.bateriaMax = bateriaMax;
	}
	
	public void soma(double a, double b) {
		if(this.bateria > 0) {
			this.bateria = this.bateria - 1;
			System.out.println(a + b);
		}else {
			System.out.println("fail: bateria insuficiente");
		}
	}
	
	public void divi(double a, double b) {
		if(this.bateria > 0) {
			this.bateria = this.bateria - 1;
			if(b == 0)
                System.out.println("fail: divisao por 0");
			System.out.println(a / b);
		}else {
			System.out.println("fail: bateria insuficiente");
		}
	}
	
	public void recarga(int m) {
		this.bateria += m;
		if(this.bateria > this.bateriaMax)
			this.bateria = bateriaMax;
	}
	
	public String toString() {
		return "bateria: " + this.bateria + "/" + this.bateriaMax;
	}
}

public class Controller{
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Calculadora calculadora = new Calculadora(0, 0);
		
		while (true) {
			String line = scanner.nextLine();
			String[] ui = line.split(" ");
			
			if(ui[0].equals("end")){
				break;
			}else if(ui[0].equals("init")) {
				calculadora = new Calculadora(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
			}else if(ui[0].equals("show")) {
				System.out.println(calculadora);
			}else if(ui[0].equals("charge")) {
				calculadora.recarga(Integer.parseInt(ui[1]));
			}else if(ui[0].equals("sum")) {
				calculadora.soma(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
			}else if(ui[0].equals("div")) {
				calculadora.divi(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
			}else {
				System.out.println("fail: comando invalido");
			}
		}
	}
}