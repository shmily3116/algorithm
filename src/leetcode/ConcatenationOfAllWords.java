package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ConcatenationOfAllWords {

    public static void main(String[] args) {
        new ConcatenationOfAllWords().findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        search(s, new ArrayList<>(), new ArrayList<>(Arrays.asList(words)));
        System.out.println(result);
        return resultIndics;
    }

    private List<String> result = new ArrayList<>();
    private List<Integer> resultIndics = new ArrayList<>();
    public void search(String s, List<String> concat, List<String> words){
        Map<Character, List<String>> cGroup = words.stream().collect(Collectors.groupingBy(c -> c.charAt(0)));
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (cGroup.containsKey(c)){
                for (String cs : cGroup.get(c)){
                    if ((s.length() >= i+cs.length()) && cs.equals(s.substring(i, i + cs.length()))){
                        List<String> newConcat = new ArrayList<>(concat);
                        newConcat.add(cs);
                        List<String> newWords = new ArrayList<>(words);
                        newWords.remove(cs);
                        if (newWords.size() == 0){
                            String newCon = String.join("", newConcat);
                            result.add(newCon);
                            resultIndics.add(i + cs.length() - newCon.length());
                        }
                        search(s.substring(i + cs.length()), newConcat, newWords);
                    }
                }
            }
        }
    }
}
