package fr.bfr.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_character")
class Character(
    @Id
    var id: Long,
    var name: String,
    var rarity: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Character

        if (id != other.id) return false
        if (name != other.name) return false
        if (rarity != other.rarity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + rarity
        return result
    }
}
