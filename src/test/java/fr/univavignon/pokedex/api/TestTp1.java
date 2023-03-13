package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestTp1 {

    @Test
    public void simpleTest(){
        String expected = "Hello World!";
        assertEquals(expected, Tp1.printTest());
    }
}