package modelos;

public class usuario{
   
   private Long id;
   private String nombre;
   private String contrasenha;
   
   public usuario(){
   }
   
   public usuario(String nombre,
                  String contrasenha){
      this.nombre = nombre;
      this.contrasenha = contrasenha;
   }
   
   public String getNombre(){
      return nombre;
   }
   
   public String getContrasenha(){
      return contrasenha;
   }
   
   public void setNombre(String nombre){
      this.nombre = nombre;
   }
   
   public void setContrasenha(String contrasenha){
      this.contrasenha = contrasenha;
   }
}
