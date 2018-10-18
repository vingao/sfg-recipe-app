package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Notes() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof Notes;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", recipeNotes='" + recipeNotes + '\'' +
                '}';
    }
}
