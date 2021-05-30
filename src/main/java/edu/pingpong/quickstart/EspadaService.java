package edu.pingpong.quickstart;
import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EspadaService {
    @Inject
    EspadaRepository repository;

    public Espada postEspada(Espada espada){
        repository.postEspada(espada);
        return espada;
    }

    public Espada getEspadaNombre(String nombre){
        return repository.getEspadaNombre(nombre);
    }

    public Espada getEspadaLongitud(Float longitud){
        return repository.getEspadaLongitud(longitud);
    }

    public List<Espada> deleteEspada(Espada espada){
        return repository.deleteEspada(espada);
    }

    public Espada afilarEspadaNombre(String nombre){
        return repository.afilarEspadaNombre(nombre);
    }
    public Espada atacarEsapadaNombre(String nombre){
        return repository.atacarEspadaNombre(nombre);
    }
    public List<Espada> getListaEspada(){
        return repository.getListaEspada();
    }
}
