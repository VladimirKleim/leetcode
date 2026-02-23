package yandex_leetcode.src.main.java.temp;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("1", "1"));

        int res = 123;
//        reverse(res);
        System.out.println(res);
    }
    public static String addStrings(String num1, String num2) {
         StringBuilder stringBuilder = new StringBuilder();
         long n1 = Long.parseLong(num1);
         long n2 = Integer.parseInt(num2);
         stringBuilder.append(n1 + n2).append(" ");
         stringBuilder.deleteCharAt(stringBuilder.length() - 1);
         return stringBuilder.toString();
    }
//    public static int reverse(int x) {
//     List<Integer> list = new ArrayList<>();
//     int res = 0;
//     int temp = x;
//        for (int i = 0; i < x; i++) {
//
//
//        }
//    }
}
