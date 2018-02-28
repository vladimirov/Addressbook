package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().clickOnNextButton();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}
