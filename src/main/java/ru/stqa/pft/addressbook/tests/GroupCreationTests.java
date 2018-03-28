package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[]{new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[]{new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));//hashing and pre-validation
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testNegativeGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));//hashing and pre-validation
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}


//Вычисление максимального значения 'value' у группы
//        int max = 0;
//        for (GroupData g : after) {
//            if (g.getId() > max) {
//                max = g.getId();
//            }
//        }

//Вычисление максимального значения 'value' у группы с помощью люмбда выражений
//int max = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId();
//group.withId(max);
//before.add(group);

//Для сравненя множеств
//Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
//before.sort(byId);
//after.sort(byId);

