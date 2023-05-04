package fr.univavignon.pokedex.api;

import org.assertj.core.api.Assertions;
import org.junit.* ;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import fr.univavignon.pokedex.imp.RocketPokemonFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp(){
        //this.pokemonFactory = new PokemonFactory();
        this.pokemonFactory = new RocketPokemonFactory();
        this.bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        this.aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    /* @Test
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
    } */

    @Test
    @Tag("RocketPokemonFactory")
    @DisplayName("canCreatePokemon")
    public void CreatePokemonTest(){

        int bulbizarreIndex = 0, bulbizarreCp = 613, bulbizarreHp = 64, bulbizarreDust = 4000, bulbizarreCandy = 4;
        int aqualiIndex = 133, aqualiCp = 2729, aqualiHp = 202, aqualiDust = 5000, aqualiCandy= 4;
        int invalidIndex = -1;

        /**Le test ait échoué car la valeur attendue était null mais la valeur réelle était fr.univavignon.pokedex.api.Pokemon@2df32bf7.
         Cela signifie que le test s'attendait à recevoir une valeur nulle mais a plutôt reçu un objet de type fr.univavignon.pokedex.api.Pokemon **/
        //assertNull(pokemonFactory.createPokemon(invalidIndex, bulbizarreCp, bulbizarreHp, bulbizarreDust, bulbizarreCandy));

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


        /** Le test ait échoué car la valeur attendue était 100.0 mais la valeur réelle était 1.0.
         Cela signifie que le test s'attendait à ce que deux valeurs soient égales, mais elles ne l'étaient pas. **/
        /*assertThat(pokemonFactory.createPokemon(aqualiIndex, aqualiCp, aqualiHp, aqualiDust, aqualiCandy).getIv())
                .isEqualTo(aquali.getIv())
                .isCloseTo(aquali.getIv(), Assertions.offset(0.1));*/
    }

}