
package tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author Wailler Prata Brito
 * (RA) 318131397
 */
public class Cliente {
    
      static BibliotecaExectavel conexao = new BibliotecaExectavel();
      public Scanner lerDados = new Scanner(System.in);
    
    private int codigo;
    private String nome;
    private String cidade;
    private String estado;
    private String endereco;
    private int cep;
    private int telefone;
    private int pedido;
    
    
            public void setCodigoCliente(int codigo){
               this.codigo = codigo;
            }
            public int getCodigoCliente(){
               return this.codigo;
            }
            public void setNomeCliente( String nome){
               this.nome = nome;
            }
            public String getNomeCliente(){
               return this.nome;
            }
            public void setRuaCliente( String endereco){
               this.endereco = endereco;
            }
            public String getRuaCliente(){
               return this.endereco;
            }
            public void setCidadeCliente( String cidade){
               this.cidade = cidade;
            }
            public String getCidadeCliente(){
               return this.cidade;
            }
            public void setEstadoCliente( String estado){
               this.estado = estado;
            }
            public String getEstadoCliente(){
               return this.estado;
            }
            public void setCEPCliente(int cep){
               this.cep = cep;
            }
            public int getCEPCliente(){
               return this.cep;
            }
            public void setTelefoneCliente(int telefone){
               this.telefone = telefone;
            }
            public int getTelefoneCliente(){
               return this.telefone;
            }
            public void setPedidoCliente(int pedido){
               this.pedido = pedido;
            }
            public int getPedidoCliente(){
               return this.pedido;
            }
          
            public void menuCliente(){
                
                 System.out.println("Digite: \n"
                         + "1- para consultar os dados do cliente \n"
                         + "2- Para alterar os dados do cliente \n"
                         + "3- Para cadastrar um novo cliente \n"
                         + "4- Para excluir dados de um cliente \n"
                         + " * Apos escoler a opção novamente tecle enter para prossegir");
                 
                Cliente cliente = new Cliente();
                int opcaocl = lerDados.nextInt();
                
                switch(opcaocl){
                    case 1: cliente.consultaCliente();break;
                    case 2: cliente.AlteraDadosCliente();break;
                    case 3: cliente.InsereCliente();break;
                    case 4: cliente.excluiCliente();
                }
                
            }
              public void InsereCliente(){
                             
                            Cliente cli = new Cliente();
                  
                  System.out.println("# Cadastro de um novo cliente ");
                  
            System.out.println(" - Informe o codigo do cliente ");
        int codClint = Integer.parseInt(lerDados.nextLine());
        cli.setCodigoCliente(codClint);
        
            System.out.println(" - Informe o nome do cliente ");
        String nomeClient = lerDados.nextLine();
        cli.setNomeCliente(nomeClient);
           
            System.out.println(" - Informe o nome da rua do cliente ");
        String ruaClient = lerDados.nextLine();
        cli.setRuaCliente(ruaClient);
            
            System.out.println(" - Informe a cidade do cliente ");
        String cidadclient = lerDados.nextLine();
        cli.setCidadeCliente(cidadclient);
            
            System.out.println(" - Informe o estado do municipio do cliente ");
        String cidadeClient = lerDados.nextLine();
        cli.setCidadeCliente(cidadeClient);
            
            System.out.println(" - Informe o CEP do cliente ");
        int cepClient = Integer.parseInt(lerDados.nextLine());
        cli.setCEPCliente(cepClient);
                  
            System.out.println(" - Informe o telefone do cliente ");
        int telefoneClient = Integer.parseInt(lerDados.nextLine());
        cli.setTelefoneCliente(telefoneClient);
                  
            System.out.println(" - Informe o pedido do cliente ");
        int pedidoClient = Integer.parseInt(lerDados.nextLine());
        cli.setPedidoCliente(pedidoClient);
        
        String insereCliente = "INSERT INTO Cliente VALUES ('" + cli.getCodigoCliente() + "','" + cli.getNomeCliente() + "','"
                + cli.getCidadeCliente() + "','" + cli.getEstadoCliente()+ "','" + cli.getRuaCliente()+ "','" + cli.getCEPCliente()+ 
                 cli.getTelefoneCliente() + "','" + cli.getPedidoCliente() + "');";
        
        conexao.ExecutarComandoSQL(insereCliente);
   }
              
