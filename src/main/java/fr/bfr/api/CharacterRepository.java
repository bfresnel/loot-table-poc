package fr.bfr.api;

import fr.bfr.model.Character;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterRepository extends Repository<Character, Long> {

    List<Character> findAll();
}
