package Labs.Lab8;

public class Demo {
    public static void main(String[] args) {
        //
    }

    public static void dynamic(String[] args) {
        var a = new DynamicQ(5);
        var b = new DynamicQ(7);

        for (int i = 0; i <= 10; i++) {
            a.put((char) ('A' + i));
        }

        for (int i = 0; i <= 10; i++) {
            System.out.printf("a[%d] = %c\n", i, a.get());
        }
    }

    public static void fixed(String[] args) {
        FixedCharQ bigQ = new FixedCharQ(100);
        FixedCharQ smallQ = new FixedCharQ(4);
        char ch;
        int i;
        System.out.println("Using bigQ to store the alphabet.");

        //put some numbers into bigQ
        for (i = 0; i < 26; i++) {
            bigQ.put((char) ('A' + i));
        }

        //retrieve and display elements from bigQ
        System.out.print("Contents of bigQ: ");
        for (i = 0; i < 26; i++) {
            ch = bigQ.get();
            if (ch != (char) 0) {
                System.out.print(ch);
            }
        }
        System.out.println("\n");
        System.out.println("Using smallQ to generate errors.");

        //Now, use smallQ to generate some errors
        for (i = 0; i < 5; i++) {
            System.out.print("Attempting to store " + (char) ('Z' - i));
            smallQ.put((char) ('Z' - i));
            System.out.println();
        }
        System.out.println();

        // more errors on smallQ
        System.out.print("Contents of smallQ: ");
        for (i = 0; i < 5; i++) {
            ch = smallQ.get();
            if(ch != (char) 0) {
                System.out.print(ch);
            }
        }
    }
}