              public void consultaCliente(){
                  
                  Cliente cli2 = new Cliente();
                          try{
                System.out.println(" # Dados do Cliente "); 
            
                System.out.println(" - Digite o Codigo do Cliente");   
        int codClientConslt = Integer.parseInt(lerDados.nextLine());
        cli2.setCodigoCliente(codClientConslt);
        
        String exectaConsltaClient = "SELECT * FROM Cliente WHERE codCliente =" + "'" + cli2.getCodigoCliente() + "'"  + ";";
       
        ResultSet result = conexao.ExecultarConsultaSQL(exectaConsltaClient);
            int count = 0;
  
            while (result.next()){
                String codigo = result.getString(1);
                String nome = result.getString(2);
                String cidade = result.getString(3);
                String estado = result.getString(4);
                String rua = result.getString(5);
                String cep = result.getString(6);
                String telefone = result.getString(7);
                String pedido = result.getString(8);
                
                   
                String output = " * Cliente Codigo: %s \n- Nome: %s \n- Cidade: %s \n- Estado: %s \n- Rua: %s \n- CEP: %s "
                        + "\n- telefone: %s \n- pedido: %s";
                System.out.println(String.format(output, codigo, nome, cidade,estado,rua, cep, telefone, pedido));
                count++;
            }
            System.out.println("O cliente foi encontrado !"); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
              public void AlteraDadosCliente(){
                  
                  Cliente cli = new Cliente();
                  
                  System.out.println("# Atualização de dados do cliente ");
                  
                  System.out.println(" - Informe o codigo do cliente ");
        int codClint = Integer.parseInt(lerDados.nextLine());
        cli.setCodigoCliente(codClint);
            
            System.out.println(" - Informe o nome do cliente ");
        String nomeClient = lerDados.nextLine();
        cli.setNomeCliente(nomeClient);
           
            System.out.println(" - Informe o nome da rua do cliente ");
        String ruaClient = lerDados.nextLine();
        cli.setRuaCliente(ruaClient);
            
            System.out.println(" - Informe a cidade do cliente ");
        String cidadclient = lerDados.nextLine();
        cli.setCidadeCliente(cidadclient);
            
            System.out.println(" - Informe o estado do municipio do cliente ");
        String cidadeClient = lerDados.nextLine();
        cli.setCidadeCliente(cidadeClient);
            
            System.out.println(" - Informe o CEP do cliente ");
        int cepClient = Integer.parseInt(lerDados.nextLine());
        cli.setCEPCliente(cepClient);
                  
            System.out.println(" - Informe o telefone do cliente ");
        int telefoneClient = Integer.parseInt(lerDados.nextLine());
        cli.setTelefoneCliente(telefoneClient);
                  
            System.out.println(" - Informe o pedido do cliente ");
        int pedidoClient = Integer.parseInt(lerDados.nextLine());
        cli.setPedidoCliente(pedidoClient);
        
        String alteraCliente = "UPDATE Cliente set nomeCliente ='" + cli.getNomeCliente() + "', cidadeCliente ='" + cli.getCidadeCliente() +
                "',estadoCliente ='" + cli.getEstadoCliente()+ "',ruaCliente ='" + cli.getRuaCliente()+ "',cepCliente = '" + cli.getCEPCliente()+ 
                ", telefoneCliente " + cli.getTelefoneCliente() + "', pedidoCliente'" + cli.getPedidoCliente() + "'WHERE codigoCliente ='" + cli.getCodigoCliente() + "',;";
       
         conexao.ExecutarComandoSQL(alteraCliente);
         
    }
             public void excluiCliente(){
                         Cliente cli = new Cliente();
        
       System.out.println(" # Excluir Cliente "); 
        
                System.out.println(" - Informe o codigo do cliente ");
        int codigoClient = Integer.parseInt(lerDados.nextLine());
        cli.setCodigoCliente(codigoClient);
         
        String deleteCliente = "DELETE FROM Cliente where codigoCliente = '" + cli.getCodigoCliente()+ "';"; 
        
          conexao.ExecutarComandoSQL(deleteCliente);
             
    }
}
