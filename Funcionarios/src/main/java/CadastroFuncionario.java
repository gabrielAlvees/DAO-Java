import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CadastroFuncionario {
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();

    public void cadastrarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();

        System.out.println("Digite o departamento:");
        String departamento = scanner.nextLine();

        System.out.println("Digite o salário do funcionário:");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, cpf, departamento, salario);
        funcionarioDAO.inserirFuncionario(novoFuncionario);
    }

    public void listarFuncionario() {
        List<Funcionario> funcionarioLista = funcionarioDAO.listarFuncionarios();
        for (Funcionario funcionario : funcionarioLista) {
            funcionario.mostrar();
        }
    }

    public void atualizarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do Funcionario:");
        String cpf = scanner.nextLine();

        Funcionario funcionario = funcionarioDAO.listarFuncionarios().stream()
                .filter(f -> f.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);

        if (funcionario != null) {
            System.out.println(funcionario);

            System.out.println("Digite o novo nome do funcionário:");
            String novoNome = scanner.nextLine();

            System.out.println("Digite o novo departamento:");
            String novoDepartamento = scanner.nextLine();

            System.out.println("Digite o novo salário do funcionário:");
            double novoSalario = scanner.nextDouble();
            scanner.nextLine();

            funcionario = new Funcionario(novoNome, cpf, novoDepartamento, novoSalario);
            funcionarioDAO.atualizarFuncionario(funcionario);
        } else {
            System.out.println("Funcionário com CPF " + cpf + " não encontrado");
        }
    }

    public void deletarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do funcionário");
        String cpf = scanner.nextLine();

        funcionarioDAO.excluirFuncionario(cpf);
    }
}
