package fr.bfr.controller;

import fr.bfr.api.CharacterRepository;
import fr.bfr.api.DropRepository;
import fr.bfr.model.Character;
import fr.bfr.model.DropChance;
import fr.bfr.services.LootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LootController {

    private static final Logger logger = LoggerFactory.getLogger(LootController.class);

    private CharacterRepository characterRepository;

    private DropRepository dropRepository;

    private LootService lootService;
    
    @Autowired
    public LootController(CharacterRepository characterRepository, DropRepository dropRepository,
                          LootService lootService) {
        this.characterRepository = characterRepository;
        this.dropRepository = dropRepository;
        this.lootService = lootService;
    }

    @GetMapping(value = "/pull", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Character>> pull() {
        logger.info("/pull endpoint was called !");
        List<Character> characters = characterRepository.findAll();
        List<DropChance> dropChances = dropRepository.findAll();
        List<Character> lootedCharacters = new ArrayList<>();

        if (characters.size() > 0 && dropChances.size() > 0) {
            logger.info("Retrieving all looted characters...");
            lootedCharacters = lootService.pull(characters, dropChances, 10);
            logger.info("Characters looted successfully !");
        }

        return new ResponseEntity<>(lootedCharacters, HttpStatus.OK);
    }
}
