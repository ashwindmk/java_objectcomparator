import java.math.BigDecimal;
import java.util.*;

public class ObjectComparator {
    public static boolean areEqual(Object obj1, Object obj2) {
        if (Objects.equals(obj1, obj2)) {
            return true;
        }

        else if (obj1 == null || obj2 == null) {
            return false;
        }

        else if (obj1 instanceof Map || obj2 instanceof Map) {
            if (obj1 instanceof Map && obj2 instanceof Map) {
                Map map1 = (Map) obj1;
                Map map2 = (Map) obj2;
                int size1 = map1.size();
                int size2 = map2.size();
                if (size1 == size2) {
                    Set set1 = map1.keySet();
                    Iterator keys1 = set1.iterator();
                    while (keys1.hasNext()) {
                        Object key = keys1.next();
                        if (!map2.containsKey(key)) {
                            return false;
                        }

                        if (!areEqual(map1.get(key), map2.get(key))) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        else if (obj1 instanceof List || obj2 instanceof List) {
            if (obj1 instanceof List && obj2 instanceof List) {
                List list1 = (List) obj1;
                List list2 = (List) obj2;

                int size1 = list1.size();
                int size2 = list2.size();
                if (size1 == size2) {
                    for (Object i1 : list1) {
                        boolean contains = false;
                        for (Object i2 : list2) {
                            if (areEqual(i1, i2)) {
                                contains = true;
                                break;
                            }
                        }

                        if (!contains) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        else if (obj1 instanceof Number && obj2 instanceof Number) {
            Number n1 = (Number) obj1;
            Number n2 = (Number) obj2;

            String s1 = n1.toString();
            String s2 = n2.toString();

            // Remove trailing zeros after decimal
            if (s1.contains(".")) {
                s1 = s1.replaceAll("0*$", "");
                if (s1.endsWith(".")) {
                    s1 = s1 + "0";
                }
            }

            if (s2.contains(".")) {
                s2 = s2.replaceAll("0*$", "");
                if (s2.endsWith(".")) {
                    s2 = s2 + "0";
                }
            }

            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
            return b1.equals(b2);
        }

        else if ((obj1.getClass() != obj2.getClass()) && !(obj1 instanceof CharSequence && obj2 instanceof CharSequence)) {
            return false;
        }

        String strObj1 = String.valueOf(obj1);
        String strObj2 = String.valueOf(obj2);
        return strObj1.equals(strObj2);
    }
}
