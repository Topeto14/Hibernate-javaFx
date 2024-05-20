package org.example.repository;

import org.example.HibernateUtil;
import org.example.entities.Juego;
import org.example.entities.Jugador;
import org.hibernate.Session;

import java.util.List;

public class RepositorioJugador {
    private Session session;

    public RepositorioJugador() {
        this.session = HibernateUtil.getSessionFactory().openSession(); /*Obtiene la sesión de hibernate con la configuración de la base de datos*/
    }
    public void closeSession() { /*Cierra la sesión de hibernate*/
        session.close();
    }
    public void save(Jugador j){ /*Guarda el juego en la base de datos*/
        session.beginTransaction(); /*Inicia una transacción hacia la base de datos*/
        session.persist(j); /*Guarda el juego en la base de datos*/
        session.getTransaction().commit(); /*Finaliza la transacción*/
    }
    public void delete(Jugador j){            /*Elimina el juego de la base de datos*/
        session.beginTransaction();         /*Inicia una transacción hacia la base de datos*/
        session.remove(j);                  /*Elimina el juego de la base de datos*/
        session.getTransaction().commit(); /*Finaliza la transacción*/

    }
    public void update(Jugador j){            /*Actualiza el juego en la base de datos*/
        session.beginTransaction();         /*Inicia una transacción hacia la base de datos*/
        session.merge(j);                   /*Actualiza el juego en la base de datos*/
        session.getTransaction().commit();         /*Finaliza la transacción*/
    }
    public Jugador findById (Long id){             /*Recupera el juego de la base de datos*/
        return session.find(Jugador.class, id);     /*Recupera el juego de la base de datos*/
    }
    public List<Jugador> findAll(){ /*Recupera todos los juegos de la base de datos*/
        return session.createQuery("select j from Jugador j",Jugador.class).list(); /*Recupera todos los juegos de la base de datos metiendose en el listado*/
    }
}
