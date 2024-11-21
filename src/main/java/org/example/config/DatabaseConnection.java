package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection conn = null;// variável de classe conexão
    static String server="oracle.fiap.com.br";
    static String port="1521";
    static String sid="ORCL";
    static String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
    static String user="rm555345";
    static String passwd="240304";

    public static Connection criarConexao()  { //método que retorna a conexão
        if (conn==null){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");//verifica driver
                conn= DriverManager.getConnection(url,user,passwd);//cria uma conexão
            }
            catch (ClassNotFoundException e){//erro da linha 17
                System.out.println("Driver não funcionou: " + e);

            }
            catch (java.sql.SQLException e2){
                System.out.println("Conexão não foi efetuada");
            }
        }
        return conn;//retorno da conexão criada.
    }
}


