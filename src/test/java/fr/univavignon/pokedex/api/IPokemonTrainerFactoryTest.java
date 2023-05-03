package fr.univavignon.pokedex.api;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;


    @Before
    public void setUp(){
        this.pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    }

    @Test
    @Tag("PokemonTrainerFactory")
    @DisplayName("canCreateTrainer")
    public void canCreateTrainerTest(){

        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
        Team mystic = Team.MYSTIC;
        Pokedex pokedex = Mockito.mock(Pokedex.class);
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Arcanine",mystic,pokedex);

        Mockito.doReturn(pokemonTrainer).when(this.pokemonTrainerFactory).createTrainer("Arcanine",mystic,pokedexFactory);

        assertThat(this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getClass())
                .isEqualTo(pokemonTrainer.getClass());
        assertThat(this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getName())
                .isEqualTo("Arcanine");
        assertThat(this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getTeam())
                .isEqualTo(mystic);
        assertThat(this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getPokedex().getClass())
                .isEqualTo(pokedex.getClass());
        assertThat(this.pokemonTrainerFactory.createTrainer("Arcanine",mystic,pokedexFactory).getPokedex().size())
                .isEqualTo(pokedex.size());

    }
}