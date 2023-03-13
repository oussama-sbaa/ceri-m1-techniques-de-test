package fr.univavignon.pokedex.api;
import java.util.logging.Logger;
public class Tp1 {

    private static final Logger LOGGER = Logger.getLogger(Tp1.class.getName());

    public static void main(String[] args) {
        LOGGER.info("tp1:" + printTest());
    }
    public static String printTest() {
        return "Hello World!";
    }

}