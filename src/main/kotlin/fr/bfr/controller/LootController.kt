package fr.bfr.controller

import fr.bfr.model.Character
import fr.bfr.services.LootService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LootController @Autowired constructor(
    val lootService: LootService
) {
    @GetMapping(value = ["/pull"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun pull(): ResponseEntity<List<Character>> {
        logger.info("/pull endpoint was called !")
        logger.info("Retrieving all looted characters...")
        val lootedCharacters: List<Character> = lootService.pull(10)

        return ResponseEntity(lootedCharacters, HttpStatus.OK)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(LootController::class.java)
    }
}
