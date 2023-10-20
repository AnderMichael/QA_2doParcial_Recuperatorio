package filaC;

import apiTest.factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    public String post;
    public String put;
    public String get;
    public String delete;
    public RequestInfo requestInfo;
    public Response response;
    public TestBase() {
        this.post = "post";
        this.put = "put";
        this.get = "get";
        this.delete = "delete";
    }

    @BeforeEach
    public void before() {
        requestInfo = new RequestInfo();
    }
}
