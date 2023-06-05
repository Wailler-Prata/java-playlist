
package tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author Wailler Prata Brito
 * (RA) 318131397
 */
public class Livro {
        static BibliotecaExectavel conexao = new BibliotecaExectavel();
        public Scanner lerDados = new Scanner(System.in);
    
        private int codigo;
        private String titulo;
        private String autor;
        private int isbn;
        private double preco;
        private int codigoFornecedor;
        

                    
            public void setCodigoLivro(int codigo){
               this.codigo = codigo;
            }
            public int getCodigoLivro(){
               return this.codigo;
            }
            public void setTitulolivro( String titulo){
               this.titulo = titulo;
            }
            public String getTitulolivro(){
               return this.titulo;
            }
            public void setAutorlivro( String autor){
               this.autor = autor;
            }
            public String getAutorlivro(){
               return this.autor;
            }
            public void setIsbnLivro(int isbn){
               this.isbn = isbn;
            }
            public int getIsbnLivro(){
               return this.isbn;
            }
            public void setPrecoLivro(double preco){
               this.preco = preco;
            }
            public double getPrecoLivro(){
               return this.preco;
            }
            public void setCodigoFornecedor(int codigoFornecedor){
               this.codigoFornecedor = codigoFornecedor;
            }
            public int getCodigoFornecedor(){
               return this.codigoFornecedor;
            }
            
            public void menuLivro(){
                
                    System.out.println("Digite: \n"
                         + "1- para consultar os dados do livro \n"
                         + "2- Para alterar os dados do livro \n"
                         + "3- Para cadastrar um novo livro \n"
                         + "4- Para excluir dados de um livro \n"
                         + " * Apos escoler a opção novamente tecle enter para prossegir");
                Livro livro = new Livro();
                int opcaoli = lerDados.nextInt();
                
                switch(opcaoli){
                    case 1: livro.consultaLivro();;break;
                    case 2: livro.AlteraDadosLivro();break;
                    case 3: livro.InsereLivro();break;
                    case 4: livro.excluiLivro();
                    
                }
                
            }
            
            public void InsereLivro(){
                             
                            Livro li = new Livro();
                  
                  System.out.println("# Cadastro de um novo livro ");
                  
                  System.out.println(" - Informe o codigo do livro ");
        int CodigoLivr = Integer.parseInt(lerDados.nextLine());
        li.setCodigoLivro(CodigoLivr);
            
            System.out.println(" - Informe o titlo do livro ");
        String titloLivr = lerDados.nextLine();
        li.setTitulolivro(titloLivr);
            
            System.out.println(" - Informe o nome do ator do livro ");
        String autorLivr = lerDados.nextLine();
        li.setAutorlivro(autorLivr);
            
            System.out.println(" - Informe isbn do livro ");
        int isbnLivr = Integer.parseInt(lerDados.nextLine());
        li.setIsbnLivro(isbnLivr);
            
            System.out.println(" - Informe o preço do livro ");
        double precoLivr = Double.parseDouble(lerDados.nextLine());
        li.setPrecoLivro(precoLivr);
            
            System.out.println(" - Informe o codigo do fornecedor do livro ");
        int codigoFornecedorLivr = Integer.parseInt(lerDados.nextLine());
        li.setCodigoFornecedor(codigoFornecedorLivr);
                  

        String insereLivro = "INSERT INTO Livro VALUES ('" + li.getCodigoLivro() + "','" + li.getTitulolivro() + "','"
                + li.getAutorlivro() + "','" + li.getIsbnLivro() + "','" + li.getPrecoLivro() + "','" + li.getCodigoFornecedor() + "');";
        
        conexao.ExecutarComandoSQL(insereLivro);
   }
              
              public void consultaLivro(){
                  
                   Livro li2 = new Livro();
                          try{
                System.out.println(" # Dados do livro "); 
            
                System.out.println("Digite o Codigo do livro"); 
        int codLivr2 = Integer.parseInt(lerDados.nextLine());
        li2.setCodigoLivro(codLivr2);
        
        String exectaConsltaLivro = "SELECT * FROM Livro WHERE codLivro =" + "'" + li2.getCodigoLivro() + ";";
       
        ResultSet result = conexao.ExecultarConsultaSQL(exectaConsltaLivro); 
            int count = 0;
  
         while (result.next()){
                String codigoli = result.getString(1);
                String tituloli = result.getString(2);
                String autorli = result.getString(3);
                String isbnli = result.getString(4);
                String precoli = result.getString(5);
                String Fornecedor = result.getString(6);

                String output = " * Livro Codigo: %s \n- titulo: %s \n- autor: %s \n- isbn: %s \n- preco: %s \n- Fornecedor: %s ";
                       
                System.out.println(String.format(output, codigoli, tituloli, autorli, isbnli, precoli, Fornecedor));
                count++;
            }
            System.out.println("O livro foi encontrado !"); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
              public void AlteraDadosLivro(){
                  
                  Livro li3 = new Livro();
                  
                  System.out.println("#Atualização de dados do livro ");
                  
                  System.out.println(" - Informe o codigo do livro ");
        int CodigoLivr = Integer.parseInt(lerDados.nextLine());
        li3.setCodigoLivro(CodigoLivr);
            
            System.out.println(" - Informe o titlo do livro ");
        String titloLivr = lerDados.nextLine();
        li3.setTitulolivro(titloLivr);
            
            System.out.println(" - Informe o nome do ator do livro ");
        String autorLivr = lerDados.nextLine();
        li3.setAutorlivro(autorLivr);
            
            System.out.println(" - Informe isbn do livro ");
        int isbnLivr = Integer.parseInt(lerDados.nextLine());
        li3.setIsbnLivro(isbnLivr);
            
            System.out.println(" - Informe o preço do livro ");
        double precoLivr = Double.parseDouble(lerDados.nextLine());
        li3.setPrecoLivro(precoLivr);
            
            System.out.println(" - Informe o codigo do fornecedor do livro ");
        int codigoFornecedorLivr = Integer.parseInt(lerDados.nextLine());
        li3.setCodigoFornecedor(codigoFornecedorLivr);
        
        String alteraLivro = "UPDATE Livro set titloLivro ='" + li3.getTitulolivro() + "', autorlivro ='" + li3.getAutorlivro() +
                "',isbn ='" + li3.getIsbnLivro() + "',preco ='" + li3.getPrecoLivro() + "',codigoFornecedor = '" + li3.getCodigoFornecedor()+ 
                 "'WHERE codigoClienteLivro ='" + li3.getCodigoLivro() + "',;";
       
         conexao.ExecutarComandoSQL(alteraLivro);
         
    }
             public void excluiLivro(){
                         Livro li4 = new Livro();
        
        System.out.println(" # Excluir livro "); 
        
                System.out.println(" - Informe o codigo do livro ");
        int codigoLivro4 = Integer.parseInt(lerDados.nextLine());
        li4.setCodigoLivro(codigoLivro4);
            
        String deleteLivro = "DELETE FROM Livro where codigoLivro = '" + li4.getCodigoLivro()+ "';"; 
        
          conexao.ExecutarComandoSQL(deleteLivro);
             
    }
}
