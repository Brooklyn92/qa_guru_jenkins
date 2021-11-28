package lesson10_1.simple;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import helpers.Attach;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // отображает все методы в Allure
        Configuration.startMaximized = true; // разворачивает браузер во все экран
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";//запуск в селенойде(?)
        //подключаем для selenoida свойства
        DesiredCapabilities capabilities = new DesiredCapabilities(); // описывает дополнительные характеристики для Web driver при помощи пары ключ-значение
        capabilities.setCapability("enableVNC", true); // включаем картику работы на удалённом рабочем столе
        capabilities.setCapability("enableVideo", true); // включаем запись видео
        Configuration.browserCapabilities = capabilities;
    }


    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
