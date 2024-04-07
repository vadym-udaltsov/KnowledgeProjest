package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import restAssured.models.registration.FailedRegisterModel;
import restAssured.models.registration.RequestRegisterModel;
import restAssured.models.registration.SuccessRegisterModel;
import restAssured.models.resource.ResourceData;
import restAssured.models.userlist.DataUserModel;
import restAssured.specifications.Specifications;

import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TestRestAssured {
    private static final String URL = "https://reqres.in/";

    @Test
    public void firstRestAssured() {
        var users = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("data", DataUserModel.class);

        var avatarContainsId = users.stream()
                .allMatch(x -> x.getAvatar().contains(x.getId().toString()));

        var emails = users.stream()
                .map(DataUserModel::getEmail)
                .collect(Collectors.toList());

        Assert.assertTrue("Avatar should contains Id", avatarContainsId);
        Assert.assertTrue("Avatar should contains Id", emails.stream().allMatch(e -> e.contains("reqres")));
    }

    @Test
    public void secondRestAssured() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        var users = given()
                .when()
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath()
                .getList("data", DataUserModel.class);

        var avatarContainsId = users.stream()
                .allMatch(x -> x.getAvatar().contains(x.getId().toString()));

        var emails = users.stream()
                .map(DataUserModel::getEmail)
                .collect(Collectors.toList());

        Assert.assertTrue("Avatar should contains Id", avatarContainsId);
        Assert.assertTrue("Avatar should contains Id", emails.stream().allMatch(e -> e.contains("reqres")));
    }

    @Test
    public void successLoginTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        var id = "4";
        var token = "QpwL5tke4Pnpja7X4";
        var user = new RequestRegisterModel("eve.holt@reqres.in", "pistol");

        var responseUser = given()
                .when()
                .body(user)
                .post(URL + "api/register")
                .then().log().all()
                .extract()
                .as(SuccessRegisterModel.class);

        Assert.assertEquals(responseUser.getId(), id);
        Assert.assertEquals(responseUser.getToken(), token);

    }

    @Test
    public void failedLoginTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        var user = new RequestRegisterModel("eve.holt@reqres.in");

        var failedRegister = given()
                .when()
                .body(user)
                .post(URL + "api/register")
                .then().log().all()
                .extract()
                .as(FailedRegisterModel.class);

        Assert.assertEquals(failedRegister.getError(), "Missing password");
    }

    @Test
    public void sortedYearsTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());

        var resourceDataList = given()
                .when()
                .get(URL + "api/unknown")
                .then().log().all()
                .extract().body().jsonPath()
                .getList("data", ResourceData.class);

        var years = resourceDataList.stream()
                .map(ResourceData::getYear)
                .collect(Collectors.toList());
        var sortedYears = years.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(sortedYears, years);
    }
    @Test
    public void deleteUser() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseCustomSpec(204));

        given()
                .when()
                .delete(URL + "api/users/2")
                .then().log().all();
    }
}
