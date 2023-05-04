## Summary
##### After testing the RocketPokemonFactory class, I noticed that two asserts have failed.   
- The first test failed because the expected value 
was null but the actual value was 
fr.univavignon.pokedex.api.Pokemon@2df32bf7.
This means that the test was expecting 
to receive a null value but instead received 
an object of type 
fr.univavignon.pokedex.api.Pokemon.

- The second test failed because the expected value 
was 100.0 but the actual value was 1.0. 
This means that the test was expecting 
two values to be equal, but they were not (Incorrect IV values calculated).