package set.leetcode;

import java.util.Set;
import java.util.TreeSet;
// 804. 唯一摩尔斯密码词
public class Demo1 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> setPassword = new TreeSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                builder.append(arr[words[i].charAt(j) - 'a']);
            }
            setPassword.add(builder.toString());
        }
        return setPassword.size();
    }
}
