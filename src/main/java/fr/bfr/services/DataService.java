package fr.bfr.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.bfr.api.DataApi;
import fr.bfr.model.Character;
import fr.bfr.model.DropChance;

import java.io.IOException;
import java.util.List;

public class DataService implements DataApi {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Character> loadCharacters() throws IOException {

        return mapper.readValue(this.getClass()
                        .getClassLoader()
                        .getResourceAsStream("characters.json"),
                new TypeReference<List<Character>>() {
                });
    }

    @Override
    public List<DropChance> loadDropChance() throws IOException {
        return mapper.readValue(this.getClass()
                        .getClassLoader()
                        .getResourceAsStream("drop-chance.json"),
                new TypeReference<List<DropChance>>() {
                });
    }
}
