package yandex_leetcode.src.main.java.temp;

public class ReverseWordInAString3 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's talk about them"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder results = new StringBuilder();
        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder(word).reverse();
            results.append(reverseWord).append(" ");
        }
        results.deleteCharAt(results.length() - 1);
        return results.toString();
    }



}
