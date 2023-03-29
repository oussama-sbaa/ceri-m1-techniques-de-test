package fr.univavignon.pokedex.api;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata bulbizarre;
    private PokemonMetadata aquali;


    @Before
    public void setUp(){

        this.metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        this.bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        this.aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);

    }

    @Test
    @Tag("Pokémons")
    @DisplayName("Retrieves and returns the metadata for the pokemon")
    public void getPokemonMetadata() throws PokedexException {

        int bulbizarreIndex = 0, aqualiIndex = 133, firstInvalidIndex = -4, secondInvalidIndex = 160;

        Mockito.doReturn(this.bulbizarre).when(metadataProvider).getPokemonMetadata(bulbizarreIndex);
        Mockito.doReturn(this.aquali).when(metadataProvider).getPokemonMetadata(aqualiIndex);
        Mockito.doThrow(new PokedexException("invalid given index")).when(metadataProvider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        //use of AssertJ in Junit5
        assertThat(this.bulbizarre).isEqualTo(metadataProvider.getPokemonMetadata(bulbizarreIndex));
        assertThat(this.aquali).isEqualTo(metadataProvider.getPokemonMetadata(aqualiIndex));


        Throwable thrownException = catchThrowable(() -> metadataProvider.getPokemonMetadata(firstInvalidIndex));
        assertThat(thrownException).isInstanceOf(PokedexException.class);

        Throwable thrownException2 = catchThrowable(() -> metadataProvider.getPokemonMetadata(secondInvalidIndex));
        assertThat(thrownException2).isInstanceOf(PokedexException.class);

    }
}
