package fr.univavignon.pokedex.api;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp(){
        this.pokedexFactory = new PokedexFactory();

    }

    @Test
    @Tag("PokedexFactory")
    @DisplayName("canCreatePokedex")
    public void CreatePokedexTest(){

        IPokemonMetadataProvider pokemonMetadataProvider= Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        assertThat(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).getClass())
                .isEqualTo(Pokedex.class);

    }
}