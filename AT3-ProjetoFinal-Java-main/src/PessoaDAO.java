import java.sql.*;

public class PessoaDAO implements Operacoes {

    public PessoaDAO() {
        // Criar tabela se não existir
        try (Connection conn = Database.conectar()) {
            String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT," +
                    "idade INTEGER," +
                    "tipo TEXT)";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    @Override
    public void cadastrar(Pessoa p) {
        String sql = "INSERT INTO pessoas(nome, idade, tipo) VALUES (?, ?, ?)";

        try (Connection conn = Database.conectar();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, p.getNome());
            pst.setInt(2, p.getIdade());
            pst.setString(3, p.getTipo());
            pst.execute();

            System.out.println("Cadastro realizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    @Override
    public void consultar() {
        String sql = "SELECT * FROM pessoas";

        try (Connection conn = Database.conectar();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("nome") + " - " +
                        rs.getInt("idade") + " anos - " +
                        rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}
