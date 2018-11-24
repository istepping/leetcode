package exercise.base1;

import java.util.HashMap;

/**
 * @author sunLei on 2018/11/24 21:02
 * @version 1.0
 * @apiNote 8 两数之和
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer element=target-nums[i];
            if(map.containsKey(element)){
                return new int[] {map.get(element),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
