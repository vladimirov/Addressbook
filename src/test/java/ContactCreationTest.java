


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTest extends TestBase {

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
}
