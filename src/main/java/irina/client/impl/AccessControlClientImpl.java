package irina.client.impl;

import io.restassured.RestAssured;
import irina.client.AccessControlClient;
import irina.entity.Entrance;
import irina.entity.Entrances;
import lombok.Data;

@Data
public class AccessControlClientImpl implements AccessControlClient {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public Entrance getAccess(Entrances entrance, int keyId, int roomId) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .param("entrance", entrance)
                .param("keyId", keyId)
                .param("roomId", roomId)
                .request("GET", "/check")
                //вывести всё на печать
                .prettyPeek()
                //проверить
                .then()
                //что статус код 200
                .statusCode(200)
                .extract()
                //Entrance
                .body()
                .as(Entrance.class);
    }
}
