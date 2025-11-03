import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * 测试用例设计原则：基于等价类划分
 * - 有效等价类：包含子集关系的情况、不包含子集关系的情况
 * - 边界情况：所有列表都互不为子集、所有列表都是某个列表的子集
 * - 特殊值：单个元素的列表
 */
public class L2023112327_6_Test {
    
    /**
     * 测试目的：验证基本功能，包含子集关系的情况
     * 测试用例：示例1的情况
     */
    @Test
    public void testExample1() {
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
        
        assertEquals(expected, result);
    }
    
    /**
     * 测试目的：验证所有列表都互不为子集的情况
     * 测试用例：每个列表都有独特的公司
     */
    @Test
    public void testNoSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("leetcode"),
            Arrays.asList("google"),
            Arrays.asList("facebook"),
            Arrays.asList("amazon")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        
        assertEquals(expected, result);
    }
    
    /**
     * 测试目的：验证空列表和单个元素列表的处理
     * 测试用例：包含空列表的情况
     */
    @Test
    public void testEdgeCases() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
            Arrays.asList("company1"),
            Arrays.asList("company1", "company2"),
            Arrays.asList("company3")
        );
        
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        List<Integer> expected = Arrays.asList(1, 2);
        
        assertEquals(expected, result);
    }
}