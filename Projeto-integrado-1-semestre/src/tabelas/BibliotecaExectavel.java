
package tabelas;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.jdbc.Connection;
/**
 * @author Wailler Prata Brito
 * (RA) 318131397
 */
public class BibliotecaExectavel {
    
    String dbURL = "jdbc:mysql://localhost:3306/biblioteca";
    String username = "root";
    String password = "wailler357212";
    Connection conn;
    
    public BibliotecaExectavel()
    {        
    }
    
    private boolean Conectar()
    {
        try{
            conn = (Connection) DriverManager.getConnection(dbURL, username, password);
             if (conn != null) {
                return  false;
            } 
            return true;        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }    
    }
    
    public int ExecutarComandoSQL(String sql)
    {
        try{
            Conectar();        
            Statement comando = conn.createStatement();
            int linhasAlteradas = comando.executeUpdate(sql);
            conn.close();
            if (linhasAlteradas > 0) {
                System.out.println("Comando Executado com Sucesso");            
            }
            System.out.println(linhasAlteradas + " linhas afetadas");
            return linhasAlteradas;        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }    
    }
    
    public ResultSet ExecultarConsultaSQL(String sql) 
    {
        try{
            Conectar();
            Statement comando = conn.createStatement();    
            ResultSet result = comando.executeQuery(sql);
//            conn.close();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }    
    }
    
    static Scanner lerDados = new Scanner(System.in);
     
    public static void main (String []args){
        System.out.println("Bem Vindo a Biblioteca");
        System.out.println("Digite: \n"
                + "1- Para manipulação do cliente \n"
                + "2- Para manipulação dos dados de livros \n"
                + "3- Para maniplaão de pedidos \n"
                + "4- Para recuperar os pedidos atravez do codigo do cliente \n"
                + "5- Para calclar o valor do pedido e efetar o pagamento \n"
                + " * tecle enter para prossegir");
       
        Cliente cl = new Cliente();
        Livro li = new Livro();
        Balconista ba = new Balconista();
        Pedido pe = new Pedido();
        PedidoCliente pecl =  new PedidoCliente();
        
       int selecionaTabela = lerDados.nextInt();

        
        switch(selecionaTabela){
            case 1:cl.menuCliente();break;
            case 2:li.menuLivro();break;
            case 3:ba.menuBalconista();break;
            case 4:pecl.consultaPedidoCliente();break;
            case 5:pe.calculaValor();
        }
    }
}

