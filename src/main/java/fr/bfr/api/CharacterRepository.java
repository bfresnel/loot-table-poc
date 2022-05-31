package fr.bfr.api;

import fr.bfr.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findAll();
}
