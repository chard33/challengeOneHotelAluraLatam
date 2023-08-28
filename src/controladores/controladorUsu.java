package controladores;

import conexionBD.conexionFact;
import modelos.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class controladorUsu{
   
   Connection conn = new conexionFact().obtenerC();
   
   public boolean obtenerU(String usuario, char[] contrasenha){
      
      try(PreparedStatement pS = conn.prepareStatement(
              "SELECT * FROM usuario WHERE usuario = ? AND contrasenha = ?"
      )){
         
         pS.setString(1, usuario);
         pS.setString(2, new String(contrasenha));
         
         ResultSet rS = pS.executeQuery();
         
         return rS.next();
      
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
}
