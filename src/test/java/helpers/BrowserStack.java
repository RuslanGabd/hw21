package helpers;

import config.MobileDriverConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static helpers.CustomAllureListener.withCustomTemplates;
import static java.lang.String.format;

public class BrowserStack {
    public static String getVideoUrl(String sessionId) {
        MobileDriverConfig config = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.getUser(), config.getPassword())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
