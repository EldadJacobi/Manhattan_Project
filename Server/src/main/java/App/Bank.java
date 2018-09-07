package App;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Bank {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;
    private @ManyToOne
    Dictionary dictionary;

}