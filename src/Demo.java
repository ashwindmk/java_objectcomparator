import java.math.BigInteger;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        stringTest();

        numberTest();

        mapTest();

        listTest();
    }

    private static void stringTest() {
        Object o1 = "test1";
        Object o2 = new String("test1");
        System.out.println("strings are equal: " + ObjectComparator.areEqual(o1, o2));
    }

    private static void numberTest() {
        Object o1 = 120L;
        Object o2 = 120;
        System.out.println("numbers are equal: " + ObjectComparator.areEqual(o1, o2));
    }

    private static void mapTest() {
        Map map1 = new HashMap();
        map1.put("k1", "v1");
        map1.put("k2", 2);
        map1.put("k3", true);

        Map map2 = new LinkedHashMap();
        map2.put("k3", true);
        map2.put("k1", "v1");
        map2.put("k2", 2);

        System.out.println("maps are equal: " + ObjectComparator.areEqual(map1, map2));
    }

    private static void listTest() {
        List list1 = new ArrayList();
        list1.add(true);
        list1.add(25_000_000);
        list1.add(25.000F);

        List list2 = new LinkedList();
        list2.add(new BigInteger("25000000"));
        list2.add(true);
        list2.add(25D);

        System.out.println("maps are equal: " + ObjectComparator.areEqual(list1, list2));
    }
}
