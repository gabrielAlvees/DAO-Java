import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroFuncionario cadastro = new CadastroFuncionario();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("Escolha uma opção:");
            System.out.println("1 Cadastrar");
            System.out.println("2 Listar");
            System.out.println("3 Atualizar");
            System.out.println("4 Excluir");
            System.out.println("0 SAIR");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastro.cadastrarFuncionario();
                    break;
                case 2:
                    cadastro.listarFuncionario();
                    break;
                case 3:
                    cadastro.atualizarFuncionario();
                    break;
                case 4:
                    cadastro.deletarFuncionario();
                    break;
                case 0:
                    System.out.println("Encerrando o Sistema....");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }
}