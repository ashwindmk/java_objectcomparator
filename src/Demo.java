import java.math.BigInteger;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        nullTest();

        stringTest();

        charsequenceTest();

        numberTest();

        mapTest();

        listTest();

        nestedMapTest();

        nestedListTest();

        listInMapTest();
    }

    private static void nullTest() {
        Object o1 = null;
        Object o2 = null;
        System.out.println("nulls are equal: " + ObjectComparator.areEqual(o1, o2));
    }

    private static void stringTest() {
        Object o1 = "test1";
        Object o2 = new String("test1");
        System.out.println("strings are equal: " + ObjectComparator.areEqual(o1, o2));
    }

    private static void charsequenceTest() {
        CharSequence c1 = new String("test");
        CharSequence c2 = new StringBuilder("test");
        System.out.println("charsequence are equal: " + ObjectComparator.areEqual(c1, c2));
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
        list1.add(25.000F);
        list1.add(25_000_000);

        List list2 = new LinkedList();
        list2.add(new BigInteger("25000000"));
        list2.add(true);
        list2.add(25D);

        System.out.println("lists are equal: " + ObjectComparator.areEqual(list1, list2));
    }

    private static void nestedMapTest() {
        HashMap<String, Object> nestedMap1 = new HashMap<>();
        nestedMap1.put("nk1", "s1");
        nestedMap1.put("nk2", 10);
        nestedMap1.put("nk3", null);

        Map nestedMap2 = new LinkedHashMap();
        nestedMap2.put("nk1", "s1");
        nestedMap2.put("nk2", 10L);
        nestedMap2.put("nk3", null);

        Map map1 = new LinkedHashMap();
        map1.put("k1", nestedMap1);
        map1.put("k2", false);

        Map map2 = new LinkedHashMap();
        map2.put("k2", new Boolean(false));
        map2.put("k1", nestedMap2);

        System.out.println("nested-maps are equal: " + ObjectComparator.areEqual(map1, map2));
    }

    private static void nestedListTest() {
        LinkedList nestedList1 = new LinkedList();
        nestedList1.add(1);
        nestedList1.add("test1");

        List nestedList2 = new ArrayList();
        nestedList2.add("test1");
        nestedList2.add(new Integer(1));

        List<Object> list1 = new ArrayList<>();
        list1.add(nestedList1);
        list1.add("null");
        list1.add(null);

        List list2 = new ArrayList();
        list2.add("null");
        list2.add(nestedList2);
        list2.add(null);

        System.out.println("nested-lists are equal: " + ObjectComparator.areEqual(list1, list2));
    }

    private static void listInMapTest() {
        List<Object> list1 = new ArrayList<>();
        list1.add(1);
        list1.add("v1");
        list1.add(null);

        List<Object> list2 = new LinkedList<>();
        list2.add(1);
        list2.add("v1");
        list2.add(null);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("k1", list1);
        map1.put("k2", "v1");
        map1.put("k3", 3F);

        Map<String, Object> map2 = new Hashtable<>();
        map2.put("k1", list2);
        map2.put("k2", "v1");
        map2.put("k3", 3.0);

        System.out.println("lists in maps are equal: " + ObjectComparator.areEqual(map1, map2));
    }
}
