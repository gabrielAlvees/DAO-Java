public class Funcionario {

    private String nome;
    private String cpf;
    private String departamento;
    private double salario;

    public Funcionario(String nome, String cpf, String departamento, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.departamento = departamento;
        this.salario = salario;
    }

    public void mostrar(){
        System.out.printf("Nome: " + nome);
        System.out.printf("CPF: " + cpf);
        System.out.printf("Departamento: " + departamento);
        System.out.printf("Salário " + salario);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

}
