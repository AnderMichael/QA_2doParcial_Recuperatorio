package filaC;

import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class Exercise2Test extends TestBase {
    private static String email;
    private static String fullName;
    private static String password;

    private static Random random = new Random();

    public void setup() {
        email = String.format("ander@andercito%s.com", random.nextInt());
        fullName = "Ander Michael";
        password = "pinias";
    }


    @Test
    public void createUserandItem() {
        List<Integer> userIds = new ArrayList<>();
        List<JSONObject> users = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            JSONObject newUser = new JSONObject();

            setup();
            newUser.put("Email", email);
            newUser.put("FullName", fullName + i);
            newUser.put("Password", password);

            createUser(newUser);

            int idUser = response.then().extract().path("Id");
            userIds.add(idUser);
            users.add(newUser);
        }
        System.out.println(users);
        for (int i = 0; i <= 3; i++) {
            Configuration.user = (String) users.get(i).get("Email");
            Configuration.password = (String) users.get(i).get("Password");

            deleteUser(userIds.get(i), delete, users.get(i));
        }

    }

    private void createUser(JSONObject newUser) {
        requestInfo.setUrl(Configuration.host + "/api/user.json");
        requestInfo.setBody(newUser.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(newUser.get("Email"))).
                body("FullName", equalTo(newUser.get("FullName")));
    }

    private void deleteUser(int idUser, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/" + idUser + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email"))).
                body("FullName", equalTo(body.get("FullName")));
    }
}
