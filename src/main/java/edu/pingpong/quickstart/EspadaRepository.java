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

    @Transactional
    public Espada afilarEspadaNombre(String nombre){
        Espada espada = find("nombre",nombre).firstResult();
        espada.afilar();
        persist(espada);
        return espada;
    };
    @Transactional
    public Espada atacarEspadaNombre(String nombre){
        Espada espada = find("nombre",nombre).firstResult();
        espada.atacar();
        persist(espada);
        return espada;
    };

    public List<Espada> getListaEspada(){
        return listAll();
    }
}
