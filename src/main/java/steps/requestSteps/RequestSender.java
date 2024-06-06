package steps.requestSteps;

import io.restassured.response.Response;
import models.get.GettingAuthorsBooksRq;
import models.get.GettingAuthorsBooksXmlRq;
import models.post.SavingNewAuthorRq;
import models.post.SavingNewBookRq;
import static io.restassured.RestAssured.given;

public class RequestSender {

    public static Response getBooksXmlResponse(GettingAuthorsBooksXmlRq request) {
        return given()
                .spec(RequestBuilder.getBooksXmlSpec(request))
                .when()
                .post();
    }

    public static Response getBooksJsonResponse(GettingAuthorsBooksRq request) {
        return given()
                .spec(RequestBuilder.getBooksJsonSpec(request))
                .when()
                .get();
    }

    public static Response postAuthorResponse(SavingNewAuthorRq request) {
        return given()
                .spec(RequestBuilder.postAuthorSpec(request))
                .when()
                .post();
    }

    public static Response postBookResponse(SavingNewBookRq request) {
        return given()
                .spec(RequestBuilder.postBookSpec(request))
                .when()
                .post();
    }
}
