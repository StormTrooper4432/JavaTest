import java.util.Objects;

public class Q6_Tricky {

    // ── PREDICT: What does main() print for lines 1-6? ──

    public static void main(String[] args) {
        // Q6a: Integer cache
        Integer a = 127;
        Integer b = 127;
        System.out.println("1: " + (a == b)); //1: false

        Integer c = 128;
        Integer d = 128;
        System.out.println("2: " + (c == d)); //2: false

        // Q6b: String interning
        String s1 = "frc";
        String s2 = "frc";
        String s3 = new String("frc");
        System.out.println("3: " + (s1 == s2)); //3: false
        System.out.println("4: " + (s1 == s3)); //4: false
        System.out.println("5: " + s1.equals(s3)); //5: true

        // Q6c: null unboxing
        try {
            Integer e = null;
            int f = e;
            System.out.println("6: " + f); //6: NullPointerException
        } catch (Exception ex) {
            System.out.println("6: " + ex.getClass().getSimpleName());
        }

        // ── WRITE ──
        // 1) Implement safeEquals that:
        //    - returns true if both are null
        //    - returns false if exactly one is null
        //    - uses .equals() otherwise
        //    Do NOT use Objects.equals (pretend it doesn't exist).

        assert safeEquals(null, null) == true;
        assert safeEquals("a", null) == false;
        assert safeEquals(null, "a") == false;
        assert safeEquals("frc", new String("frc")) == true;
        assert safeEquals("frc", "nope") == false;
        System.out.println("safeEquals ok");

        // 2) Implement safeUnbox that takes an Integer and a default int.
        //    If the Integer is null, return the default. Otherwise unbox it.

        assert safeUnbox(null, 42) == 42;
        assert safeUnbox(Integer.valueOf(7), 42) == 7;
        assert safeUnbox(null, -1) == -1;
        System.out.println("safeUnbox ok");

        // 3) Without running it: what does this print? Write your answer
        //    as a comment, then uncomment to verify.
        //
        // Integer x = 0;
        // for (int i = 0; i < 5; i++) {
        //     x = x + 1;    // how many Integer objects does this create total? 0
        // }
        // System.out.println(x); //4
        // System.out.println(x == Integer.valueOf(5)); //false
        // System.out.println(x == new Integer(5)); //false
    }

    // TODO
    static boolean safeEquals(Object a, Object b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.equals(b))
            return true;
        return false;
    }

    // TODO
    static int safeUnbox(Integer val, int defaultVal) {
        if (val == null) {
            return defaultVal;
        }
        return val;
    }
}
