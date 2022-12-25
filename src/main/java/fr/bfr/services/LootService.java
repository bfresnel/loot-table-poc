package fr.bfr.services;

import fr.bfr.api.LootApi;
import fr.bfr.model.Character;
import fr.bfr.model.DropChance;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class LootService implements LootApi {

    private final SecureRandom secureRandom = new SecureRandom();

    @NotNull
    @Override
    public List<Character> pull(@NotNull List<? extends Character> data, @NotNull List<DropChance> dropChances,
                                int numberOfPull) {
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
            pulledCharacters.add(charactersListWithDropChance.get(secureRandom.nextInt(100)));
            counter += 1;
        }

        return pulledCharacters.stream()
                .sorted()
                .toList();
    }
}
