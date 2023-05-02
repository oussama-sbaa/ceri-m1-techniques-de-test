package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    public final List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider () {
        pokemonMetadataList = new ArrayList<>();
        PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonMetadataList.add(bulbizarre);
        pokemonMetadataList.add(aquali);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        PokemonMetadata results = null;
        if(index < 0 || index > 150) throw new PokedexException("Invalid given index");
        for (PokemonMetadata pokemonMetadata : pokemonMetadataList){
            if(pokemonMetadata.getIndex() == index) results =pokemonMetadata ;
        }
        return results;
    }
}