package fr.bfr.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_drop")
class DropChance(
    @Id
    var rarity: Int,
    var chance: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DropChance

        if (rarity != other.rarity) return false
        if (chance != other.chance) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rarity
        result = 31 * result + chance
        return result
    }
}
