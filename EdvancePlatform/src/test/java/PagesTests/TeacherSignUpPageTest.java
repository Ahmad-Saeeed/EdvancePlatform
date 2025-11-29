package PagesTests;

import Pages.TeacherSignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeacherSignUpPageTest extends BaseTest{
    @Test
    public void successfullSignUpTest(){
        TeacherSignUpPage signUpPage = new TeacherSignUpPage(bot);
        signUpPage.navigateToSignUpPage();
        signUpPage.selectInstructorField();
        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterPassword();
        signUpPage.enterConfirmPassword();
        signUpPage.nextButtonClick();
        signUpPage.verifyButtonClick();
        Assert.assertTrue(signUpPage.signUpPageLanding());

    }
}
