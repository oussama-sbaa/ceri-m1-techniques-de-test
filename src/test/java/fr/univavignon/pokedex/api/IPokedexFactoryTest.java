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
        this.pokedexFactory = Mockito.mock(IPokedexFactory.class);

    }

    @Test
    @Tag("Pokedex")
    @DisplayName("Creates a new pokedex instance using the given")
    public void CreatePokedexTest(){

        IPokemonMetadataProvider pokemonMetadataProvider= Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);


        Mockito.doReturn(Mockito.mock(Pokedex.class)).when(this.pokedexFactory).createPokedex(Mockito.any(pokemonMetadataProvider.getClass()),Mockito.any(pokemonFactory.getClass()));


        Pokedex mockPokedex = Mockito.mock(Pokedex.class);
        IPokedex createdPokedex = pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));

        //use of AssertJ in Junit5
        assertThat(createdPokedex.getClass()).isEqualTo(mockPokedex.getClass());

    }
}
