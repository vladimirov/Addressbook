package ru.stqa.pft.addressbook.model;

import java.util.HashSet;
import java.util.Set;

public class ContactData {

    private int id;
    private String firstname;
    private String lastname;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
//    private String allPhones;
//    private String photo;

    private Set<GroupData> groups = new HashSet<GroupData>();

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.workPhone = mobilePhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }


//    public File getPhoto() {
//        return new File(photo);
//    }
//
//    public ContactData withPhoto(File photo) {
//        this.photo = photo.getPath();
//        return this;
//    }
//
//    public String getAllPhones() {
//        return allPhones;
//    }
//
//    public ContactData withAllPhones(String allPhones) {
//        this.allPhones = allPhones;
//        return this;
//    }

}
