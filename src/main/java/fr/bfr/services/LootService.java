package fr.bfr.services;

import fr.bfr.api.LootApi;
import fr.bfr.model.Character;
import fr.bfr.model.DropChance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LootService implements LootApi {

    private final Random random = new Random();

    @Override
    public List<Character> pull(List<Character> data, List<DropChance> dropChances, Integer numberOfPull) {
        List<Character> pulledCharacters = new ArrayList<>();
        List<Character> charactersListWithDropChance = new ArrayList<>();
        int counter = 0;

        // Setting an array of 100 characters with number of each character matching the chance
        for (DropChance dropChance : dropChances) {
            while (counter < dropChance.getChance()) {
                charactersListWithDropChance.add(data.get(dropChance.getRarity() - 1));
                counter++;
            }
            counter = 0;
        }

        while (counter < numberOfPull) {
            pulledCharacters.add(charactersListWithDropChance.get(random.nextInt(100)));
            counter += 1;
        }

        return pulledCharacters.stream()
                .sorted()
                .toList();
    }
}
