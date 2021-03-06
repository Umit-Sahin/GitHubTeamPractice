package team.pages;

import team.utilities.ConfigurationReader;
import team.utilities.Drivers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Drivers.get(), this);
    }

    @FindBy(css = "[name='user']")
    public WebElement usernameInputBox;

    @FindBy(css = "[name='password']")
    public WebElement passwordInputBox;

    @FindBy(id = "submit-form")
    public WebElement submit;

    @FindBy(css = ".warning")
    public WebElement errorMsg;


    public void login(String usernameStr, String passwordStr){

        usernameInputBox.sendKeys(usernameStr);
        passwordInputBox.sendKeys(passwordStr);
        submit.click();
    }
    public void login(){
        String username = System.getProperty("username") !=null ?
                            System.getProperty("username") : ConfigurationReader.get("username");
        String password = System.getProperty("password") !=null ?
                System.getProperty("password") : ConfigurationReader.get("password");
        login(username,password);
    }

}