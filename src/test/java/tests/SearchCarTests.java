package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{


    @Test
    public void  searchCurrentMounthSuccess(){
        app.getHelperCar().searchCurrentMounth("Tel Aviv, Israel", "4/27/2023","4/28/2023");
        app.getHelperCar().getScreen("src/test/screenshots/current.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void  searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "6/30/2023","10/28/2023");
        app.getHelperCar().getScreen("src/test/screenshots/current1.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void  searchCurrentAnyPeriodSuccess(){
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "8/27/2023","1/12/2024");
        app.getHelperCar().getScreen("src/test/screenshots/current2.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void negativeSearch(){
        app.getHelperCar().searchInvalidPeriod("Tel Aviv, Israel", "3/12/2023","5/12/2023");
        app.getHelperCar().getScreen("src/test/screenshots/current3.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperCar().isErrorDisplayed("You can't pick date before today"));


    }
    @BeforeMethod
    public void postCondition(){
        app.getHelperCar().navigateByLogo();
    }
}
