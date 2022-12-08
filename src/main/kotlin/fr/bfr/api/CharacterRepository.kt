package fr.bfr.api

import fr.bfr.model.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface CharacterRepository : JpaRepository<Character?, Long?> {
    override fun findAll(): List<Character?>
}
