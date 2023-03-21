package localAndroid;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;


public class SearchTestForAndroid extends TestBase {
    @Tag("Android_local")
    @Test
    public void successfulSearchTest() {

        $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();

        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Mercedes");

        $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));

        $(id("org.wikipedia.alpha:id/page_list_item_description")).click();
        $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("Error"));
        $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
    }
}
