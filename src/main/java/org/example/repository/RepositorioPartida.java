package org.example.repository;

import org.example.HibernateUtil;
import org.example.entities.Juego;
import org.example.entities.Partida;
import org.hibernate.Session;

import java.util.List;

public class RepositorioPartida {
    private Session session;

    public RepositorioPartida() {
        this.session = HibernateUtil.getSessionFactory().openSession();   /*Obtiene la sesión de hibernate con la configuración de la base de datos*/
    }
    public void closeSession() {   /*Cierra la sesión de hibernate*/
        session.close();
    }
    public void save(Partida p){      /*Guarda el juego en la base de datos*/
        session.beginTransaction();      /*Inicia una transacción hacia la base de datos*/
        session.persist(p);                /*Guarda el juego en la base de datos*/
        session.getTransaction().commit(); /*Finaliza la transacción*/
    }
    public void delete(Partida p){            /*Elimina el juego de la base de datos*/
        session.beginTransaction();           /*Inicia una transacción hacia la base de datos*/
        session.remove(p);                    /*Elimina el juego de la base de datos*/
        session.getTransaction().commit();    /*Finaliza la transacción*/

    }
    public void update(Partida p){                  /*Actualiza el juego en la base de datos*/
        session.beginTransaction();                /*Inicia una transacción hacia la base de datos*/
        session.merge(p);                          /*Actualiza el juego en la base de datos*/
        session.getTransaction().commit();         /*Finaliza la transacción*/
    }
    public Partida findById (Long id){              /*Recupera el juego de la base de datos*/
        return session.find(Partida.class, id);     /*Recupera el juego de la base de datos*/
    }
    public List<Partida> findAll(){                  /*Recupera todos los juegos de la base de datos*/
        return session.createQuery("select p from Partida p",Partida.class).list(); /*Recupera todos los juegos de la base de datos metiendose en el listado*/
    }
}
