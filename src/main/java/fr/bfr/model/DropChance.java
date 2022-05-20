package fr.bfr.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DropChance {
    private Integer rarity;
    private Integer chance;
}
