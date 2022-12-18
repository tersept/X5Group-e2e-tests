package cloud.autotests.tests;

import cloud.autotests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginFormTests {
    LoginPage loginPage = new LoginPage();
    String login,
            password;

    @Test
    void fillForm() {
        step("Заполняем поля", () -> {
            loginPage.openPage()
                    .openModal()
                    .setLogin()
                    .clickSubmit()
                    .setPassword()
                    .clickSubmit();
        });
        step("Проверяем что зашли", () -> {
        loginPage.checkLogin();
        });
    }
}
