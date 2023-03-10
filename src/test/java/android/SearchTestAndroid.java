package android;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;


import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchTestAndroid extends TestBase {


    @Test
    public void successfulSearchTest() throws MalformedURLException, InterruptedException {


        $(AppiumBy.accessibilityId("Search Wikipedia")).click();

        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");

        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));

    }
}

