/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author jxavi
 */
public abstract class ConnectionFactory {

    private ResourceBundle reader = null;
    private Connection conn;

    public Connection getConn() {
        try {
            reader = ResourceBundle.getBundle("resources/dbconfig");
            conn = DriverManager.getConnection(
                    reader.getString("db.url"),
                    reader.getString("db.username"),
                    reader.getString("db.password")
            );
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return conn = null;
        } catch (MissingResourceException e) {
            System.out.println(
                    "Erro: " + e.getMessage()
                    + "\nArquivo de Configuração não encontrado"
            );
        }
        return conn;
    }

    public void fecharConexao() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
