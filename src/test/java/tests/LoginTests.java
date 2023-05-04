package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test(dataProvider = "loginData",dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password){
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data: ---> email: " +email+" & password : "+password);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("Assert check is Information window 'Logged in success' present");
    }

    @Test(dataProvider = "loginModels",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user){
        logger.info("Test data: ---> " + user.toString());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("Assert check is Information window 'Logged in success' present");
    }

    @Test(dataProvider = "loginFile2",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Test data: ---> " + user.toString());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("Assert check is Information window 'Logged in success' present");
    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data: ---> email: '...' & password 'Ashtanga8'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("...","Ashtanga8!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check is alert present with error text  'It'snot look like email'");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data: ---> email: 'dasha@gmail.com' & password 'Ashtanga8'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("dasha@gmail.com","Ashtanga8");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
        logger.info("Assert check is alert present with error text 'Login or Password incorrect'");
    }
    @Test
    public void loginUnregistered(){
        logger.info("Test data: ---> email: 'cat@mail.com' & password 'Mouse666@'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cat@mail.com","Mouse666@");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
        logger.info("Assert check is alert present with error text  'Login or Password incorrect'");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeWindow();
    }
}