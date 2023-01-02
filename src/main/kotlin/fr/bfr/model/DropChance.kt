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
)
