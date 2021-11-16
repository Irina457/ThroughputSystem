package irina.steps;

import io.cucumber.java.en.Given;
import irina.client.AccessControlClient;
import irina.client.RoomClient;
import irina.client.impl.AccessControlClientImpl;
import irina.client.impl.RoomClientImpl;
import irina.entity.Entrance;
import irina.entity.Entrances;
import irina.entity.Room;
import org.junit.Assert;

public class ApplicationTest {
    private final AccessControlClient accessControlClient = new AccessControlClientImpl();

    @Given("^Check ability entrance/exit$")
    public void checkEntrance() {
        //получить доступ
        final Entrance entrance1 = accessControlClient.getAccess(Entrances.ENTRANCE, 1, 1);
        System.out.println(entrance1);

        Assert.assertEquals(0, entrance1.getRoomId() % entrance1.getKeyId());
    }

    private final RoomClient roomClient = new RoomClientImpl();

    @Given("^Output information about rooms$")
    public void getRoomInfo() {
        final Room infRoom = roomClient.getInfRoom();
        System.out.println(infRoom);
    }
}
