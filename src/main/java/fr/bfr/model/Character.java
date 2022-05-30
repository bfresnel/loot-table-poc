package fr.bfr.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "t_character")
public class Character implements Comparable<Character> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
