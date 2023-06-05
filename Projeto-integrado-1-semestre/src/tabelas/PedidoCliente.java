
package tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author Wailler Prata Brito
 * (RA) 318131397
 */
public class PedidoCliente {
    
    static BibliotecaExectavel conexao = new BibliotecaExectavel();
    public Scanner lerDados = new Scanner( System.in);
    
           private int codCliente;
           private String dataRemessa;
           
            public void setCodPedidoCliente(int codCliente){
               this.codCliente = codCliente;
            }
            public int getCodPedidoCliente(){
               return this.codCliente;
            }
            public void setDataremessaPedidoCliente( String dataRemessa){
               this.dataRemessa = dataRemessa;
            }
            public String getDataremessaPedidoCliente(){
               return this.dataRemessa;
            }
           
            public void consultaPedidoCliente(){
                  
                  Cliente cli3 = new Cliente();
                try{
                System.out.println(" # Conslda do pedido do Cliente "); 
            
                System.out.println(" - Digite o Codigo do Cliente"); 
        int codClientPedid = Integer.parseInt(lerDados.nextLine());
        cli3.setCodigoCliente(codClientPedid);
        
             
        String exectaConsltaClient = "SELECT * FROM Pedido WHERE codCliente =" + "'" + cli3.getCodigoCliente() + "'"  + ";";
       
        ResultSet result = conexao.ExecultarConsultaSQL(exectaConsltaClient);
            int count = 0;
  
            while (result.next()){
                String codigoPedido = result.getString(1);
                String dataPedido = result.getString(2);
                String listaLivro = result.getString(3);
                String qantidade = result.getString(4);
                String valor = result.getString(5);

                String output = " * Pedido Codigo: %s \n- Data: %s \n- Lista: %s \n- Qantidade: %s \n- Valor R$: %s" ;
                System.out.println(String.format(output, codigoPedido, dataPedido, listaLivro, qantidade, valor));
                count++;
            }
            System.out.println("O Pedido foi encontrado !");
        }    catch (SQLException ex) {
            ex.printStackTrace();
            }  
    }
            
            public void pagaCartao(){
                
                
                        System.out.println(" # Passe o cartao ");
                
            }
            public void pagaDinnheiro(){
                Pedido ped = new Pedido();
                
                System.out.println(" # informe o valor fornecido pelo cliente para calclar o troco");
    }
}
