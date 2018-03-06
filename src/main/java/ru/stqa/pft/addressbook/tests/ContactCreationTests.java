package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().clickOnNextButton();
        File photo = new File("src/main/resources/stru.jpg");
        app.getContactHelper().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

/*    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println("src/main/resources/stru.jpg");
        File photo = new File("src/main/resources/stru.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }*/


}
