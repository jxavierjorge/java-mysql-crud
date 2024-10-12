/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jxavi
 */
public abstract class ConnectionFactory {
    
    private Connection conn;
    private final String URL = "jdbc:mysql://localhost:3306/loja";
    private final String PASS = "";
    private final String USER = "root";

    public Connection getConn() {
        try{
            conn = DriverManager.getConnection(URL,USER, PASS);
        }catch(SQLException e){
            System.out.println("Erro: "+e.getMessage());
            return conn=null;
        }
        return conn;
    }
    
    public void fecharConexao() throws SQLException{
        if(conn!=null){
            conn.close();
        }
    }
    
    
}
