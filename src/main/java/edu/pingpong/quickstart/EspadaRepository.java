package edu.pingpong.quickstart;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EspadaRepository implements PanacheRepository<Espada>{

    @Transactional
    public Espada postEspada(Espada espada){
        persist(espada);
        return espada;
    }

    public Espada getEspadaNombre(String nombre){
        return find("nombre",nombre).firstResult();
    }

    public Espada getEspadaLongitud(Float longitud){
        return find("longitud", longitud).firstResult();
    }
    @Transactional
    public List<Espada> deleteEspada(Espada espada){
        delete(espada);
        return listAll();
    }

    public Espada afilarEspadaNombre(String nombre){
        find("nombre",nombre).firstResult().afilar();
        return find("nombre",nombre).firstResult();
    };

    public List<Espada> getListaEspada(){
        return listAll();
    }
}
