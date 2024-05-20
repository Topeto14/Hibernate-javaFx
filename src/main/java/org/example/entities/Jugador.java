package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String alias;

    private Integer edad;

    @Column(unique = true)
    private String email;

    private String idioma;

    @ManyToOne (fetch = FetchType.LAZY)     /*  La relacion es unidireccional y el fetch es la forma en que se carga la relacion osea que cuando se llame a juegoPreferido se carga solo el juego */
    @JoinColumn (name = "juego_id")         /* El nombre de la columna en la tabla de la base de datos */
    private  Juego juegoPreferido ;

    private String pais;

    public Jugador(String nombre, String alias, Integer edad, String email, String idioma, String pais) {
        this.nombre = nombre;
        this.alias = alias;
        this.edad = edad;
        this.email = email;
        this.idioma = idioma;
        this.pais = pais;
    }

}
