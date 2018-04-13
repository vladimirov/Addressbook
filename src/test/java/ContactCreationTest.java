


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        for (int i = 0; i < 10; i++) {
            app.goTo().gotoHomePage();
            app.getContactHelper().initContactCreation();
            app.getContactHelper().clickOnNextButton();
            File photo = new File("src/main/resources/stru.png");
            app.getContactHelper().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo), true);
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().returnToHomePage();
        }

    }

}
