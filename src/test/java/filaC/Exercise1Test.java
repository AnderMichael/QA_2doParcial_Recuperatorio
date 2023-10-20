package filaC;

import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class Exercise1Test extends TestBase {
    private static String email;
    private static String fullName;
    private static String password;

    private static Random random = new Random();

    @BeforeAll
    public static void setup() {
        email = String.format("ander@andercito%s.com", random.nextInt());
        fullName = "Ander Michael";
        password = "pinias";
    }


    @Test
    public void createUserandItem() {
        JSONObject newUser = new JSONObject();
        newUser.put("Email", email);
        newUser.put("FullName", fullName);
        newUser.put("Password", password);

        createUser(newUser);

        Configuration.user = email;
        Configuration.password = password;

        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make(get).send(requestInfo);

        Configuration.token = response.then().extract().path("TokenString");
        System.out.println(Configuration.token);

        JSONObject newItem = new JSONObject();
        newItem.put("Content", "Frambuesa y Chocolate");

        createItem(newItem);

        Configuration.token = "NO HAY TOKEN";

        JSONObject newItem2 = new JSONObject();
        newItem2.put("Content", "Frambuesa y Chocolate 2");

        createItem2(newItem2);
    }

    private void createItem(JSONObject newItem) {
        requestInfo.setUrl(Configuration.host + "/api/items.json");
        requestInfo.setBody(newItem.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(newItem.get("Content")));

    }

    private void createItem2(JSONObject newItem) {
        requestInfo.setUrl(Configuration.host + "/api/items.json");
        requestInfo.setBody(newItem.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("Content", not(equalTo(newItem.get("Content"))));
    }

    private void createUser(JSONObject newUser) {
        requestInfo.setUrl(Configuration.host + "/api/user.json");
        requestInfo.setBody(newUser.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(newUser.get("Email"))).
                body("FullName", equalTo(newUser.get("FullName")));
    }


}
