public class Demo {
    public static void main(String[] args) {
        Object o1 = 120L;
        Object o2 = 120;
        System.out.println("objects are equal: " + ObjectComparator.areEqual(o1, o2));
    }
}
