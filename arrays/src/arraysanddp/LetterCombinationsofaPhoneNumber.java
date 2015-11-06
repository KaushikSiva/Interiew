package arraysanddp;

import java.util.LinkedList;
import java.util.List;
//Q23
public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
    	digits=digits.trim();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '1';
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.pop();
                for (int j = 0; j < letters[num].length(); j++)
                    list.add(tmp + letters[num].charAt(j));
            }
        }
        return list;
    }
    public static void main(String args[])
    {
    	System.out.println(letterCombinations("12").toString());
    }
}
