package edu.pingpong.quickstart;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EspadaRepository implements PanacheRepository<Espada>{

    @Transactional
    public Espada postEspada(Espada espada){
        persist(espada);
        return espada;
    }

    public Optional<Espada> getEspadaNombre(String nombre){
        return find("nombre",nombre).firstResultOptional();
    }

    public Optional<Espada> getEspadaLongitud(Float longitud){
        return find("longitud", longitud).firstResultOptional();
    }
    @Transactional
    public List<Espada> deleteEspada(String nombre){
        delete(find("nombre", nombre).firstResult());
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
