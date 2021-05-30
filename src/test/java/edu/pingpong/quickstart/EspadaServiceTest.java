package edu.pingpong.quickstart;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import io.quarkus.test.junit.QuarkusTest;
@QuarkusTest
@Transactional
public class EspadaServiceTest {
    @Inject
    EspadaService service;
    @Inject
    EspadaRepository repo;

    @Test
    public void testLista(){
        Assertions.assertThat(service.getListaEspada()).hasSize(2);
    }
    @Test
    public void containsTest() {
        Assertions.assertThat(service.getListaEspada().stream().anyMatch(f -> f.getNombre().equals("Dragonslayer"))).isTrue();
        Assertions.assertThat(service.getListaEspada().stream().anyMatch(f -> f.getNombre().equals("Frostmourne"))).isTrue();
    }
    @Test
    public void addTest() {
        service.postEspada(new Espada("Excalibur", 150.0F,false));
        Assertions.assertThat(service.getListaEspada()).hasSize(3);
        Assertions.assertThat(service.getListaEspada().stream().anyMatch(f -> f.getNombre().equals("Excalibur"))).isTrue();

        // handmade rollback gracias al antipatron ActiveRecord ;)
        repo.delete(repo.find("nombre","Excalibur").firstResult());
        Assertions.assertThat(repo.count()).isEqualTo(2);
    }
    @Test
    public void removeTest(){
        service.deleteEspada("Dragonslayer");
        Assertions.assertThat(service.getListaEspada()).hasSize(1);
        Assertions.assertThat(service.getListaEspada().stream().anyMatch(f -> f.getNombre().equals("Dragonslayer"))).isFalse();
        repo.persist(new Espada("Dragonslayer", 200.0F, false));
        Assertions.assertThat(repo.count()).isEqualTo(2);
    }

    @Test
    public void getEspadaNombreTest() {
        Assertions.assertThat(repo.getEspadaNombre("Dragonslayer")).get().hasFieldOrPropertyWithValue("nombre", "Dragonslayer").hasFieldOrPropertyWithValue("longitud", 200.0F);
        Assertions.assertThat(service.getEspadaNombre("Excalibur")).isEmpty();
    }
    @Test
    public void getEspadaLongitudTest() {
        Assertions.assertThat(service.getEspadaLongitud(200.0F)).get().hasFieldOrPropertyWithValue("nombre", "Dragonslayer").hasFieldOrPropertyWithValue("longitud", 200.0F);
        Assertions.assertThat(service.getEspadaLongitud(150.0F)).isEmpty();
    }
}
