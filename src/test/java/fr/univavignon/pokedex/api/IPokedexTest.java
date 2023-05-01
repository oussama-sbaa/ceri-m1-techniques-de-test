package fr.univavignon.pokedex.api;

import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IPokedexTest {
    private Pokedex pokedex;
    private List<Pokemon> pokemons;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp(){
        pokedex = new Pokedex();
        pokemons = new ArrayList<>();

        //pokemons.add(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56.0));
        //pokemons.add(new Pokemon(133,"Aquali",186,186,260,2729,202,5000,4,100.0));

        bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56.0);
        aquali = new Pokemon(133,"Aquali",186,186,260,2729,202,5000,4,100.0);

        //add bulbizarre & aquali to the list
        pokedex.addPokemon(bulbizarre);
        this.pokedex.addPokemon(aquali);
        pokemons = pokedex.getPokemons();
    }

    @Test
    @Tag("Pokedex")
    @DisplayName("Returns the number of pokemon this pokedex contains")
    public void sizeTest(){


        //use of AssertJ in Junit5
        assertThat(pokemons.size()).isEqualTo(2);
    }

    @Test
    @Tag("Pokedex")
    @DisplayName("Locates the pokemon identified by the given <tt>id</tt>")
    public void addPokemonTest() {

        Pokemon newPokemon = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        //assertThat(this.pokedex.addPokemon(newPokemon)).isEqualTo(newPokemon.getIndex());
        assertThat(this.pokedex.addPokemon(newPokemon)).isEqualTo(pokemons.size());
    }


    @Test
    @Tag("Pokedex")
    @DisplayName("Returns an unmodifiable list of all pokemons this pokedex contains")
    public void getPokemonTest() throws PokedexException {


        int aqualiIndex = 1, bulbizarreIndex = 0, firstInvalidIndex = 170, secondInvalidIndex = -20;

        assertThat(this.pokedex.getPokemon(aqualiIndex)).isEqualTo(aquali);
        assertThat(this.pokedex.getPokemon(bulbizarreIndex)).isEqualTo(bulbizarre);
        assertThat(this.pokedex.getPokemon(aqualiIndex).getName()).isEqualTo(aquali.getName());
        assertThat(this.pokedex.getPokemon(bulbizarreIndex).getAttack()).isEqualTo(bulbizarre.getAttack());
        assertThat(this.pokedex.getPokemon(aqualiIndex).getDefense()).isEqualTo(aquali.getDefense());
        assertThat(this.pokedex.getPokemon(bulbizarreIndex).getStamina()).isEqualTo(bulbizarre.getStamina());

        //Use of AssertThat in JUnit5
        Assertions.assertThatThrownBy(() -> this.pokedex.getPokemon(firstInvalidIndex)).isInstanceOf(PokedexException.class);
        Assertions.assertThatThrownBy(() -> this.pokedex.getPokemon(secondInvalidIndex)).isInstanceOf(PokedexException.class);

    }


    @Test
    @Tag("Pokedex")
    @DisplayName("Returns an unmodifiable list of all pokemons this pokedex contains")
    public void getPokemonsTest(){

        List<Pokemon> TestPokemonsList = Collections.unmodifiableList(this.pokemons);

        //Use of AssertJ in JUnit5
        assertThat(this.pokedex.getPokemons().getClass()).isEqualTo(TestPokemonsList.getClass());
        assertThat(this.pokedex.getPokemons().size()).isEqualTo(TestPokemonsList.size());
        assertThat(this.pokedex.getPokemons().get(0)).isEqualTo(TestPokemonsList.get(0));
        assertThat(this.pokedex.getPokemons().get(1)).isEqualTo(TestPokemonsList.get(1));

    }


    @Test
    @Tag("Pokedex")
    @DisplayName("Returns an unmodifiable list of all pokemons this pokedex contains")
    public void getPokemonsOrdered(){

        PokemonComparators nComparator = PokemonComparators.NAME;
        PokemonComparators iComparator = PokemonComparators.INDEX;
        PokemonComparators cpComparator = PokemonComparators.CP;

        List<Pokemon> nPokemonsOrdered = new ArrayList<>(this.pokemons);
        nPokemonsOrdered.sort(nComparator);

        List<Pokemon> iPokemonsOrdered = new ArrayList<>(this.pokemons);
        iPokemonsOrdered.sort(iComparator);

        List<Pokemon> cpPokemonsOrdered = new ArrayList<>(this.pokemons);
        cpPokemonsOrdered.sort(cpComparator);

        List<Pokemon> edTestPokemonsList = Collections.unmodifiableList(new ArrayList<>());

        //Use of AssertJ in JUnit5
        assertThat(this.pokedex.getPokemons(nComparator).getClass()).isEqualTo(edTestPokemonsList.getClass());
        assertThat(this.pokedex.getPokemons(iComparator).size()).isEqualTo(iPokemonsOrdered.size());
        assertThat(this.pokedex.getPokemons(nComparator).get(0)).isEqualTo(aquali);
        assertThat(this.pokedex.getPokemons(iComparator).get(0)).isEqualTo(bulbizarre);
        assertThat(this.pokedex.getPokemons(cpComparator).get(0)).isEqualTo(bulbizarre);

    }
}
