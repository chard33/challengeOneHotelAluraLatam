package modelos;

import java.util.Date;

public class huesped{

   private Long id;
   private String nombre;
   private String apellido;
   private Date fechanacimineto;
   private String nacionalidad;
   private Long telefono;
   private Long idreserva;
   
   public huesped(){
   }
   
   public huesped(Long id,
                  String nombre,
                  String apellido,
                  Date fechanacimineto,
                  String nacionalidad,
                  Long telefono,
                  Long idreserva){
      this.id = id;
      this.nombre = nombre;
      this.apellido = apellido;
      this.fechanacimineto = fechanacimineto;
      this.nacionalidad = nacionalidad;
      this.telefono = telefono;
      this.idreserva = idreserva;
   }
   
   public huesped(String nombre,
                  String apellido,
                  Date fechanacimineto,
                  String nacionalidad,
                  Long telefono,
                  Long idreserva){
      this.nombre = nombre;
      this.apellido = apellido;
      this.fechanacimineto = fechanacimineto;
      this.nacionalidad = nacionalidad;
      this.telefono = telefono;
      this.idreserva = idreserva;
   }
   
   public Long getId(){
      return id;
   }
   
   public String getNombre(){
      return nombre;
   }
   
   public String getApellido(){
      return apellido;
   }
   
   public Date getFechanacimineto(){
      return fechanacimineto;
   }
   
   public String getNacionalidad(){
      return nacionalidad;
   }
   
   public Long getTelefono(){
      return telefono;
   }
   
   public Long getIdreserva(){
      return idreserva;
   }
   
   public void setId(Long id){
      this.id = id;
   }
   
   public void setNombre(String nombre){
      this.nombre = nombre;
   }
   
   public void setApellido(String apellido){
      this.apellido = apellido;
   }
   
   public void setFechanacimineto(Date fechanacimineto){
      this.fechanacimineto = fechanacimineto;
   }
   
   public void setNacionalidad(String nacionalidad){
      this.nacionalidad = nacionalidad;
   }
   
   public void setTelefono(Long telefono){
      this.telefono = telefono;
   }
   
   public void setIdreserva(Long idreserva){
      this.idreserva = idreserva;
   }
   
   @Override
   public String toString(){
      return "huesped{" +
              "id=" + id +
              ", nombre='" + nombre + '\'' +
              ", apellido='" + apellido + '\'' +
              ", fechanacimineto=" + fechanacimineto +
              ", nacionalidad='" + nacionalidad + '\'' +
              ", telefono=" + telefono +
              ", idreserva=" + idreserva +
              '}';
   }
}
