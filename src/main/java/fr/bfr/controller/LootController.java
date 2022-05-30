package fr.bfr.controller;

import fr.bfr.api.CharacterRepository;
import fr.bfr.api.DropRepository;
import fr.bfr.api.LootApi;
import fr.bfr.model.Character;
import fr.bfr.model.DropChance;
import fr.bfr.services.LootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LootController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private DropRepository dropRepository;

    @GetMapping(value = "/pull", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Character>> pull() throws IOException {
        List<Character> characters = characterRepository.findAll();
        List<DropChance> dropChances = dropRepository.findAll();

        // looting system initialization
        LootApi lootApi = new LootService();
        List<Character> lootedCharacters = lootApi.pull(characters, dropChances, 10);

        return new ResponseEntity<>(lootedCharacters, HttpStatus.OK);
    }
}
