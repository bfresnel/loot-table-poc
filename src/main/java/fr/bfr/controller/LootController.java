package fr.bfr.controller;

import fr.bfr.api.DataApi;
import fr.bfr.api.LootApi;
import fr.bfr.model.Character;
import fr.bfr.model.DropChance;
import fr.bfr.services.DataService;
import fr.bfr.services.LootService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LootController {

    @GetMapping("/pull")
    public ResponseEntity<String> pull() throws IOException {
        // Data Initialization
        DataApi dataApi = new DataService();
        List<Character> characters = dataApi.loadCharacters();
        List<DropChance> dropChances = dataApi.loadDropChance();
        int counter = 1;

        // looting system initialization
        LootApi lootApi = new LootService();
        List<Character> lootedCharacters;

        while (counter <= 5) {
            System.out.println("===================");
            System.out.println("    LOOTING N°" + counter);
            System.out.println("===================");

            lootedCharacters = lootApi.pull(characters, dropChances, 10);
            lootedCharacters.forEach(System.out::println);
            System.out.println("\n");
            counter++;
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
