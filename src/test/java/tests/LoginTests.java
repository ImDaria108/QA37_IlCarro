package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void preCondition(){

        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void loginSuccess(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("dasha@gmail.com","Ashtanga8!");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void loginSuccessModel(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("dasha@gmail.com","Ashtanga8!");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());

    }
}
