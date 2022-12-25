package fr.bfr.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_drop")
class DropChance {
    @Id
    val rarity: Int? = null
    val chance: Double? = null
}
