package PagesTests;

import Pages.StudentSignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentSignUpPageTest extends BaseTest
{

    @Test
    public void platformLogoNavigation()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnPlatformLogo();

        String expectedURL="https://edvance-ace.vercel.app/";
        String actualURL=sUpPg.currentURLAfterLoading(expectedURL+"signup");
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void loginLinkFromHeader()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnLoginLinkFromHeader();

        String expectedURL="https://edvance-ace.vercel.app/login";
        String actualURL=sUpPg.currentURLAfterLoading("https://edvance-ace.vercel.app/signup");
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void loginLinkFromForm()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnLoginLinkFromForm();

        String expectedURL="https://edvance-ace.vercel.app/login?redirect=%2Fadmin%2Flogin";
        String actualURL=sUpPg.currentURLAfterLoading("https://edvance-ace.vercel.app/signup");
        Assert.assertEquals(actualURL,expectedURL);
    }






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


    @Test
    public void firstNameFieldMandatory()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidLastName();
        sUpPg.enterValidEmail();
        sUpPg.enterValidPhoneNumber();
        sUpPg.selectGrade();
        sUpPg.enterValidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertTrue(sUpPg.errorMessageDisplayedText().contains("يجب أن يكون حرفين على الأقل"));
    }

    @Test
    public void lastNameFieldMandatory()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidFirstName();
        sUpPg.enterValidEmail();
        sUpPg.enterValidPhoneNumber();
        sUpPg.selectGrade();
        sUpPg.enterValidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertTrue(sUpPg.errorMessageDisplayedText().contains("يجب أن يكون حرفين على الأقل"));
    }

    @Test
    public void emailFieldMandatory()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidFirstName();
        sUpPg.enterValidLastName();
        sUpPg.enterValidPhoneNumber();
        sUpPg.selectGrade();
        sUpPg.enterValidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),("البريد الإلكتروني غير صحيح"));
    }

    @Test
    public void invalidPhoneNumber()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidFirstName();
        sUpPg.enterValidLastName();
        sUpPg.enterValidEmail();
        sUpPg.enterInvalidPhoneNumber();
        sUpPg.selectGrade();
        sUpPg.enterValidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),"رقم الهاتف يجب أن يكون رقم مصري صحيح");
    }

    @Test
    public void gradeSelectionMandatory()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidFirstName();
        sUpPg.enterValidLastName();
        sUpPg.enterValidEmail();
        sUpPg.enterValidPhoneNumber();
        sUpPg.enterValidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),"يرجى اختيار المرحلة الدراسية");
    }

    @Test
    public void invalidDateOfBirth()
    {
        StudentSignUpPage sUpPg = new StudentSignUpPage(bot);
        sUpPg.navigateToSignUpPage();
        sUpPg.clickOnStudentCard();
        sUpPg.enterValidFirstName();
        sUpPg.enterValidLastName();
        sUpPg.enterValidEmail();
        sUpPg.enterValidPhoneNumber();
        sUpPg.selectGrade();
        sUpPg.enterInvalidDateOfBirth();
        sUpPg.enterValidPassword();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();


        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),"العمر يجب أن يكون بين 6 و 25 سنة");
    }

    @Test
    public void invalidPassword_Length()
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
        sUpPg.enterInvalidPasswordLength();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),"كلمة المرور يجب أن تكون 8 أحرف على الأقل");
    }

    @Test
    public void invalidPassword_Format()
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
        sUpPg.enterInvalidPasswordFormat();
        sUpPg.confirmWithValidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),"يجب أن تحتوي على حرف كبير واحد على الأقل");
    }

    @Test
    public void wrongConfirmationPassword()
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
        sUpPg.confirmWithInvalidPassword();
        sUpPg.clickOnNextButton();

        Assert.assertEquals(sUpPg.errorMessageDisplayedText(),"كلمات المرور غير متطابقة");
    }

    @Test
    public void termsAndConditionsCheckBoxMandatory()
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
        sUpPg.clickOnCreateAccount();

        Assert.assertEquals(sUpPg.popUpMsgContent(),"أوافق على الشروط والأحكام");

    }


}
