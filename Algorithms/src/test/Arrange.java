package test;

public class Arrange {
    public static void main(String[] args) {
        String str[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        permutation(str, 0, str.length);
    }

    static void swap(String[] str, int start, int end) {
        String tmep = str[start];
        str[start] = str[end];
        str[end] = tmep;
    }

    static void permutation(String[] str, int start, int end) {

        if (start == end - 1) {
            for (int i = 0; i < end; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {

            for (int i = start; i < end; i++) {
                if (i == 0 && str[0].equals("0"))
                    continue;
                swap(str, start, i);
                permutation(str, start + 1, end);
                swap(str, start, i);
            }
        }
    }
}
