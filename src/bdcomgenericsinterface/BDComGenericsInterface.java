/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcomgenericsinterface;

import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author jxavi
 */
public class BDComGenericsInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProdutoDAO pdao = new ProdutoDAO();
        ArrayList<Produto> lista = pdao.buscarTodos();
        String[] colunas = {"ID", "Nome", "Preço", "Quantidade"};
        //System.out.println(pdao.buscarPorId(3));

//        for (Object p : lista) {
//            System.out.println(p);
//        }
        // Imprimir o cabeçalho da tabela
        String formatoCabecalho = "%-5s | %-20s | %-15s | %-10s|\n";
        System.out.format(formatoCabecalho, "ID", "Nome", "Preço", "Qtd.(U)");
        System.out.println("------------------------------------------------------------");

        // Definir o formato das linhas
        String formatoLinha = "%-5s | %-20s | R$ %-12s | %-10s|\n";

        // Para cada linha de dados, imprimir formatado
        for (Produto p : lista) {
            System.out.format(formatoLinha, p.getId(), p.getNome(), p.getPreco(), p.getQuantidade());
        }
    }

}
