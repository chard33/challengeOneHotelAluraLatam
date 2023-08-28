package controladores;

import conexionBD.conexionFact;
import modelos.huesped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class controladorHues{
   
   Connection conn = new conexionFact().obtenerC();
   
   public List<huesped> consultarH(){
      
      try(PreparedStatement pS = conn.prepareStatement("SELECT * FROM huespedes")){
         
         ResultSet rS = pS.executeQuery();
         
         List<huesped> hL = new ArrayList<huesped>();
         
         while(rS.next()){
            
            huesped h = new huesped(
                    rS.getLong(1),
                    rS.getString(2),
                    rS.getString(3),
                    rS.getDate(4),
                    rS.getString(5),
                    rS.getLong(6),
                    rS.getLong(7)
            );
            
            hL.add(h);
         }
         
         return hL;
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public huesped consultarH(Long id){
      
      try(PreparedStatement pS = conn.prepareStatement("SELECT * FROM huespedes WHERE " +
                                                               "id = ?")){
         
         pS.setLong(1, id);
         
         ResultSet rS = pS.executeQuery();
         
         huesped h = new huesped();
         
         if(rS.next()){
            
            h.setId(rS.getLong(1));
            h.setNombre(rS.getString(2));
            h.setApellido(rS.getString(3));
            h.setFechanacimineto(rS.getDate(4));
            h.setNacionalidad(rS.getString(5));
            h.setTelefono(rS.getLong(6));
            h.setIdreserva(rS.getLong(7));
            
         }
         
         return h;
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public void guardarH(huesped h){
      
      try(PreparedStatement pS = conn.prepareStatement(
              "INSERT INTO huespedes " +
                      "(nombre, apellido, fechanacimineto, " +
                      "nacionalidad, telefono, idreserva) " +
                      "VALUES (?,?,?,?,?,?)")){
         
         pS.setString(1, h.getNombre());
         pS.setString(2, h.getApellido());
         pS.setDate(3, new java.sql.Date(h.getFechanacimineto().getTime()));
         pS.setString(4, h.getNacionalidad());
         pS.setLong(5, h.getTelefono());
         pS.setLong(6, h.getIdreserva());
         
         pS.executeUpdate();
         
      }catch(SQLException e){
         System.out.println(e);
         throw new RuntimeException(e);
      }
   }
   
   public void eliminarH(Long id){
   
      try(PreparedStatement pS = conn.prepareStatement(
              "DELETE FROM huespedes WHERE id = ?"
      )){
         
         pS.setLong(1, id);
      
         pS.executeUpdate();
      
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public void actualizarH(huesped h){
      
      try(PreparedStatement pS = conn.prepareStatement(
              "UPDATE huespedes " +
                      "SET " +
                      "nombre = ?, " +
                      "apellido = ?, " +
                      "fechanacimineto = ?, " +
                      "nacionalidad = ?, " +
                      "telefono = ?, " +
                      "idreserva = ? " +
                      "WHERE id = ?"
      )){
         
         pS.setString(1, h.getNombre());
         pS.setString(2, h.getApellido());
         pS.setDate(3, new java.sql.Date(h.getFechanacimineto().getTime()));
         pS.setString(4, h.getNacionalidad());
         pS.setLong(5, h.getTelefono());
         pS.setLong(6, h.getIdreserva());
         pS.setLong(7, h.getId());
         
         pS.executeUpdate();
         
      }catch(SQLException e){
         throw new RuntimeException(e);
      }
   }
   
   public ArrayList<Object> buscarP(String apellido){
      
      ArrayList<Object> arr = new ArrayList<>();
      
      try(PreparedStatement pS = conn.prepareStatement(
              "select * from huespedes h " +
                      "inner join reservas r " +
                      "on h.idreserva = r.id " +
                      "where h.apellido = ?"
      )){
         
         pS.setString(1, apellido);
         
         ResultSet rS = pS.executeQuery();
         
         while(rS.next()){
            
            ArrayList<String> aux = new ArrayList<>();
            
            aux.add(rS.getString(1));
            aux.add(rS.getString(2));
            aux.add(rS.getString(3));
            aux.add(rS.getString(4));
            aux.add(rS.getString(5));
            aux.add(rS.getString(6));
            aux.add(rS.getString(7));
            aux.add(rS.getString(8));
            aux.add(rS.getString(9));
            aux.add(rS.getString(10));
            aux.add(rS.getString(11));
            aux.add(rS.getString(12));
            
            arr.add(aux);
         }
      }catch(SQLException e){
         System.out.println(e);
      }
      
      return arr;
   }
   
   public ArrayList<String> buscarP(Long nReserva){
      
      ArrayList<String> arr = new ArrayList<>();
      
      try(PreparedStatement pS = conn.prepareStatement(
              "select * from huespedes h " +
                      "inner join reservas r " +
                      "on h.idreserva = r.id " +
                      "where r.id = ?"
      )){
         
         pS.setLong(1, nReserva);
         
         ResultSet rS = pS.executeQuery();
         
         while(rS.next()){
            
            arr.add(rS.getString(1));
            arr.add(rS.getString(2));
            arr.add(rS.getString(3));
            arr.add(rS.getString(4));
            arr.add(rS.getString(5));
            arr.add(rS.getString(6));
            arr.add(rS.getString(7));
            arr.add(rS.getString(8));
            arr.add(rS.getString(9));
            arr.add(rS.getString(10));
            arr.add(rS.getString(11));
            arr.add(rS.getString(12));
         }
      
      }catch(SQLException e){
         System.out.println(e);
      }
      
      return arr;
   }
   
   public ArrayList<String[]> obtenerD(){
      
      ArrayList<String[]> arr = new ArrayList<>();
      
      try(PreparedStatement pS = conn.prepareStatement(
              "select * from huespedes h " +
                      "inner join reservas r " +
                      "on h.idreserva = r.id "
      )){
         
         ResultSet rS = pS.executeQuery();
        
         while(rS.next()){
            
            String[] aux = {
                    rS.getString(1),
                    rS.getString(2),
                    rS.getString(3),
                    rS.getString(4),
                    rS.getString(5),
                    rS.getString(6),
                    rS.getString(7),
                    rS.getString(8),
                    rS.getString(9),
                    rS.getString(10),
                    rS.getString(11),
                    rS.getString(12)
            };
            /*arr.add(rS.getString(1));
            arr.add(rS.getString(2));
            arr.add(rS.getString(3));
            arr.add(rS.getString(4));
            arr.add(rS.getString(5));
            arr.add(rS.getString(6));
            arr.add(rS.getString(7));
            arr.add(rS.getString(8));
            arr.add(rS.getString(9));
            arr.add(rS.getString(10));
            arr.add(rS.getString(11));
            arr.add(rS.getString(12));*/
            
            arr.add(aux);
         }
         
      }catch(SQLException e){
         System.out.println(e);
      }
      
      return arr;
   }
}
