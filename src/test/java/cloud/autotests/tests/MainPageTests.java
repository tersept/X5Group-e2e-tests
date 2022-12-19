package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import cloud.autotests.pages.X5MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
@Tags({@Tag("web"),@Tag("regress")})
public class MainPageTests extends TestBase {
    X5MainPage x5MainPage = new X5MainPage();
    @Test
    @DisplayName("Проверка появления меню второго уровня")
    void subMenuVisibleTest() {
        step("Открываем 'https://www.x5.ru/ru/'", () -> {
            x5MainPage.openPage();
        });
        step("Наводим в меню на пункт Компания", () -> {
            x5MainPage.hoverMenu();
        });

        step("Проверяем, что появилось меню второго уровня", () -> {
            x5MainPage.checkSecondMenu();
        });
    }
    @Test
    @DisplayName("Проверка смены языка")
    void changeLanguageTest() {
        step("Открываем 'https://www.x5.ru/'", () -> {
           x5MainPage.openPage();
        });

        step("Нажимаем на кнопку  EN", () -> {
            x5MainPage.changeLanguage();
        });

        step("Проверяем, что язык на сайте поменялся", () -> {
            x5MainPage.checkLanguage();
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.x5.ru/'", () ->{
               x5MainPage.openPage();
        });

        step("Page title should have text 'Главная - X5 Group'", () -> {
            String expectedTitle = "Главная - X5 Group";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.x5.ru/'", () ->{
               x5MainPage.openPage();
        });

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}