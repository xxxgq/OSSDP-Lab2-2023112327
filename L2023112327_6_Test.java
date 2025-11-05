import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class L2023112327_6_Test {
    
    static class Solution6 {
        // 存储每个用户的收藏公司
        Set<String>[] s = new Set[105];

        // 计算满足条件的用户索引
        public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
            // 初始化 Set 数组
            for (int i = 0; i < 105; ++i) {
                s[i] = new HashSet<String>();
            }
            
            int n = favoriteCompanies.size();
            List<Integer> ans = new ArrayList<Integer>();

            // 将每个用户的收藏公司列表转换为 Set
            for (int i = 0; i < n; ++i) {
                for (String com : favoriteCompanies.get(i)) {
                    s[i].add(com);
                }
            }

            // 遍历每个用户，检查是否为其他用户的子集
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

        // 判断用户 x 是否是用户 y 的子集
        public boolean check(int x, int y) {
            for (String com : s[x]) {
                if (!s[y].contains(com)) {
                    return false;  
                }
            }
            return true;
        }
    }
    
    // 测试用例 1：基本示例，测试子集关系
    public static void testExample1() {
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
        
        System.out.println("Test 1 Result: " + (result.equals(expected) ? "PASS" : "FAIL"));
    }
    
    // 测试用例 2：没有子集关系的情况
    public static void testNoSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("leetcode"),
            Arrays.asList("google"),
            Arrays.asList("facebook"),
            Arrays.asList("amazon")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        
        System.out.println("Test 2 Result: " + (result.equals(expected) ? "PASS" : "FAIL"));
    }
    
    // 测试用例 3：边界情况
    public static void testEdgeCases() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("company1"),
            Arrays.asList("company1", "company2"),
            Arrays.asList("company3")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(1, 2);
        
        System.out.println("Test 3 Result: " + (result.equals(expected) ? "PASS" : "FAIL"));
    }
    
    // main 方法：执行所有测试
    public static void main(String[] args) {
        System.out.println("SOLUTION6 UNIT TEST");
        
        testExample1();
        testNoSubsets();
        testEdgeCases();
        
        System.out.println("TEST COMPLETED");
    }
}
