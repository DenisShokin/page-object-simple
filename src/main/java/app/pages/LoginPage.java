package app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameField = $x("//input[@data-test='username']");
    private final SelenideElement passwordField = $x("//input[@data-test='password']");
    private final SelenideElement loginButton = $x("//input[@data-test='login-button']");

    private final SelenideElement errorContainer = $x("//div[@class='error-message-container error']/h3");

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.submit();
    }

    public String getErrorMessage() {
        return errorContainer.getText();
    }

}
