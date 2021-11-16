package irina.client;

import irina.entity.Entrance;
import irina.entity.Entrances;

public interface AccessControlClient {
    Entrance getAccess(Entrances entrance, int keyId, int roomId);
}
