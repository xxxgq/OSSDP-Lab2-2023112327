import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class L2023112327_6_Test {
    
    static class Solution6 {
        Set<String>[] s = new Set[105];

        public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
            for (int i = 0; i < 105; ++i) {
                s[i] = new HashSet<String>();
            }
            
            int n = favoriteCompanies.size();
            List<Integer> ans = new ArrayList<Integer>();

            for (int i = 0; i < n; ++i) {
                for (String com : favoriteCompanies.get(i)) {
                    s[i].add(com);
                }
            }

            for (int i = 0; i < n; ++i) {
                boolean isSubset = false;
                for (int j = 0; j < n; ++j) {
                    if (i == j) continue;
                    if (check(i, j)) {
                        isSubset = true;
                        break;
                    }
                }
                if (!isSubset) {
                    ans.add(i);
                }
            }
            return ans;
        }

        public boolean check(int x, int y) {
            for (String com : s[x]) {
                if (!s[y].contains(com)) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static void testExample1() {
        System.out.println("Test 1: Basic example with subset relationships");
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("leetcode", "google", "facebook"),
            Arrays.asList("google", "microsoft"),
            Arrays.asList("google", "facebook"),
            Arrays.asList("google"),
            Arrays.asList("amazon")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(0, 1, 4);
        
        System.out.println("Input: " + favoriteCompanies);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);
        System.out.println("Test 1 Result: " + (result.equals(expected) ? "PASS" : "FAIL"));
    }
    
    public static void testNoSubsets() {
        System.out.println("Test 2: No subset relationships");
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("leetcode"),
            Arrays.asList("google"),
            Arrays.asList("facebook"),
            Arrays.asList("amazon")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        
        System.out.println("Input: " + favoriteCompanies);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);
        System.out.println("Test 2 Result: " + (result.equals(expected) ? "PASS" : "FAIL"));
    }
    
    public static void testEdgeCases() {
        System.out.println("Test 3: Edge cases with single elements");
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("company1"),
            Arrays.asList("company1", "company2"),
            Arrays.asList("company3")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(1, 2);
        
        System.out.println("Input: " + favoriteCompanies);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);
        System.out.println("Test 3 Result: " + (result.equals(expected) ? "PASS" : "FAIL"));
    }
    
    public static void main(String[] args) {
        System.out.println("SOLUTION6 UNIT TEST");
        System.out.println("Student ID: 2023112327");
        System.out.println("================================");
        
        testExample1();
        System.out.println();
        
        testNoSubsets();
        System.out.println();
        
        testEdgeCases();
        
        System.out.println("================================");
        System.out.println("TEST COMPLETED");
    }
}
