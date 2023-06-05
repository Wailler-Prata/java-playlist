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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lista {

    private TipoNo primeiro = null, ultimo = null, aux, auxant;
    private TipoNo posAtual = primeiro;
    Scanner entrada;
    String nomeArqui = "Clientes.txt";
    Formatter saida;

    public boolean vazia() {

        if (primeiro == ultimo) {
            return true;
        }
        return false;
    }

    public String primeiro() {
        posAtual = primeiro;
        return primeiro.toString();
    }

    public String ultimo() {
        posAtual = primeiro;
        auxant = null;
        while ((posAtual.proximo != null)) {
            auxant = posAtual;
            posAtual = posAtual.proximo;
        }
        return posAtual.toString();
    }

    public String proximo() {
        if (posAtual.proximo == null) {
            return posAtual.toString();
        }
        posAtual = posAtual.proximo;
        return posAtual.toString();
    }

    public String anterior() {
        if (posAtual == primeiro) {
            return primeiro.toString();
        }
        posAtual = posAtual.anterior;
        return posAtual.toString();
    }

    public void insereNoInicio(int codigo, String nome, String rua, String numero, String bairro, String cidade) {

        TipoNo no = new TipoNo(codigo, nome, rua, numero, bairro, cidade);
        aux = primeiro;
        auxant = null;

        while ((aux != null)) {
            auxant = aux;
            aux = aux.proximo;
        }

        if (auxant == null) {
            primeiro = no;
        } else {
            auxant.proximo = no;
            no.anterior = auxant;
        }
        System.out.println(no);
        System.out.println(no.anterior);
        System.out.println(no.proximo);
    }

    public void excluirCadastro(int codigo) {

        aux = primeiro;
        auxant = null;

        while ((aux != null) && (codigo != aux.novoCli.codigo)) {
            auxant = aux;
            aux = aux.proximo;
        }
        if (aux != null) {
            int autoriza;
            autoriza = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente:\n" + aux);
            if (autoriza == 0) {
                if (auxant == null /*) ||  auxant == primeiro) && auxant.novoCli.codigo == codigo */) {
                    primeiro = primeiro.proximo;
                    // primeiro.anterior = null;
                } else if (aux == ultimo) {
                    ultimo = auxant;
                    auxant.proximo = null;
                } else {
                    auxant.proximo = aux.proximo;
                    aux.proximo = auxant.proximo;
                    aux = auxant;
                }
            } else {
                JOptionPane.showMessageDialog(null, "O cliente não foi excluido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "O cliente não foi encontrado");
        }

    }

    public void localizaCadastro(int codigo) {

        aux = primeiro;
        auxant = null;

        while ((aux != null) && (codigo != aux.novoCli.codigo)) {
            auxant = aux;
            aux = aux.proximo;
        }
        if (aux != null) {
             JOptionPane.showMessageDialog(null, aux);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
    }

    public DefaultTableModel imprime() {

        DefaultTableModel dtm = new DefaultTableModel();
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

        TipoNo aux = primeiro;
        while (aux != null) {
            dtm.addRow(new String[]{
                codigo = Integer.toString(aux.novoCli.codigo),
                nome = aux.novoCli.nome,
                rua = aux.novoCli.rua,
                numero = aux.novoCli.numero,
                bairro = aux.novoCli.bairro,
                cidade = aux.novoCli.cidade
            });
            aux = aux.proximo;
        }
        return dtm;
    }

    public void extrairArquivo() {
        TipoNo aux = primeiro;
        ArquivoInOut arqOut = new ArquivoInOut("Clientes.txt");
        arqOut.abrirArquivo();
        while (aux != null) {
            arqOut.gravarDados(aux.novoCli.getCodigo(), aux.novoCli.getNome(), aux.novoCli.getRua(), aux.novoCli.getNumero(), aux.novoCli.getBairro(), aux.novoCli.getCidade());
            aux = aux.proximo;
        }
        arqOut.fechaArquivo();
        JOptionPane.showMessageDialog(null, "Arquivo exportado com sucesso!");
    }

    public void importaDados() {

        // DefaultTableModel dtm = new DefaultTableModel();
        // ArquivoInOut arqOut = new ArquivoInOut("Clientes.txt");
        abrirArquivoEntrada();
        lerDados();
        fecharArquivoEntrada();

        //return dtm;
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

    public void lerDados() {

        // DefaultTableModel dtm = new DefaultTableModel();
        try {
            /* dtm.addColumn("id");
            dtm.addColumn("Nome");
            dtm.addColumn("Rua ");
            dtm.addColumn("Numero");
            dtm.addColumn("Bairro");
            dtm.addColumn("Cidade");*/
            String codigo;
            String nome;
            String rua;
            String numero;
            String bairro;
            String cidade;

            while (entrada.hasNext()) {

                /*dtm.addRow(new String[]{*/
                codigo = entrada.nextLine();
                nome = entrada.nextLine();
                rua = entrada.nextLine();
                numero = entrada.nextLine();
                bairro = entrada.nextLine();
                cidade = entrada.nextLine();
                //});
                int codigo2 = Integer.parseInt(codigo);
                insereNoInicio(codigo2, nome, rua, numero, bairro, cidade);
                /* TipoNo no = new TipoNo(codigo, nome, rua, numero, bairro, cidade);
                System.out.format("%-10d%-12s%-12s%-12s%-12s%-12s\n", c.getCodigo(), c.getNome(), c.getRua(), c.getNumero(), c.getBairro(), c.getCidade());
                 */
            }
        } catch (Exception exception) {
            System.out.println("Erro ao ler o arquivo");
        }
        /*l.imprime();
        return dtm;*/
    }

}
