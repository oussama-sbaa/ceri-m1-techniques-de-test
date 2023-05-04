package fr.univavignon.pokedex.api;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static org.assertj.core.api.Assertions.*;
public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata bulbizarre;
    private PokemonMetadata aquali;


    @Before
    public void setUp(){

        this.metadataProvider = new PokemonMetadataProvider();
        this.bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        this.aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);

    }

    @Test
    @Tag("PokemonMetadataProvider")
    @DisplayName("shouldGetPokemonMetadata")
    public void getPokemonMetadataTest() throws PokedexException {

        int bulbizarreIndex = 0, aqualiIndex = 133, firstInvalidIndex = -4, secondInvalidIndex = 160;

        assertThat(this.bulbizarre.getIndex())
                .isEqualTo(metadataProvider.getPokemonMetadata(bulbizarreIndex).getIndex());

        assertThat(this.aquali.getDefense())
                .isEqualTo(metadataProvider.getPokemonMetadata(aqualiIndex).getDefense());

        Throwable thrownException = catchThrowable(() -> metadataProvider.getPokemonMetadata(firstInvalidIndex));

        assertThat(thrownException)
                .isInstanceOf(PokedexException.class);

        Throwable thrownException2 = catchThrowable(() -> metadataProvider.getPokemonMetadata(secondInvalidIndex));

        assertThat(thrownException2)
                .isInstanceOf(PokedexException.class);

    }
}