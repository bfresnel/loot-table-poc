package fr.bfr.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Character implements Comparable<Character> {
    private String name;
    private Integer rarity;

    @Override
    public int compareTo(Character character) {
        if (this.rarity > character.rarity)
            return 1;
        else if (this.rarity.equals(character.rarity))
            return 0;
        else
            return -1;
    }
}
