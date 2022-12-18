package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement loginInput = $("name.username"),
            passwordInput = $("name.password");

    public LoginPage openPage() {
        open("https://mail.ru/");
        $(".ph-login").shouldHave(text("Войти"));
        return this;
    }

    public LoginPage openModal() throws InterruptedException {
        $(byText("Войти")).click();
        $(".ag-popup__frame__layout__iframe").should(appear);
        //    $("#login-content").should(appear);
        return this;
    }

    public LoginPage setLogin() {
        //$(".ag-popup__frame__layout__iframe.input-0-2-71").setValue("qaguru").pressEnter();
        switchTo().frame($("[class='ag-popup__frame__layout__iframe']"));
        $(".input-0-2-71").setValue("qaguru");
        return this;
    }

    public LoginPage clickSubmit() {
        $(".submit-button-wrap").click();
        return this;
    }

    public LoginPage setPassword() {
        $("[name='password']").setValue("guruqa_14");
        return this;
    }

    public LoginPage checkLogin() {
        $(".ph-avatar-img").shouldBe(visible);
        return this;
    }
}
