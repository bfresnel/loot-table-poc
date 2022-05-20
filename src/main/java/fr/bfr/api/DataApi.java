package fr.bfr.api;

import fr.bfr.model.Character;
import fr.bfr.model.DropChance;

import java.io.IOException;
import java.util.List;

public interface DataApi {

    List<Character> loadCharacters() throws IOException;

    List<DropChance> loadDropChance() throws IOException;
}
