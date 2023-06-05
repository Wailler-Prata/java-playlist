
package tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author Wailler Prata Brito
 * (RA) 318131397
 */
public class Pedido {
    
    static BibliotecaExectavel conexao = new BibliotecaExectavel();
    public Scanner lerDados = new Scanner(System.in);
    
           public int codigo;
           public String dataPedido;
           public int listaLivro;
           public int quantidade;
           public double valor;
           
            public void setCodPedido(int codigo){
               this.codigo = codigo;
            }
            public int getCodPedido(){
               return this.codigo;
            }
            public void setDataPedido( String dataPedido){
               this.dataPedido = dataPedido;
            }
            public String getDataPedido(){
               return this.dataPedido;
            }
            public void setListalivroPedido(int listaLivro){
               this.listaLivro = listaLivro;
            }
            public int getListalivroPedido(){
               return this.listaLivro;
            }
            public void setQuantidadePedido(int quantidade){
               this.quantidade = quantidade;
            }
            public int getQuantidadePedido(){
               return this.quantidade;
            }
            public void setValorPedido(double valor){
               this.valor = listaLivro;
            }
            public double getValorPedido(){
               return this.valor;
            }
            
            public void calculaValor(){
                
                PedidoCliente pedidoCliente = new PedidoCliente();              
                PedidoCliente pecl = new PedidoCliente();
                          try{
                System.out.println(" # Consulta do pedido para calclo do valor ");
            
                System.out.println(" - Digite o Codigo do pedido");
        int codClientPe = Integer.parseInt(lerDados.nextLine());
        pecl.setCodPedidoCliente(codClientPe);
 
        String exectaConsltaClient = "SELECT * FROM Pedido WHERE codPedido =" + "'" + pecl.getCodPedidoCliente() + "'"  + ";";
       
        ResultSet result = conexao.ExecultarConsultaSQL(exectaConsltaClient); 
            int count = 0;
  
              
            while (result.next()){
                String codigoPedido = result.getString(1);
                String dataPedido = result.getString(2);
                String listaLivro = result.getString(3);
                String qantidade = result.getString(4);
                String valor = result.getString(5);

                    double total = Double.parseDouble(valor)* Integer.parseInt(qantidade);
               
                String output = " * O valor total é = R$  %s";
                System.out.println(String.format(output, total));
                count++;
                
                System.out.println("# Formas de pagamento: \n"
                        + "1- para pagar com o cartão"
                         +"2- para pagar no dinheiro");
                
                int formaPagamento = lerDados.nextInt();
                switch(formaPagamento){
                    case 1: pedidoCliente.pagaCartao();break;
                    case 2: pedidoCliente.pagaDinnheiro();
                    
                }
                
            }
            System.out.println("O ´valor foi Imprimido !"); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
            
}

