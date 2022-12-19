package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class X5MainPage {
    public X5MainPage openPage(){
        open("https://www.x5.ru/ru/");
        $(".hero-main__logo").shouldBe(Condition.visible);
        return this;
    }
    public X5MainPage changeLanguage(){
        $(".header__lang").click();
        return this;
    }
    public X5MainPage checkLanguage(){
        $(".header__content-menu").shouldHave(Condition.text("Company"));
        $(".header__content-menu").shouldHave(Condition.text("Consumer"));
        $(".header__content-menu").shouldHave(Condition.text("For Partners"));
        $(".header__content-menu").shouldHave(Condition.text("Investors"));
        $(".header__content-menu").shouldHave(Condition.text("Press Centre"));
        return this;
    }
    public X5MainPage hoverMenu(){
        $(byText("Компания")).hover();
        return this;
    }
    public X5MainPage checkSecondMenu(){
        $(".header__sub-menu-link-item").shouldBe(Condition.visible);
        return this;
    }
}
