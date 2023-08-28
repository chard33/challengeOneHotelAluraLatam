package modelos;

import java.math.BigDecimal;
import java.util.Date;

public class registroH{

   private Long id;
   private Date fechaentrada;
   private Date fechasalida;
   private BigDecimal total;
   private String formapago;
   
   public registroH(){
   }
   
   public registroH(Long id,
                    Date fechaentrada,
                    Date fechasalida,
                    BigDecimal total,
                    String formapago){
      this.id = id;
      this.fechaentrada = fechaentrada;
      this.fechasalida = fechasalida;
      this.total = total;
      this.formapago = formapago;
   }
   
   public registroH(Date fechaentrada,
                    Date fechasalida,
                    BigDecimal total,
                    String formapago){
      this.fechaentrada = fechaentrada;
      this.fechasalida = fechasalida;
      this.total = total;
      this.formapago = formapago;
   }
   
   public Long getId(){
      return id;
   }
   
   public void setId(Long id){
      this.id = id;
   }
   
   public Date getFechaentrada(){
      return fechaentrada;
   }
   
   public void setFechaentrada(Date fechaentrada){
      this.fechaentrada = fechaentrada;
   }
   
   public Date getFechasalida(){
      return fechasalida;
   }
   
   public void setFechasalida(Date fechasalida){
      this.fechasalida = fechasalida;
   }
   
   public BigDecimal getTotal(){
      return total;
   }
   
   public void setTotal(BigDecimal total){
      this.total = total;
   }
   
   public String getFormapago(){
      return formapago;
   }
   
   public void setFormapago(String formapago){
      this.formapago = formapago;
   }
   
   @Override
   public String toString(){
      return "registroH{" +
              "id=" + id +
              ", fechaentrada=" + fechaentrada +
              ", fechasalida=" + fechasalida +
              ", total=" + total +
              ", formapago='" + formapago + '\'' +
              '}';
   }
}
