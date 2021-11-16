package irina.client.impl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import irina.client.RoomClient;
import irina.entity.Room;

public class RoomClientImpl implements RoomClient {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public Room getInfRoom() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
//                метод get
                .request("GET", "/info/rooms")
//                вывести всё на печать
                .prettyPeek()
                //проверить
                .then()
                //что статус код 200
                .statusCode(200)
                .extract()
                //достать тело
                .body()
                //как информацию о комнате
                .as(Room.class);
    }
}
