package salario;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Funcionario {
    String nome;
    double salario;
    int max_diarias;
    int qtd_diarias;
    double bonus;

    public Funcionario(String nome){
        this.nome = nome;
        this.qtd_diarias = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getMax_diarias() {
        return max_diarias;
    }

    public void setMax_diarias(int max_diarias) {
        this.max_diarias = max_diarias;
    }

    public int getQtd_diarias() {
        return qtd_diarias;
    }

    public void setQtd_diarias(int qtd_diarias) {
        this.qtd_diarias = qtd_diarias;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public abstract void add_diaria();
    public abstract void calculoSalario();
}

class Professor extends Funcionario {
    char classe;

    public Professor(String nome, char classe){
        super(nome);
        this.classe = classe;
        setMax_diarias(2);
    }

    @Override
    public void add_diaria(){
        if(getQtd_diarias() < getMax_diarias()){
            setSalario(getSalario() + 100);
            setQtd_diarias(getQtd_diarias() + 1);
        }
        else {
            System.out.println("Máximo de diarias atingidas");
        }
    }

    @Override
    public void calculoSalario(){
        if(this.classe == 'A'){
            setSalario(3000);
        }
        else if(this.classe == 'B'){
            setSalario(5000);
        }
        else if(this.classe == 'C'){
            setSalario(7000);
        }
        else if(this.classe == 'D'){
            setSalario(9000);
        }
        else if(this.classe == 'E'){
            setSalario(11000);
        }
    }

    public String toString(){
        return "Prof " + getNome() + " classe " + this.classe + "\nsalario " + getSalario();
    }
}

class STA extends Funcionario {
    int nivel;

    public STA(String nome, int nivel){
        super(nome);
        this.nivel = nivel;
        setMax_diarias(1);
    }

    @Override
    public void add_diaria(){
        if(getQtd_diarias() < getMax_diarias()){
            setSalario(getSalario() + 100);
            setQtd_diarias(getQtd_diarias() + 1);
        }
        else {
            System.out.println("Limite maximo de diarias atingido");
        }
    }

    @Override
    public void calculoSalario(){
        setSalario(3000 + 300 * this.nivel);
    }

    public String toString(){
        return "Sta " + getNome() + " nivel " + this.nivel + "\nsalario " + getSalario();
    }
}

class Terceirizado extends Funcionario {
    int horas_trabalhadas;
    boolean insalubre;

    public Terceirizado(String nome, int horas, String insalubre){
        super(nome);
        this.horas_trabalhadas = horas;
        
        if(insalubre == "sim"){
            this.insalubre = true;
        }
        else if(insalubre == "nao") {
            this.insalubre = false;
        }
    }

    @Override
    public void add_diaria(){
        System.out.println("Os funcionarios terceirizados nao possuem diaria");
    }

    @Override
    public void calculoSalario(){
        if(this.insalubre == true){
            setSalario((4 * this.horas_trabalhadas) + 500);
        }
        else{
            setSalario(4 * this.horas_trabalhadas);
        }
    }

    public String toString(){
        if(this.insalubre == true){
            return "Ter " + getNome() +  " " + this.horas_trabalhadas + "h" + " iStnsalubre" + "\nsalario " + getSalario();
        }
        else{
            return "Ter " + getNome() +  " " + this.horas_trabalhadas + "h" + "\nsalario " + getSalario();
        }

    }
}

class Sistema {
    ArrayList <Funcionario> funcionarios = new ArrayList<>();

    public void addProfessor(String nome, char classe){
        Professor professor = new Professor(nome, classe);
        professor.calculoSalario();
        funcionarios.add(professor);
    }

    public void addSTA(String nome, int nivel){
        STA sta = new STA(nome, nivel);
        sta.calculoSalario();
        funcionarios.add(sta);
    }

    public void addTerceirizado(String nome, int horas, String insalubre){
        Terceirizado terceirizado = new Terceirizado(nome, horas, insalubre);
        terceirizado.calculoSalario();
        funcionarios.add(terceirizado);
    }

    public void mostrarFuncionario(String nome){
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equals(nome)){
                System.out.println(funcionario);
            }else {
            	System.out.println("Funcionario nao encontrado");
            }
        }
    }

    public void diaria(String nome){
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equals(nome)){
                funcionario.add_diaria();
            }
        }
    }

    public void bonus(double bonus){
        double bonusFunc = bonus / funcionarios.size();
        for(Funcionario funcionamento : funcionarios){
            funcionamento.setSalario(funcionamento.getSalario() + bonusFunc);
            System.out.println("Bonus acrescentado");
        }
    }
    
    public void removerFuncionario(String nome){
        for(Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionario removido");
                break;
            }
        }
    }
}

public class Programa {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("addProf")){
                sistema.addProfessor(ui[1], ui[2].charAt(0));
            }
            else if(ui[0].equals("addSta")){
                sistema.addSTA(ui[1], Integer.parseInt(ui[2]));
            }
            else if(ui[0].equals("addTer")){
                sistema.addTerceirizado(ui[1], Integer.parseInt(ui[2]), ui[3]);
            }
            else if(ui[0].equals("addDiaria")){
                sistema.diaria(ui[1]);
            }
            else if(ui[0].equals("show")){
                sistema.mostrarFuncionario(ui[1]);
            }
            else if(ui[0].equals("setBonus")){
                sistema.bonus(Double.parseDouble(ui[1]));
            }
            else if(ui[0].equals("rm")){
                sistema.removerFuncionario(ui[1]);
            }
            else{
                System.out.println("comando invalido");
            }
        }
    }
}
