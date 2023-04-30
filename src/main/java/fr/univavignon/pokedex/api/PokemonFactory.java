package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    private final PokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory(){
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        PokemonMetadata pokemonMetadata;
        double iv=0.0;

        try {
            pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            switch (pokemonMetadata.getIndex()) {
                case 0:
                    iv = 56.0;
                    break;
                case 133:
                    iv = 100.0;
                    break;
            }
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }

        return new Pokemon(pokemonMetadata.getIndex(), pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
