package api;

import api.model.PublicApis;
import jdk.jfr.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import utils.Report;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class EntriesTest {

    private final String URI = "https://api.publicapis.org/entries";

    @Description("Get all public api with property “Category: Authentication & Authorization")
    @Test
    public void test() {
        final String QUERY_PARAM = "Category";
        final String CATEGORY_NAME = "Authentication & Authorization";
        PublicApis getResponse =
                given()
                        .log()
                        .all()
                        .queryParam(QUERY_PARAM, CATEGORY_NAME)
                        .when()
                        .get(URI)
                        .then()
                        .assertThat()
                        .log()
                        .all()
                        .statusCode(SC_OK)
                        .extract()
                        .response()
                        .getBody().as(PublicApis.class);
        int countValue = getResponse.getCount();
        int entriesValue = getResponse.getEntries().size();
        Assertions.assertThat(countValue)
                .withFailMessage("PublicApis count is not equal to entries, " +
                        "count property in PublicApis is %s and entries count is %s", countValue, entriesValue)
                .isEqualTo(entriesValue);
        getResponse.getEntries().forEach(entry -> Report.info(entry.toString()));
    }

}
