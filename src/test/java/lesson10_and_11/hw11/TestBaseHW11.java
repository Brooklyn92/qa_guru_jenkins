package lesson10_and_11.hw11;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBaseHW11 {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // отображает все методы в Allure
        Configuration.startMaximized = true; // разворачивает браузер во все экран
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        String login = credentials.login();
        String password = credentials.password();
        Configuration.remote = format("https://%s:%s@%s", login, password, url);
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
