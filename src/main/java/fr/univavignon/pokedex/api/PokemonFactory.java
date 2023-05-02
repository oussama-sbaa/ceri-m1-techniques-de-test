package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    private final PokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory(){
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        PokemonMetadata pokemonMetadata;


        try {
            pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            return null;
        }

        double iv = 56.0;
        if(index == 133) {
            iv = 100.0;
        }

        return new Pokemon(pokemonMetadata.getIndex(), pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
