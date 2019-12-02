package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Test
public class SortStringsInPlace {
    public void testSortStringsInPlace() {
        List<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        Collections.sort(list);
        Assert.assertEquals(list.get(0), "Boyle");
        Assert.assertEquals(list.get(1), "Camus");
        Assert.assertEquals(list.get(2), "Heller");
        Assert.assertEquals(list.get(3), "Kafka");
    }

    public void testSortStringsInNewList() {
        List<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        ArrayList<String> sortList = new ArrayList<>(list);
        Collections.sort(sortList);
        Assert.assertEquals(sortList.get(0), "Boyle");
        Assert.assertEquals(sortList.get(1), "Camus");
        Assert.assertEquals(sortList.get(2), "Heller");
        Assert.assertEquals(sortList.get(3), "Kafka");

        Assert.assertEquals(list.get(0), "Heller");
        Assert.assertEquals(list.get(1), "Kafka");
        Assert.assertEquals(list.get(2), "Camus");
        Assert.assertEquals(list.get(3), "Boyle");
    }

    public void testStringCompareTo() {
        Assert.assertTrue("A".compareTo("B") < 0);
        Assert.assertEquals("A".compareTo("A"), 0);
        Assert.assertTrue("B".compareTo("A") > 0);
    }
}
