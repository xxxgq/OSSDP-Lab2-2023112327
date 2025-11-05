import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution6 {
    Set<String>[] s = new Set[105];

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // BUG修复1: 数组初始化范围错误 - 原代码从i=1开始，应该从0开始
        for (int i = 0; i < 105; ++i) {
            s[i] = new HashSet<String>();
        }
        
        // BUG修复2: 变量n计算错误 - 原代码减去了1，导致漏掉最后一个元素
        int n = favoriteCompanies.size();
        List<Integer> ans = new ArrayList<Integer>();

        // 预处理：将每个用户的收藏公司列表转换为Set
        for (int i = 0; i < n; ++i) {
            for (String com : favoriteCompanies.get(i)) {
                s[i].add(com);
            }
        }

        // BUG修复3: 逻辑结构错误 - 原代码将内层循环放在了错误的位置
        for (int i = 0; i < n; ++i) {
            boolean isSubset = false;
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                // 检查i是否是j的子集
                if (check(i, j)) {
                    isSubset = true;
                    break;
                }
            }
            // BUG修复4: 逻辑判断错误 - 应该是找到不是任何人的子集时才添加
            if (!isSubset) {
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     * BUG修复5: 方法参数优化 - 直接使用预处理的Set数组
     */
    public boolean check(int x, int y) {
        for (String com : s[x]) {
            if (!s[y].contains(com)) {
                return false;
            }
        }
        return true;
    }

    //     // 添加 main 方法来运行代码
    // public static void main(String[] args) {
    //     Solution6 solution = new Solution6();
        
    //     // 测试方法
    //     List<List<String>> favoriteCompanies = new ArrayList<>();
    //     List<String> user1 = List.of("google", "facebook");
    //     List<String> user2 = List.of("google");
    //     List<String> user3 = List.of("facebook", "amazon");
    //     favoriteCompanies.add(user1);
    //     favoriteCompanies.add(user2);
    //     favoriteCompanies.add(user3);

    //     List<Integer> result = solution.peopleIndexes(favoriteCompanies);
    //     System.out.println(result); // 输出结果
    // }
}