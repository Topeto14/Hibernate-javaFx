package org.example.repository;

import org.example.HibernateUtil;
import org.example.entities.Juego;
import org.hibernate.Session;

import java.util.List;

public class RepositorioJuego {
    private Session session;

    public RepositorioJuego() {
        this.session = HibernateUtil.getSessionFactory().openSession(); /*Obtiene la sesión de hibernate con la configuración de la base de datos*/
    }
    public void closeSession() { /*Cierra la sesión de hibernate*/
        session.close();
    }
    public void save(Juego j){ /*Guarda el juego en la base de datos*/
        session.beginTransaction(); /*Inicia una transacción hacia la base de datos*/
        session.persist(j); /*Guarda el juego en la base de datos*/
        session.getTransaction().commit(); /*Finaliza la transacción*/
    }
    public void delete(Juego j){            /*Elimina el juego de la base de datos*/
        session.beginTransaction();         /*Inicia una transacción hacia la base de datos*/
        session.remove(j);                  /*Elimina el juego de la base de datos*/
        session.getTransaction().commit(); /*Finaliza la transacción*/

    }
    public void update(Juego j){            /*Actualiza el juego en la base de datos*/
        session.beginTransaction();         /*Inicia una transacción hacia la base de datos*/
        session.merge(j);                   /*Actualiza el juego en la base de datos*/
        session.getTransaction().commit();         /*Finaliza la transacción*/
    }
    public Juego findById (Long id){             /*Recupera el juego de la base de datos*/
        return session.find(Juego.class, id);     /*Recupera el juego de la base de datos*/
    }
    public List<Juego> findAll(){ /*Recupera todos los juegos de la base de datos*/
        return session.createQuery("select j from Juego j",Juego.class).list(); /*Recupera todos los juegos de la base de datos metiendose en el listado*/
    }
}
