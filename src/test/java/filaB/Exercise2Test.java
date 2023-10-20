package filaB;

import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import filaC.TestBase;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class Exercise2Test extends TestBase {
    @Test
    public void create4ItemsAndDeleteThem(){
        JSONObject body = new JSONObject();
        body.put("Content","Item1");

        createItem(Configuration.host + "/api/items.json", body, post);
        int idItem1 = response.then().extract().path("Id");

        JSONObject body2 = new JSONObject();
        body2.put("Content","Item2");
        createItem(Configuration.host + "/api/items.json", body2, post);
        int idItem2 = response.then().extract().path("Id");

        JSONObject body3 = new JSONObject();
        body3.put("Content","Item3");
        createItem(Configuration.host + "/api/items.json", body3, post);
        int idItem3 = response.then().extract().path("Id");

        JSONObject body4 = new JSONObject();
        body4.put("Content","Item4");
        createItem(Configuration.host + "/api/items.json", body4, post);
        int idItem4 = response.then().extract().path("Id");

        deleteItem(idItem1,delete, body);
        deleteItem(idItem2,delete, body2);
        deleteItem(idItem3,delete, body3);
        deleteItem(idItem4,delete, body4);


    }
    private void createItem(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteItem(int idItem, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/items/" + idItem + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
}
