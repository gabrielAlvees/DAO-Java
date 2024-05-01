import java.util.List;

public interface FuncionarioDAO {

    void inserirFuncionario(Funcionario funcionario);
    List<Funcionario> listarFuncionarios();
    void atualizarFuncionario(Funcionario funcionario);
    void excluirFuncionario(String cpf);

}
