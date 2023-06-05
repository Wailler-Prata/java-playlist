/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalalgoritimos;

/*
 *
 * @author Wailler Prata - 318131397
 *         Matheus Leandro - 318135312
 */
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class ArquivoInOut {

    String nomeArqui;
    Formatter saida;
    Scanner entrada;
    Lista l = new Lista();

    public ArquivoInOut(String nome) {

        nomeArqui = nome;
    }

    public void abrirArquivo() {

        try {
            saida = new Formatter(nomeArqui);
        } catch (Exception exeption) {
            System.out.println("Erro ao tentar abrir o arquivo");
            System.exit(1);
        }
    }

    public void abrirArquivoEntrada() {
        try {
            entrada = new Scanner(new File(nomeArqui));
        } // fim do try
        catch (Exception minhaExcecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }
    }

    public void fecharArquivoEntrada() {
        entrada.close();
    }

    public void fechaArquivo() {

        saida.close();
    }

    public void gravarDados(int codigo, String nome, String rua, String numero, String bairro, String cidade) {

        Cliente c = new Cliente(codigo, nome, rua, numero, bairro, cidade);
        saida.format("%d\n%s\n%s\n%s\n%s\n%s\n", c.getCodigo(), c.getNome(), c.getRua(), c.getNumero(), c.getBairro(), c.getCidade());

    }

    public DefaultTableModel lerDados() {

        DefaultTableModel dtm = new DefaultTableModel();

        try {
            dtm.addColumn("id");
            dtm.addColumn("Nome");
            dtm.addColumn("Rua ");
            dtm.addColumn("Numero");
            dtm.addColumn("Bairro");
            dtm.addColumn("Cidade");
            String codigo;
            String nome;
            String rua;
            String numero;
            String bairro;
            String cidade;

            while (entrada.hasNext()) {

                dtm.addRow(new String[]{
                    codigo = entrada.next(),
                    nome = entrada.next(),
                    rua = entrada.next(),
                    numero = entrada.next(),
                    bairro = entrada.next(),
                    cidade = entrada.next()
                });
                int codigoconvertido = Integer.parseInt(codigo);
                Cliente c = new Cliente(codigoconvertido, nome, rua, numero, bairro, cidade);
                l.insereNoInicio(c.getCodigo(), c.getNome(), c.getRua(), c.getNumero(), c.getBairro(), c.getCidade());
                System.out.format("%-10d%-12s%-12s%-12s%-12s%-12s\n", c.getCodigo(), c.getNome(), c.getRua(), c.getNumero(), c.getBairro(), c.getCidade());
            }
        } catch (Exception exception) {
            System.out.println("Erro ao ler o arquivo");
        }
        l.imprime();
        return dtm;
    }

}
