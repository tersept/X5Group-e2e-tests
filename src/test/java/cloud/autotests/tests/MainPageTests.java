package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {
    @Test
    @Tags({@Tag("web"),@Tag("regress")})
    @DisplayName("Проверка смены языка")
    void changeLanguageTest() {
        step("Открываем 'https://www.x5.ru/'", () -> {
            open("https://www.x5.ru/ru/");
        });

        step("Нажимаем на кнопку  EN", () -> {
            $(".header__lang").click();
        });

        step("Проверяем, что язык на сайте поменялся", () -> {
            $(".header__content-menu").shouldHave(Condition.text("Company"));
            $(".header__content-menu").shouldHave(Condition.text("Consumer"));
            $(".header__content-menu").shouldHave(Condition.text("For Partners"));
            $(".header__content-menu").shouldHave(Condition.text("Investors"));
            $(".header__content-menu").shouldHave(Condition.text("Press Centre"));
        });
    }
    @Tags({@Tag("web"),@Tag("regress")})
    @Test
    @DisplayName("Проверка появления меню второго уровня")
    void subMenuVisibledTest() {
        step("Открываем 'https://www.x5.ru/'", () -> {
            open("https://www.x5.ru/ru/");
        });

        step("Наводим в меню на пункт Компания", () -> {
            $(byText("Компания")).hover();
        });

        step("Проверяем, что появилось меню второго уровня", () -> {
            $(".header__sub-menu-link-item").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.x5.ru/'", () ->
                open("https://www.x5.ru/ru/"));

        step("Page title should have text 'Главная - X5 Group'", () -> {
            String expectedTitle = "Главная - X5 Group";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
    @Tags({@Tag("web"),@Tag("regress")})
    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.x5.ru/'", () ->
                open("https://www.x5.ru/ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}