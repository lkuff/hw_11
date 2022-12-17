import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubTest extends TestBase {
    @Test
    void gitSelenideTest() {
        step("Open GitHub Selenide Page", () -> {
            open("https://github.com/selenide/selenide");
        });
        step("Open Wiki section of the project", () -> {
            $("#wiki-tab").click();
        });
        step("Check page SoftAssertions in the page list", () -> {
            $(".js-wiki-more-pages-link").click();
            $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Open page SoftAssertions and check it has JUnit5 code", () -> {
            $("#wiki-pages-box").$(byText("SoftAssertions")).click();
            $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        });
    }
}
