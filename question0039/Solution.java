package question0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法。
 *
 * 执行用时：35ms，击败11.42%。消耗内存：40.1MB，击败77.62%。
 */
public class Solution {
    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>(), 0);
        return listList;
    }

    /**
     * 递归函数的定义如下：目前已找到的组合存放在list里，其和为sum，在candidates里寻找下一个元素，使得list中的和为target
     */
    private void combinationSum(int[] candidates, int target, List<Integer> list, int sum) {
        if (sum >= target) {    //递归出口
            if (sum == target) {
                listList.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (list.size() == 0 || candidates[i] >= list.get(list.size() - 1)) {   //list中值是升序排列，防重复
                list.add(candidates[i]);
                combinationSum(candidates, target, list, sum + candidates[i]);
                list.remove(list.size() - 1);   //注意变量的回溯
            }
        }
    }
}