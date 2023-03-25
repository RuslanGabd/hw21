package localAndroid;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    public static String env = System.getProperty("env");
    @BeforeAll
    static void BeforeAll() {
        switch (env) {
            case "browserstack":
                Configuration.browser = BrowserStackMobileDriver.class.getName();
                break;
            case "emulation":
            case "real":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                throw new RuntimeException();
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void AfterEach() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        if (env.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }


}
