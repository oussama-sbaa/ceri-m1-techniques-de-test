package fr.univavignon.pokedex.api;

import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IPokedexTest {
    private IPokedex pokedex;
    private List<Pokemon> pokemons;
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp(){

        this.pokedex = Mockito.mock(IPokedex.class);
        pokemons = new ArrayList<>();

        //pokemons.add(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56.0));
        //pokemons.add(new Pokemon(133,"Aquali",186,186,260,2729,202,5000,4,100.0));

        bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56.0);
        aquali = new Pokemon(133,"Aquali",186,186,260,2729,202,5000,4,100.0);

        //add bulbizarre & aquali to the list
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
    }

    @Test
    @Tag("Pokedex")
    @DisplayName("Returns the number of pokemon this pokedex contains")
    public void SizeTest(){

        Mockito.doReturn(this.pokemons.size()).when(this.pokedex).size();

        //use of AssertJ in Junit5
        assertThat(this.pokedex.size()).isEqualTo(2);

    }

    @Test
    @Tag("Pokedex")
    @DisplayName("Locates the pokemon identified by the given <tt>id</tt>")
    public void AddPokemonTest() {

        Pokemon newPokemon = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);

        //Mockito.doReturn(newPokemon.getIndex()).when(this.pokedex).addPokemon(newPokemon);
        Mockito.doReturn(this.pokemons.size()+1).when(this.pokedex).addPokemon(newPokemon);
        //assertThat(this.pokedex.addPokemon(newPokemon)).isEqualTo(newPokemon.getIndex());
        assertThat(this.pokedex.addPokemon(newPokemon)).isEqualTo(3);
    }


    @Test
    @Tag("Pokedex")
    @DisplayName("Returns an unmodifiable list of all pokemons this pokedex contains")
    public void GetPokemonTest() throws PokedexException {


        int aqualiIndex = 133, bulbizarreIndex = 0, firstInvalidIndex = 170, secondInvalidIndex = -20;

        Mockito.doReturn(aquali).when(this.pokedex).getPokemon(aqualiIndex);
        Mockito.doReturn(bulbizarre).when(this.pokedex).getPokemon(bulbizarreIndex);
        Mockito.doThrow(new PokedexException("invalid given index")).when(this.pokedex).getPokemon(Mockito.intThat(i -> i < 0 || i > 150));

        //Use of AssertThat in JUnit5
        assertThat(this.pokedex.getPokemon(0)).isEqualTo(bulbizarre);
        assertThat(this.pokedex.getPokemon(133)).isEqualTo(aquali);

        //Use of AssertThat in JUnit5
        Assertions.assertThatThrownBy(() -> this.pokedex.getPokemon(firstInvalidIndex)).isInstanceOf(PokedexException.class);
        Assertions.assertThatThrownBy(() -> this.pokedex.getPokemon(secondInvalidIndex)).isInstanceOf(PokedexException.class);

    }


    @Test
    public void GetPokemonsTest(){

        List<Pokemon> TestPokemonsList = Collections.unmodifiableList(this.pokemons);

        Mockito.doReturn(TestPokemonsList).when(this.pokedex).getPokemons();

        //Use of AssertJ in JUnit5
        assertThat(this.pokedex.getPokemons().getClass()).isEqualTo(TestPokemonsList.getClass());
        assertThat(this.pokedex.getPokemons().size()).isEqualTo(TestPokemonsList.size());
        assertThat(this.pokedex.getPokemons().get(0)).isEqualTo(TestPokemonsList.get(0));
        assertThat(this.pokedex.getPokemons().get(1)).isEqualTo(TestPokemonsList.get(1));

    }


    @Test
    public void GetPokemonsOrdered(){

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


        Mockito.doReturn(Collections.unmodifiableList(nPokemonsOrdered)).when(this.pokedex).getPokemons(nComparator);
        Mockito.doReturn(Collections.unmodifiableList(iPokemonsOrdered)).when(this.pokedex).getPokemons(iComparator);
        Mockito.doReturn(Collections.unmodifiableList(cpPokemonsOrdered)).when(this.pokedex).getPokemons(cpComparator);

        //Use of AssertJ in JUnit5
        assertThat(this.pokedex.getPokemons(nComparator).getClass()).isEqualTo(edTestPokemonsList.getClass());
        assertThat(this.pokedex.getPokemons(iComparator).size()).isEqualTo(iPokemonsOrdered.size());
        assertThat(this.pokedex.getPokemons(nComparator).get(0)).isEqualTo(aquali);
        assertThat(this.pokedex.getPokemons(iComparator).get(0)).isEqualTo(bulbizarre);
        assertThat(this.pokedex.getPokemons(cpComparator).get(0)).isEqualTo(bulbizarre);

    }
}
