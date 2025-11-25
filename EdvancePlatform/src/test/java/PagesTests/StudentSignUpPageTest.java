package PagesTests;

import Pages.StudentSignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentSignUpPageTest extends BaseTest
{
    @Test (enabled = false) // disabled due to email is already used problem
    public void successfulSigningUp()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidFirstName();
        sUpPg.enterValidLastName();
        sUpPg.enterValidEmail();
        sUpPg.enterValidPhoneNumber();
        sUpPg.selectGrade();
        sUpPg.enterValidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        sUpPg.selectFavoriteSubjects();
        sUpPg.selectYourGoal();
        sUpPg.clickOnNextButton();

        sUpPg.checkTheTermsAndConditionsBox();
        sUpPg.clickOnCreateAccount();

        Assert.assertTrue(sUpPg.successfulSignupWelcomeMsgDisplayed()&& sUpPg.loginButtonInSuccessfulSignupDisplayed());

    }





}
