/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.*;

/**
 *
 * @author alvaro
 */
@Entity
@DiscriminatorValue("DESTRUCTOR") // Valor que se inyectará en la columna discriminadora
public class DestructorEstelar extends Nave {
    
    @Column(name = "capacidad_escudos") 
    private int capacidadEscudos;

    public DestructorEstelar() {
    }

    public DestructorEstelar(int capacidadEscudos, String nombre, String modelo, String estadoSistema, Planeta planetaOrigen) {
        super(nombre, modelo, estadoSistema, planetaOrigen);
        this.capacidadEscudos = capacidadEscudos;
    }

    public int getCapacidadEscudos() {
        return capacidadEscudos;
    }

    public void setCapacidadEscudos(int capacidadEscudos) {
        this.capacidadEscudos = capacidadEscudos;
    }
    
    
}
