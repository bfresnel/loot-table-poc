package fr.bfr.api;

import fr.bfr.model.Character;
import fr.bfr.model.DropChance;

import java.util.List;

public interface LootApi {

    List<Character> pull(List<Character> data, List<DropChance> dropChances, Integer numberOfPull);
}
