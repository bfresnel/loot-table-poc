package fr.bfr.api

import fr.bfr.model.DropChance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.lang.NonNull
import org.springframework.stereotype.Service

@Service
interface DropRepository : JpaRepository<DropChance, Int> {
    @NonNull
    override fun findAll(): List<DropChance>
}
