package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    
    private String db="agenciaor";
    private String url="jdbc:mysql://localhost/" + db;
    private String user="grupo_OR";
    private String pass="1234";
    private Connection con; //Establecer conexion

    
   public Conexion() {
        this.con = null;
    }
    
    public Connection getConectar(){
        try{
            if(con==null){
                con=DriverManager.getConnection(url,user,pass);
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR: " +ex.getMessage());
            
        }
        return con;
    }
    
    //Metodo para desconectar
    public void getDesconectar(){
        try{
           if(con!=null && !con.isClosed()) {
               con.close();
           }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            
        }
    }
}    

