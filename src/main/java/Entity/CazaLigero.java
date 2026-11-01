/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author alvaro
 */

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CAZA") // Valor que se inyectará en la columna discriminadora
public class CazaLigero extends Nave{
    
    @Column(name = "potencia_fuego") 
    private int potenciaFuego;

    public CazaLigero() {
    }

    public CazaLigero(int potenciaFuego, String nombre, String modelo, String estadoSistema, Planeta planetaOrigen) {
        super(nombre, modelo, estadoSistema, planetaOrigen);
        this.potenciaFuego = potenciaFuego;
    }

    public int getPotenciaFuego() {
        return potenciaFuego;
    }

    public void setPotenciaFuego(int potenciaFuego) {
        this.potenciaFuego = potenciaFuego;
    }
    
    
    
}
