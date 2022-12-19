package cloud.autotests.tests;

import cloud.autotests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginFormTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    void fillForm() {
        step("Открываем страницу и модальное окно", () -> {
            loginPage.openPage()
                    .openModal();
        });
        step("Заполняем поля", () -> {
            loginPage.setLogin()
                    .clickSubmit()
                    .setPassword()
                    .clickSubmit();
        });
        step("Проверяем что зашли", () -> {
            loginPage.checkLogin();
        });
    }

    @Test
    void changeDomainGmail() {
        step("Меняем домен", () -> {
            loginPage.openPage()
                    .openModal()
                    .setGmail();
        });
        step("Проверяем, что домен поменялся", () -> {
            loginPage.checkGmail();
        });

    }

    @Test
    void changeDomainYandex() {
        step("Меняем домен", () -> {
            loginPage.openPage()
                    .openModal()
                    .setYandex();
        });
        step("Проверяем, что домен поменялся", () -> {
            loginPage.checkYandex();
        });

    }
}
