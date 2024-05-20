package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaYhora;

    private Integer duracionPartida;

    @ManyToOne(fetch = FetchType.LAZY)                  /* Muchas partidas se pueden tener para un juego */
    @JoinColumn (name = "juego_id")                          /* El nombre de la columna en la tabla de la base de datos */
    private Juego juego;

    @ManyToOne(fetch = FetchType.LAZY)                  /* Muchas partidas se pueden tener para un ganador */
    @JoinColumn(name = "ganador_id")                    /* El nombre de la columna en la tabla de la base de datos */
    private Jugador ganadorPartida;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jugador_partida",                                  /*Es un table en la base de datos relacionado con la tabla de jugadores y la tabla de partidas */
            joinColumns = @JoinColumn(name = "partida_id", referencedColumnName = "id"),             /*Este id es de Id Partida*/
            inverseJoinColumns = @JoinColumn(name = "jugador_id", referencedColumnName = "id"))      /*Este id es de Id Jugador*/
    private List<Jugador> jugadoresParticipantes;

    public Partida(LocalDateTime fechaYhora, Integer duracionPartida) {     /*En el constructor se crea una partida con la fecha y hora y la duracion de la partida las relacinadas de otros objetos no hacen falta */
        this.fechaYhora = fechaYhora;
        this.duracionPartida = duracionPartida;
    }
}
