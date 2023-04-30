package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Pokedex implements IPokedex{
    private final List<Pokemon> pokemonList;

    public Pokedex() {
        pokemonList = new ArrayList<>();
        Pokemon  bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon  aquali =  new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
        pokemonList.add(bulbizarre);
        pokemonList.add(aquali);
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return size()+1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {

        Pokemon pokemon;
        try {
            pokemon = pokemonList.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Invalid given index");
        }
        return pokemon;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemonList = new ArrayList<>(pokemonList);
        sortedPokemonList.sort(order);
        return Collections.unmodifiableList(sortedPokemonList);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return new PokemonFactory().createPokemon(index,cp,hp,dust,candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return new PokemonMetadataProvider().getPokemonMetadata(index);
    }
}
