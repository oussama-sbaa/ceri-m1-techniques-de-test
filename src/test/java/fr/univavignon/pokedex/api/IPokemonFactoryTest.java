package fr.univavignon.pokedex.api;

import org.assertj.core.api.Assertions;
import org.junit.* ;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp(){
        this.pokemonFactory = new PokemonFactory();
        this.bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        this.aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    @Tag("PokemonFactory")
    @DisplayName("canCreatePokemon")
    public void CreatePokemonTest(){

        int bulbizarreIndex = 0, bulbizarreCp = 613, bulbizarreHp = 64, bulbizarreDust = 4000, bulbizarreCandy = 4;
        int aqualiIndex = 133, aqualiCp = 2729, aqualiHp = 202, aqualiDust = 5000, aqualiCandy= 4;
        int invalidIndex = -1;

        assertNull(pokemonFactory.createPokemon(invalidIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy));

        assertThat(pokemonFactory.createPokemon(bulbizarreIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy).getIndex())
                .isEqualTo(bulbizarre.getIndex());
        assertThat(pokemonFactory.createPokemon(aqualiIndex, aqualiCp, aqualiHp, aqualiDust, aqualiCandy).getIndex())
                .isEqualTo(aquali.getIndex());
        assertThat(pokemonFactory.createPokemon(bulbizarreIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy).getHp())
                .isEqualTo(bulbizarre.getHp());
        assertThat(pokemonFactory.createPokemon(aqualiIndex, aqualiCp, aqualiHp, aqualiDust, aqualiCandy).getDust())
                .isEqualTo(aquali.getDust());
        assertThat(pokemonFactory.createPokemon(bulbizarreIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy).getCandy())
                .isEqualTo(bulbizarre.getCandy());
        assertThat(pokemonFactory.createPokemon(aqualiIndex, aqualiCp, aqualiHp, aqualiDust, aqualiCandy).getIv())
                .isEqualTo(aquali.getIv())
                .isCloseTo(aquali.getIv(), Assertions.offset(0.1));
    }
}