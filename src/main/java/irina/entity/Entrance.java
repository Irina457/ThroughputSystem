package irina.entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor

public class Entrance {
    @Getter
    private Entrances entrance;
    private int keyId;
    private int roomId;
}