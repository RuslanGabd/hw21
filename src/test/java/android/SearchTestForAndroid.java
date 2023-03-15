package android;

import com.codeborne.selenide.commands.ShouldHave;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;



public class SearchTestForAndroid extends TestBase {

    @Test
    public void successfulSearchTest() {

        $(AppiumBy.accessibilityId("Search Wikipedia")).click();

        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Mercedes");

        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));

        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("Error"));
        $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
    }
}
