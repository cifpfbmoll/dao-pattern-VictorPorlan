package edu.pingpong.quickstart;
import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EspadaService {
    @Inject
    EspadaRepository repository;

    public Espada postEspada(Espada espada){
        repository.postEspada(espada);
        return espada;
    }

    public Optional<Espada> getEspadaNombre(String nombre){
        return repository.getEspadaNombre(nombre);
    }

    public Optional<Espada> getEspadaLongitud(Float longitud){
        return repository.getEspadaLongitud(longitud);
    }

    public List<Espada> deleteEspada(String nombre){
        return repository.deleteEspada(nombre);
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
