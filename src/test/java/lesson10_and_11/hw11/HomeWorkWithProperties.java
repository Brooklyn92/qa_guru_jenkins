package lesson10_and_11.hw11;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HomeWorkWithProperties extends TestBaseHW11 {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @Tag("hw11")
    public void testLambda() {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenshot());
        });

    }

    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}