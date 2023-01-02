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
)
