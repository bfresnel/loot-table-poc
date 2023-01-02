package fr.bfr.api

import fr.bfr.model.DropChance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DropChanceRepository : JpaRepository<DropChance, Int> {
    override fun findAll(): List<DropChance>
}
