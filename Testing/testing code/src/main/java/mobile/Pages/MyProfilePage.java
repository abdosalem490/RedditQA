package mobile.Pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for declare my profile page components
 */
public class MyProfilePage extends Pages{

    /**
     * declare driver which used to access elements
     */
    //AppiumDriver<WebElement> driver;


    /**
     * Post Button In My Profile
     */

   @FindBy(xpath ="//android.view.View[@content-desc='Posts\n" + "Tab 1 of 3']")
    WebElement PostsButton;

   @FindBy(xpath ="//android.view.View[@content-desc='Posts Tab 1 of 3']")
    WebElement MyProfilePostsButton;


    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public MyProfilePage(AndroidDriver driver) {
        super(driver);
    }


    public void clickMyProfilePostsButton(){
        MyProfilePostsButton.click();
    }


    /**
     * NoNlegit App : Comments Button In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Comments\n" + "Tab 2 of 3']")
    WebElement CommentsButton;


    @FindBy(xpath ="//android.view.View[@content-desc='Comments Tab 2 of 3'")
    WebElement MyProfileCommentsButton;

    public void clickMyProfileCommentsButton(){
        MyProfileCommentsButton.click();
    }


    /**
     * NoNlegit App : About Button In My Profile
     */

    @FindBy(xpath =	"//android.view.View[@content-desc='About\n" + "Tab 3 of 3']")
    WebElement AboutButton;


    @FindBy(xpath =	"//android.view.View[@content-desc='About Tab 3 of 3']")
    WebElement MyProfileAboutButton;

    public void clickMyProfileAboutButton(){
        MyProfileAboutButton.click();
    }


    /**
     * NoNlegit App : Edit Button In My Profile
     */
    @FindBy(xpath ="//android.widget.Button[@content-desc='Edit']")
    WebElement EditButton;


    WebElement MyProfileEditButton;

    public void clickMyProfileEditButton(){
        MyProfileCommentsButton.click();
    }




    /**
     * NoNlegit App : User Name In My Profile
     */
    @FindBy(xpath ="(//android.view.View)[13]")
    WebElement MyProfileUserName;

    /**
     *
     * @return This Function Returns The User-Name Appears In My Profile
     */

    public String readMyProfileUserName(){
       return MyProfileCommentsButton.getText();
    }




    /**
     * NoNlegit App : Number Of Followers In My Profile
     */
    @FindBy(xpath ="(//android.widget.Button)[3]")
    WebElement MyProfileFollowers;

    /**
     *
     */
    public void clickMyProfileFollowers(){
        MyProfileFollowers.click();
    }

    /**
     *
     * @return This Function Returns The Number Of Followers Appears In My Profile
     */

    public String getNumberOfFollowers(){
        return MyProfileFollowers.getText();
    }

    /**
     * NoNlegit App : Sort By tab In My Profile
     */
    @FindBy(xpath ="(//android.widget.Button)[4]")
    WebElement SortBy;


    WebElement MyProfileSortBy;

    /**
     * This Function Click The Drop-Down Menu Of the Sort By
     */
    public void clickMyProfileSortBy(){
       MyProfileSortBy.click();
    }


    /**
     * NoNlegit App : Sort By Window In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='SORT POSTS BY']")
    WebElement SortByWindow;


    WebElement MyProfileSortByWindow;



    /**
     *
     * @return This Function Return The Name Of The Popped Window When Pressing The Sort By Tab
     */

    public String readMyProfileSortBy(){
        return MyProfileSortByWindow.getText();
    }

    /**
     * NoNlegit App : Sort By Window : Hot Tab In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Hot']")
    WebElement MyProfileSortByWindowHot;

    /**
     * This Function chooses Hot Post
     */
    public void clickMyProfileSortByWindowHot(){
        MyProfileSortByWindowHot.click();
    }

    /**
     * NoNlegit App : Sort By Window : New Button In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='New']")
    WebElement MyProfileSortByWindowNew;

    /**
     *
     */
    public void clickMyProfileSortByWindowNew(){
        MyProfileSortByWindowNew.click();
    }


    /**
     * NoNlegit App : Sort By Window : Top In My Profile
     */
    @FindBy(xpath ="//android.view.View[@content-desc='Top']")
    WebElement MyProfileSortByWindowTop;

    /**
     *
     */
    public void clickMyProfileSortByWindowTop(){
        MyProfileSortByWindowTop.click();
    }


    @FindBy(id="First Post")
    WebElement MyProfileFirstPost;

    @FindBy(xpath = "(//android.widget.Button)[1]")
    WebElement BackButton;

    public boolean checkName(String Name){
        waitForWebElementToAppear(MyProfileUserName,5);

        if(MyProfileUserName.getAttribute("content-desc").equals(Name)){
            return true;
        }
        return false;

    }

    public boolean sortByHot(){
        waitForWebElementToAppear(SortBy,5);
        SortBy.click();
        waitForWebElementToAppear(SortByWindow,5);
        if(SortByWindow.isDisplayed()&&SortByWindow.getAttribute("content-desc").equals("SORT POSTS BY")){

        }
        return false;
    }

    private boolean switchTo(WebElement element){
        waitForWebElementToAppear(element,5);
        element.click();
        threadSleep(2);
        if(checkForButton(element)){
            return true;
        }
        return false;
    }

    public boolean chooseWebElement (String element){
        switch (element){
        case "Posts":
            return switchTo(PostsButton)&&(SortBy.isDisplayed());
        case "Comments":
            return switchTo(CommentsButton)&&(driver.findElement(By.xpath("(//android.view.View)[17]")).getAttribute("content-desc").equals("Comments"));

        case "About":
            return switchTo(AboutButton)&&(driver.findElement(By.xpath("(//android.view.View)[21]")).getAttribute("content-desc").equals("0\nPost Karma"));
        }
        return false;
    }
    private boolean checkForButton(WebElement element){
        if(element.isDisplayed()){
            if(element.getAttribute("selected").equals("true")){
                return true;
            }
            return false;
        }
        return false;
    }




    public void backToHome(){
        waitForWebElementToAppear(BackButton,5);
        BackButton.click();
    }

    public void gotoEdit() {
        waitForWebElementToAppear(EditButton,5);
        EditButton.click();
    }
    public boolean  gotoFollowers() {
        threadSleep(2);
        driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
        return true;
    }

    ///Make it general Post
    public String clickPost(){
        try{
            MyProfileFirstPost.click();
        }catch(Exception i){
            return"fail";
        }
            return "success";
    }

}