/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import util.ConnectionFactory;

/**
 *
 * @author jxavi
 */
public class ProdutoDAO extends ConnectionFactory implements IDAO {

    @Override
    public void adicionar(Object entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPorId(int id) {
        String consulta = "select * from produto where id=(?)";
        Object produto = null;

        try {
            PreparedStatement pstm = this.getConn().prepareStatement(consulta);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                );

                return produto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        produto = (produto == null) ? "Nenhum registro encontrado com id " + id : produto;
        return produto;

    }

    @Override
    public ArrayList<Produto> buscarTodos() {
        String consulta = "select * from produto";
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        try {
            Statement stm = this.getConn().createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                );
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (produtos.isEmpty() || produtos == null) {
            System.out.println("Nenhum registro encontrado");
        }
        return produtos;
    }

}
