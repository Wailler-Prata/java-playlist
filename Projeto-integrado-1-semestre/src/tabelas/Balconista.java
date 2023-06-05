
package tabelas;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author Wailler Prata Brito
 * (RA) 318131397
 */
public class Balconista {
    
        static BibliotecaExectavel conexao = new BibliotecaExectavel();
        public Scanner lerDados = new Scanner(System.in);
    
    public String nomeUsuario;
    public int nivelAcesso;
    public String senha;
    Connection conn2;
           
           public void setNomeusuario( String nomeUsuario){
               this.nomeUsuario = nomeUsuario;
           }
           public String getNomeUsuario(){
               return this.nomeUsuario;
           }
           public void setNivelAcesso(int nivelAcesso){
               this.nivelAcesso = nivelAcesso;
           }
           public int getNivelAcesso(){
               return this.nivelAcesso;
           }
           public void setSenha(String senha){
               this.senha = senha;
           }
           public String getSenha(){
               return this.senha;
           }
           
                       public void menuBalconista(){
                
                 System.out.println("Digite: \n"
                         + "1- para consultar os dados do pedido \n"
                         + "2- Para alterar os dados do pedido \n"
                         + "3- Para cadastrar um novo pedido \n"
                         + "4- Para excluir dados de um pedido \n"
                         + "5- para logar no sistema de fncionario\n"
                         + " * Apos escoler a opção novamente tecle enter para prossegir");
                 
                Balconista balconista = new Balconista();
                int opcaocl = lerDados.nextInt();
                
                switch(opcaocl){
                    case 1: balconista.consultaPedido();break;
                    case 2: balconista.AlteraPedido();break;
                    case 3: balconista.InserePedido();break;
                    case 4: balconista.excluiPedido();break;
                    case 5: balconista.loginBalconista();
                }
            }
           
           public void loginBalconista(){
               
               Balconista ba = new Balconista();
               
               System.out.println(" # Tela de login ");
         
               System.out.println("- Insira o Username ");
         String Username = lerDados.nextLine();
         ba.setNomeusuario(Username);
               
               System.out.println("- insira a senha  para login");
        String password = lerDados.nextLine();
        ba.setSenha(password);
               
               String us = ba.getNomeUsuario();
               String ps = ba.getSenha();
               
    }
           public void InserePedido(){
               
               Pedido pe = new Pedido();
               
               System.out.println("# Insere Dados em um pedido");
                 
                    System.out.println("- Insira o codigo do pedido");
             int codigoPedid = Integer.parseInt(lerDados.nextLine());
             pe.setCodPedido(codigoPedid);
                   
                    System.out.println("- Insira a data do pedido");
             String dataPedid = lerDados.nextLine();
             pe.setDataPedido(dataPedid);
                   
                    System.out.println("- Insira o codigo de lista do livro");
             int listaLivroPedid = Integer.parseInt(lerDados.nextLine());
             pe.setListalivroPedido(listaLivroPedid);
                    
                    System.out.println("- Insira a qantidade do livro");
             int qantidadelivr = Integer.parseInt(lerDados.nextLine());
             pe.setQuantidadePedido(qantidadelivr);
                    
                    System.out.println("- Insira o valor do livro"); 
             double valorpedid = Double.parseDouble(lerDados.nextLine());
             pe.setValorPedido(valorpedid);
                    
                    
        String inserePedido = "INSERT INTO Pedido VALUES ('" + pe.getCodPedido() + "','" + pe.getDataPedido() + "','"
                + pe.getListalivroPedido() + "','" + pe.getQuantidadePedido()+ "','" + pe.getValorPedido()+ "');";
        
        conexao.ExecutarComandoSQL(inserePedido);
                        
                    }
                         public void consultaPedido(){
                  
                  Pedido pe2 = new Pedido();
                          
                  try{
                System.out.println(" # Dados do Pedido "); 
            
                System.out.println(" - Digite o Codigo do Pedido"); 
        int codigoPedid = Integer.parseInt(lerDados.nextLine());
        pe2.setCodPedido(codigoPedid);
        
            
        String exectaConsltaClient = "SELECT * FROM Pedido WHERE codPedido =" + "'" + pe2.getCodPedido() + "'"  + ";";
       
        ResultSet result = conexao.ExecultarConsultaSQL(exectaConsltaClient); 
            int count = 0;
  
              
            while (result.next()){
                String codigo = result.getString(1);
                String dataPedido = result.getString(2);
                String listaPedido = result.getString(3);
                String quantidade = result.getString(4);
                String valor = result.getString(5);

                
                String output = " * Cliente Codigo: %s \n- Data do pedido: %s \n- Lista: %s \n- Quantidade: %s \n- Valor: %s ";
                System.out.println(String.format(output, codigo, dataPedido, listaPedido,quantidade,valor));
                count++;
            }
            System.out.println("O Pedido foi encontrado !"); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
              public void AlteraPedido(){
                  
                  Pedido pe3 = new Pedido();
                  
                  System.out.println("# Atualização de dados do pedido ");
                  
                    System.out.println("- Insira o codigo do pedido");
             int codigoPedid2 = Integer.parseInt(lerDados.nextLine());
             pe3.setCodPedido(codigoPedid2);
                   
             
                    System.out.println("- Insira a data do pedido");
             String dataPedid2 = lerDados.nextLine();
             pe3.setDataPedido(dataPedid2);
                    
                    System.out.println("- Insira o codigo de lista do livro");
             int listaLivroPedid2 = Integer.parseInt(lerDados.nextLine());
             pe3.setListalivroPedido(listaLivroPedid2);
                    
                    System.out.println("- Insira a qantidade do livro");
             int qantidadelivr2 = Integer.parseInt(lerDados.nextLine());
             pe3.setQuantidadePedido(qantidadelivr2);
                    
                    System.out.println("- Insira o valor do livro"); 
             double valorpedid2 = Double.parseDouble(lerDados.nextLine());
             pe3.setValorPedido(valorpedid2);
                    
        
        String alteraPedido = "UPDATE Cliente set dataPedido ='" + pe3.getDataPedido() + "', listaLivro ='" + pe3.getListalivroPedido() +
                "',quantidadeLivro ='" + pe3.getQuantidadePedido()+ "',valorLivro ='" + pe3.getValorPedido() + "'WHERE codigoPedido ='" + pe3.getCodPedido() + "';";
       
         conexao.ExecutarComandoSQL(alteraPedido);
         
    }
             public void excluiPedido(){
                         Pedido pe4 = new Pedido();
        
        
            System.out.println(" # Excluir pedido "); 
        
                System.out.println(" - Informe o codigo do pedido ");
        int codigoPedido = Integer.parseInt(lerDados.nextLine());
        pe4.setCodPedido(codigoPedido);
            
        String deleteCliente = "DELETE FROM Pedido where codigopedido = '" + pe4.getCodPedido()+ "';"; 
        
         conexao.ExecutarComandoSQL(deleteCliente);
            
    }
                    
}
           

