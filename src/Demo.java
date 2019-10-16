import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        nullTest();

        booleanTest();

        stringTest();

        charsequenceTest();

        numberTest();

        dateTest();

        arrayTest();

        mapTest();

        listTest();

        nestedMapTest();

        nestedListTest();

        listInMapTest();
    }

    private static void nullTest() {
        Object o1 = null;
        Object o2 = null;
        System.out.println("Nulls are equal: " + ObjectComparator.areEqual(o1, o2));
        System.out.println();
    }

    private static void booleanTest() {
        Object b1 = true;
        boolean b2 = Boolean.TRUE;
        System.out.println("Booleans are equal: " + ObjectComparator.areEqual(b1, b2));
        System.out.println();
    }

    private static void stringTest() {
        Object o1 = "test1";
        Object o2 = new String("test1");
        System.out.println("Strings are equal: " + ObjectComparator.areEqual(o1, o2));
        System.out.println();
    }

    private static void charsequenceTest() {
        CharSequence c1 = new String("test");
        CharSequence c2 = new StringBuilder("test");
        System.out.println("Charsequences are equal: " + ObjectComparator.areEqual(c1, c2));
        System.out.println();
    }

    private static void numberTest() {
        System.out.println("Numbers:");

        double d1 = 12.00000;
        BigDecimal bd1 = new BigDecimal("12.00");
        System.out.println("  (double, double) are equal: " + ObjectComparator.areEqual(d1, bd1));
        System.out.println("  (double, bigdecimal) are equal: " + ObjectComparator.areEqual(d1, bd1));

        Object o1 = 120L;
        Object o2 = 120;
        System.out.println("  (long, int) are equal: " + ObjectComparator.areEqual(o1, o2));

        Number n1 = 12.125;
        Number n2 = 12.125f;
        System.out.println("  (double, float) are equal: " + ObjectComparator.areEqual(n1, n2));

        System.out.println();
    }

    private static void dateTest() {
        System.out.println("Dates:");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        format1.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date d1 = null;
        Date d2 = null;
        Date d3 = null;
        Date d4 = null;
        try {
            d1 = format1.parse("2019-10-15T12:30:45.125Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            d2 = format1.parse("2019-10-15T12:30:45.125Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            d3 = format1.parse("2019-10-15T00:00:00.000Z");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            format2.setTimeZone(TimeZone.getTimeZone("UTC"));
            d4 = format2.parse("2019-10-15");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("  dates d1 & d2 are equal: " + ObjectComparator.areEqual(d1, d2));

        System.out.println("  dates d3 & d4 are equal: " + ObjectComparator.areEqual(d3, d4));

        System.out.println();
    }

    private static void arrayTest() {
        System.out.println("Arrays:");

        int[] i1 = {1, 2, 3, 10000};
        int[] i2 = {1, 2, 3, 10000};
        System.out.println("  int[] are equal: " + ObjectComparator.areEqual(i1, i2));

        double[] d1 = {1d, 2d, 100d, 200d, 1.25d, 1.50000000000};
        double[] d2 = {1d, 2d, 100d, 200.00, 1.25d, 1.5d};
        System.out.println("  double[] are equal: " + ObjectComparator.areEqual(d1, d2));

        char[] c1 = {'a', '-', '$'};
        char[] c2 = {'a', '-', '$'};
        System.out.println("  char[] are equal: " + ObjectComparator.areEqual(c1, c2));

        Object[] o1 = {null, "a", 1, 12.25, true};
        Object[] o2 = {null, "a", 1, 12.25, true};
        System.out.println("  Object[] are equal: " + ObjectComparator.areEqual(o1, o2));

        System.out.println();
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

        System.out.println("Maps are equal: " + ObjectComparator.areEqual(map1, map2));

        System.out.println();
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

        System.out.println("Lists are equal: " + ObjectComparator.areEqual(list1, list2));

        System.out.println();
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

        System.out.println("Nested-maps are equal: " + ObjectComparator.areEqual(map1, map2));

        System.out.println();
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

        System.out.println("Nested-lists are equal: " + ObjectComparator.areEqual(list1, list2));

        System.out.println();
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

        System.out.println("Lists in maps are equal: " + ObjectComparator.areEqual(map1, map2));
    }
}
