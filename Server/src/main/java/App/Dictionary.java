package App;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Dictionary {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private @NonNull String version = "1.1.1.1";
}
