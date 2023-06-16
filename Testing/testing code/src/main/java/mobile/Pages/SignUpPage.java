package mobile.Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends Pages{

    /**
     * this is the driver which is used in interacting with the browser
     */
    protected AndroidDriver driver;

    /**
     * this is the user email input text
     */
    @FindBy(xpath = "//android.widget.EditText[1]")
    WebElement emailInput;


    /**
     * this is the user email input text
     */
    @FindBy(xpath = "//android.widget.EditText[2]")
    WebElement usernameInput;


    /**
     * this is the user email input text
     */
    @FindBy(xpath = "//android.widget.EditText[3]")
    WebElement passwordInput;

    /**
     * this is the continue button
     */
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Continue\"]")
    WebElement continueButton;

    /**
     * this is man button select
     */
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Man\"]")
    WebElement manButton;

    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public SignUpPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * this method is used to sign up a person
     */
    public Home randomNamesSignUp(String email, String password, String username){
        waitForWebElementToAppear(emailInput, 1);
        emailInput.click();
        threadSleep(1);
        emailInput.sendKeys(email);
        driver.hideKeyboard();
        usernameInput.click();
        threadSleep(1);
        usernameInput.sendKeys(username);
        driver.hideKeyboard();
        passwordInput.click();
        threadSleep(1);
        passwordInput.sendKeys(password);
        driver.hideKeyboard();

        if(!continueButton.isEnabled())
            return null;

        continueButton.click();

        try {
            waitForWebElementToAppear(manButton, 3);
            manButton.click();
            waitForWebElementToDisappear(manButton, 3);
            return new Home(driver);
        }catch (Exception e){
            return null;
        }

    }
}