package db.streamapi.cat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Cat {
    private String name;
    private String breed;
    private String registry;
}
