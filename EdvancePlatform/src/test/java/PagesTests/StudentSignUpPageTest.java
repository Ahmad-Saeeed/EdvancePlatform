package PagesTests;

import Pages.StudentSignUpPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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


    @Test (dataProvider="signUp Data")
    public void signingUpForm(
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            String grade,
            String dataOfBirth,
            String password,
            String confirmedPassword,
            String testCase
                                    )
    {
        StudentSignUpPage signUpPage = new StudentSignUpPage(bot);
        signUpPage.navigateToSignUpPage();
        signUpPage.clickOnStudentCard();
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.selectGrade(grade);
        signUpPage.enterDateOfBirth(dataOfBirth);
        signUpPage.enterPassword(password);
        signUpPage.confirmPassword(confirmedPassword);
        signUpPage.clickOnNextButton();

        /*Based on the test case will assert the result*/
        switch (testCase)
        {
            //Commenting the valid signup to avoid this account is registered already
            /*case "Valid SignUp":
                signUpPage.selectFavoriteSubjects();
                signUpPage.selectYourGoal();
                signUpPage.clickOnNextButton();

                signUpPage.checkTheTermsAndConditionsBox();
                signUpPage.clickOnCreateAccount();

                Assert.assertTrue(signUpPage.successfulSignupWelcomeMsgDisplayed()&& signUpPage.loginButtonInSuccessfulSignupDisplayed());
                break;
*/
            case "First Name Mandatory":
                Assert.assertTrue(signUpPage.errorMessageDisplayedText().contains("يجب أن يكون حرفين على الأقل"));
            break;

            case "Last Name Mandatory":
                Assert.assertTrue(signUpPage.errorMessageDisplayedText().contains("يجب أن يكون حرفين على الأقل"));
            break;

            case "Email Field Mandatory":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),("البريد الإلكتروني غير صحيح"));
                break;

            case "Invalid Phone Number":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),"رقم الهاتف يجب أن يكون رقم مصري صحيح");
                break;

            case "Grade selection mandatory":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),"يرجى اختيار المرحلة الدراسية");
                break;

            case "Invalid date of birth":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),"العمر يجب أن يكون بين 6 و 25 سنة");
                break;

            case "Invalid Password Length":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),"كلمة المرور يجب أن تكون 8 أحرف على الأقل");
                break;

            case "Invalid Password Format":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),"يجب أن تحتوي على حرف كبير واحد على الأقل");
                break;

            case "Wrong confirmation password":
                Assert.assertEquals(signUpPage.errorMessageDisplayedText(),"كلمات المرور غير متطابقة");
                break;
        }


    }

    @Test
    public void termsAndConditionsCheckBoxMandatory()
    {
        StudentSignUpPage signUpPage = new StudentSignUpPage(bot);
        signUpPage.validInformationInputInFirstPageAndMoveToNextPage();
        signUpPage.selectFavoriteSubjects();
        signUpPage.selectYourGoal();
        signUpPage.clickOnNextButton();
        signUpPage.clickOnCreateAccount();

        Assert.assertEquals(signUpPage.popUpMsgContent(),"أوافق على الشروط والأحكام");

    }


    /*Data provider method to provide needed data to the signUp form*/
    @DataProvider(name="signUp Data")
    public Object [][] signUpData()
    {
        return new Object[][] {

                //  {"Ahmed","Tester","testEmail@testing.com","1234567890","primary-4","07022002","A1234567","A1234567","Valid SignUp"},
                {"","tester","email@test.com","1234567890","primary-4","07022002","A1234567","A1234567","First Name Mandatory"},
                {"Test","","email@test.com","1234567890","primary-4","07022002","A1234567","A1234567","Last Name Mandatory"},
                {"Test","tester","","1234567890","primary-4","07022002","A1234567","A1234567","Email Field Mandatory"},
                {"Test","tester","email@test.com","12345678","primary-4","07022002","A1234567","A1234567","Invalid Phone Number"},
                {"Ahmed","Tester","testEmail@testing.com","1234567890","","07022002","A1234567","A1234567","Grade selection mandatory"},
                {"Test","tester","email@test.com","1234567890","primary-4","07021998","A1234567","A1234567","Invalid date of birth"},
                {"Test","tester","email@test.com","1234567890","primary-4","07022002","A12345","A12345","Invalid Password Length"},
                {"Test","tester","email@test.com","1234567890","primary-4","07022002","12345678","12345678","Invalid Password Format"},
                {"Ahmed","Tester","testEmail@testing.com","1234567890","primary-4","07022002","A1234567","A1234566","Wrong confirmation password"},

        };
    }

}
