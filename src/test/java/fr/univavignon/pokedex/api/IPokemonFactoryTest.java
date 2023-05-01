package fr.univavignon.pokedex.api;

import org.junit.* ;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp(){
        this.pokemonFactory = Mockito.mock(IPokemonFactory.class);
        this.bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        this.aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    @Tag("PokemonFactory")
    @DisplayName("Creates a pokemon instance computing it IVs")
    public void CreatePokemonTest(){

        int bulbizarreIndex = 0, bulbizarreCp = 613, bulbizarreHp = 64, bulbizarreDust = 4000, bulbizarreCandy = 4;
        int aqualiIndex = 133, aqualiCp = 2729, aqualiHp = 202, aqualiDust = 5000, aqualiCandy= 4;


        Mockito.when(pokemonFactory.createPokemon(bulbizarreIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy)).thenReturn(bulbizarre);
        Mockito.when(pokemonFactory.createPokemon(aqualiIndex, aqualiCp, aqualiHp, aqualiDust, aqualiCandy)).thenReturn(aquali);

        //use of AssertJ in Junit5
        assertThat(pokemonFactory.createPokemon(bulbizarreIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy)).isEqualTo(bulbizarre);
        assertThat(pokemonFactory.createPokemon(aqualiIndex, aqualiCp, aqualiHp, aqualiDust, aqualiCandy)).isEqualTo(aquali);

    }
}