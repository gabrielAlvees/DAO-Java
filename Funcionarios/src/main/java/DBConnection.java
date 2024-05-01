import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private String url = "jdbc:postgresql://localhost:5432/Funcionario";
    private String user = "postgres";
    private String password = "123";


    public void inserirFuncionario(String nome, String cpf, String departamento, double salario) {
        String sql = "INSERT INTO funcionarios (nome, cpf, departamento, salario) VALUES (?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setString(2, cpf);
            statement.setString(3, departamento);
            statement.setDouble(4, salario);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> listarFuncionario() {
        List<Funcionario> funcionarioLista = new ArrayList<>();
        String sql = "SELECT nome, cpf, departamento, salario FROM funcionarios";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String departamento = resultSet.getString("departamento");
                double salario = resultSet.getDouble("salario");
                Funcionario funcionario = new Funcionario(nome, cpf, departamento, salario);
                funcionarioLista.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarioLista;
    }

    public void atualizarFuncionario(String nome, String cpf, String departamento, double salario) {
        String sql = "UPDATE funcionarios SET nome = ?, departamento = ?, salario = ? WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setString(2, departamento);
            statement.setDouble(3, salario);
            statement.setString(4, cpf);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirFuncionario(String cpf) {
        String sql = "DELETE FROM funcionarios WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cpf);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
