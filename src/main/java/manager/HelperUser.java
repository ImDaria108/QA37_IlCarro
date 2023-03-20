package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()='Log in']"));
    }
    public void fillLoginForm (String email, String password){

        type(By.id("email"), email);
        type(By.id("password"),password);

    }

    public void submitLogin (){
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[type='button']"));

    }


    public boolean isLogged() {

       return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
    }

    public void logOut() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }

}
