package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity     /*Crea Tabla de la base de dates*/
@Getter
@Setter
@NoArgsConstructor /*constructor Vacio*/
@AllArgsConstructor
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Genera un valor autoincrement*/
    private Long id;

    @Column(unique = true) /*Campo Unico solo va haber un juego con ese nombre*/
    private String nombre;

    private Integer pegi;

    @Enumerated(EnumType.STRING) /*Enumerador de tipo String para la columna categoria asi no te salen numeros de los array */
    @Column(columnDefinition = "VARCHAR(30)")
    private PlataformaJuego plataforma;

    @Enumerated(EnumType.STRING) /*Enumerador de tipo String para la columna categoria asi no te salen numeros de los array */
    @Column(columnDefinition = "VARCHAR(20)")
    private CategoriaJuego categoria;

    public Juego(String nombre, Integer pegi, PlataformaJuego plataforma, CategoriaJuego categoria) {
        this.nombre = nombre;
        this.pegi = pegi;
        this.plataforma = plataforma;
        this.categoria = categoria;
    }

}