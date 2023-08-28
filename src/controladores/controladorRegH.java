package controladores;

import conexionBD.conexionFact;
import modelos.registroH;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class controladorRegH{
   
   Connection conn = new conexionFact().obtenerC();
   
   public List<registroH> consultarR(){
      
      try(PreparedStatement pS = conn.prepareStatement("SELECT * FROM reservas")){
         
         ResultSet rS = pS.executeQuery();
         
         List<registroH> rL = new ArrayList<registroH>();
         
         while(rS.next()){
            
            registroH rH = new registroH(
                    rS.getLong(1),
                    rS.getDate(2),
                    rS.getDate(3),
                    rS.getBigDecimal(4),
                    rS.getString(5)
            );
            
            rL.add(rH);
         }
         
         return rL;
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public registroH consultarH(Long id){
      
      try(PreparedStatement pS = conn.prepareStatement("SELECT * FROM reservas WHERE " +
                                                               "id = ?")){
         
         pS.setLong(1, id);
         
         ResultSet rS = pS.executeQuery();
         
         registroH rH = new registroH();
         
         if(rS.next()){
            
            rH.setId(rS.getLong(1));
            rH.setFechaentrada(rS.getDate(2));
            rH.setFechasalida(rS.getDate(3));
            rH.setTotal(rS.getBigDecimal(4));
            rH.setFormapago(rS.getString(5));
            
         }
         
         return rH;
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public Long guardarH(registroH r){
      
      try(PreparedStatement pS = conn.prepareStatement(
              "INSERT INTO reservas " +
                      "(fechaentrada, fechasalida, total, " +
                      "formapago) " +
                      "VALUES (?,?,?,?)",
              Statement.RETURN_GENERATED_KEYS
              )){
         
         pS.setDate(1, new java.sql.Date(r.getFechaentrada().getTime()));
         pS.setDate(2, new java.sql.Date(r.getFechasalida().getTime()));
         pS.setBigDecimal(3, r.getTotal());
         pS.setString(4, r.getFormapago());
         
         pS.executeUpdate();
         
         ResultSet llaves = pS.getGeneratedKeys();
         
         llaves.beforeFirst();
         llaves.next();
         return llaves.getLong(1);
         
      }catch(SQLException e){
         System.out.println(e);
         throw new RuntimeException(e);
      }
   }
   
   public void eliminarH(Long id){
      
      try(PreparedStatement pS = conn.prepareStatement(
              "DELETE FROM reservas WHERE id = ?"
      )){
         
         pS.setLong(1, id);
         
         pS.executeUpdate();
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public void actualizarH(registroH r){
      
      try(PreparedStatement pS = conn.prepareStatement(
              "UPDATE reservas " +
                      "SET " +
                      "fechaentrada = ?, " +
                      "fechasalida = ?, " +
                      "total = ?, " +
                      "formapago = ? " +
                      "WHERE id = ?"
      )){
         
         pS.setDate(1, new java.sql.Date(r.getFechaentrada().getTime()));
         pS.setDate(2, new java.sql.Date(r.getFechasalida().getTime()));
         pS.setBigDecimal(3, r.getTotal());
         pS.setString(4, r.getFormapago());
         pS.setLong(5, r.getId());
         
         pS.executeUpdate();
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
}
