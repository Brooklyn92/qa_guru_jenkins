package hw_github;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestIssueInGitHub {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }

    @Test
    public void testGit(){
        step("Открываем главную страницу GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий", () ->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в найденный репозиторий", ()-> {
            $(By.linkText(REPOSITORY)).click();
        });


        step("Переходим во вкладку Issue", ()-> {
            $("#issues-tab").click();
        });


        step("Убеждаемся, что номер issue отображается", ()-> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
