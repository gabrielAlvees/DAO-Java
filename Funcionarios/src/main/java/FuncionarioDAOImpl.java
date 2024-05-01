import java.util.List;

class FuncionarioDAOImpl implements FuncionarioDAO {
    private final DBConnection dbConnection = new DBConnection();

    @Override
    public void inserirFuncionario(Funcionario funcionario) {
        dbConnection.inserirFuncionario(funcionario.getNome(), funcionario.getCpf(),
                funcionario.getDepartamento(), funcionario.getSalario());
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return dbConnection.listarFuncionario();
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        dbConnection.atualizarFuncionario(funcionario.getNome(), funcionario.getCpf(),
                funcionario.getDepartamento(), funcionario.getSalario());
    }

    @Override
    public void excluirFuncionario(String cpf) {
        dbConnection.excluirFuncionario(cpf);
    }
}