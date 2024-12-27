import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class App {
    static Connection conexao = null;


    static public void criarConexao(){
        //Parâmetros de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "12345678";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        static public void consultar(int id){
            executarConsulta(id);
        }

        static public void consultar(){
            executarConsulta(-1);
        }

        static public void executarConsulta(int id) {
            String sql;

            if (id <= 0) {
                sql = "SELECT * FROM autor ";    
            } else {
                sql = "SELECT * FROM autor WHERE id = ?"; 
            }

            try (PreparedStatement comando = conexao.prepareStatement(sql) ){
                if (id > 0){
                    comando.setInt(1, id);
                }  // Executar a consulta e obter os resultado
            try (ResultSet resultado = comando.executeQuery()){
                // Processar os resultados
                while (resultado.next()) {
                    id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    String nacionalidade = resultado.getString("nacionalidade");     

                    System.out.println("ID: " + id + " Nome: " + nome + ", Nacionalidade: " + nacionalidade );            
                }
            }   

                } catch (SQLException e) {
                     e.printStackTrace();
                
                }                           
        } 
    

    public static void deleter(int id){
        String sql = "DELETE FROM autor WHERE id = ?";

        try(PreparedStatement comando = conexao.prepareStatement(sql)){
            comando.setInt(1, id);
            comando.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }            
    }

    public static void autalizar(int id, String NovoNome, String NovaNacionalidade){
        String sql = "UPDATE autor SET nome = ?, nacionalidade = ? WHERE id = ?";
        
        try (PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
          comando.setString(1, NovoNome);
          comando.setString(2, NovaNacionalidade);
          comando.setInt(3, id);

            comando.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }           
    }

    public static void inserir(String nome, String nacionalidade){
        String sql = "INSERT INTO autor (nome, nacionalidade) values (? , ?)";
        
        try (PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            comando.setString(1, nome);
            comando.setString(2, nacionalidade);

            comando.executeUpdate();

           try (ResultSet resultado = comando.getGeneratedKeys()) {
                if (resultado.next()) {
                    System.out.println("ID do usuário recém inserido: " + resultado.getInt(1));
                }
           }         

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }


    public static void main(String[] args) throws Exception {
       Scanner teclado = new Scanner(System.in);  

       criarConexao();
       consultar(3);
       //deleter(7);
       //inserir("Carla", "Asatica");
       //autalizar(4, "Carla Ribeiro", "China");
       

       if(conexao != null)
            try {
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }       
        
       teclado.close();

    }
}
