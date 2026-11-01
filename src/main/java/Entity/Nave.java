/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Clase Persistente (Entidad) que mapea la tabla 'naves' de PostgreSQL.
 * Sigue la especificación oficial de Jakarta Persistence (JPA).
 */
@Entity 
@Table(name = "naves") // Vincula la clase con la tabla exacta de la BD
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Estrategia base
@DiscriminatorColumn(name = "tipo_nave", discriminatorType = DiscriminatorType.STRING) //Columna discrminatoria para identificar las clases hijas desde java
public abstract class Nave implements Serializable {

    // 1. Clave Primaria Autonumérica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mapea el tipo 'SERIAL' de Postgres
    @Column(name = "nave_id") // Vincula el atributo con el nombre exacto de la columna
    private int id;
    
    // 2. Columnas     
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;

    @Column(name = "modelo", nullable = true, length = 50)
    private String modelo;

    @Column(name = "estado_sistema", nullable = true, length = 20)
    private String estadoSistema;

    // Nota: Dejamos fuera temporalmente 'planeta_origen_id' para explicar 
    // las relaciones @ManyToOne en la siguiente sesión práctica.
    // MAPEO DE LA RELACIÓN MUCHOS A UNO
    @ManyToOne(fetch = FetchType.LAZY) // LAZY evita cargar el planeta de la BD a menos que se invoque explícitamente
    @JoinColumn(name = "planeta_origen_id", foreignKey = @ForeignKey(name = "FK_NAVE_PLANETA"))
    private Planeta planetaOrigen;


    

    // === REQUISITO MANDATORIO JPA: Constructor vacío (por defecto) ===
    public Nave() {
    }

    // Constructor parametrizado para facilitar las inserciones en los laboratorios

    public Nave(String nombre, String modelo, String estadoSistema, Planeta planetaOrigen) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.estadoSistema = estadoSistema;
        this.planetaOrigen = planetaOrigen;
    }

    

    
    
    

    // === Métodos de acceso públicos (Getters y Setters) ===
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }



    

    public String getEstadoSistema() { return estadoSistema; }
    public void setEstadoSistema(String estadoSistema) { this.estadoSistema = estadoSistema; }
    
    public Planeta getPlanetaOrigen() { return planetaOrigen; }
    public void setPlanetaOrigen(Planeta planetaOrigen) { this.planetaOrigen = planetaOrigen; }


    // Sobreescritura útil para las salidas por consola de NetBeans
    @Override
    public String toString() {
        return "🛸 [Nave Persistida] ID: " + id + " | " + nombre + " (" + modelo + ") - Estado: " + estadoSistema;
    }
}
