
package model;


public final class Telefone {
    
    private int ddd;
    private String numero;
    private String tipo;
    private int id_usuario;
    

      
    public Telefone(int ddd, String numero,String tipo, int id_usuario) {
   
        this.setDdd(ddd);
        this.setNumero(numero);
        this.setTipo(tipo);
        this.id_usuario = id_usuario;
    }

 
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
 
    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return ddd + " " + numero  ;
    }
    
    
}
