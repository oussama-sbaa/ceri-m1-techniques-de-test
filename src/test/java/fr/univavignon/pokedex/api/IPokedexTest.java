package fr.univavignon.pokedex.api;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class IPokedexTest {
    private IPokedex pokedex;
    private List<Pokemon> pokemons;

    @Before
    public void setUp(){

        this.pokedex = Mockito.mock(IPokedex.class);
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56.0));
        pokemons.add(new Pokemon(133,"Aquali",186,186,260,2729,202,5000,4,100.0));

    }

    @Test
    @Tag("Pokedex")
    @DisplayName("Returns the number of pokemon this pokedex contains")
    public void sizeTest(){

        Mockito.doReturn(this.pokemons.size()).when(this.pokedex).size();

        //use of AssertJ in Junit5
        assertThat(this.pokedex.size()).isEqualTo(2);

    }

    @Test
    public void AddPokemonTest() {

        Pokemon newPokemon = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        Mockito.doReturn(newPokemon.getIndex()).when(this.pokedex).addPokemon(newPokemon);

        assertThat(this.pokedex.addPokemon(newPokemon)).isEqualTo(newPokemon.getIndex());

    }
}
