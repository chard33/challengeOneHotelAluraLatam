package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionFact{
   
   public Connection obtenerC(){
      
      try{
         return DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/hotelaluradb",
                 "cursoJ",
                 ""
         );
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
}
