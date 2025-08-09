package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

    /*
    Given an integer array nums and an integer k,
    return the k most frequent elements within the array.
    The test cases are generated such that the answer is always unique.
    You may return the output in any order.

    Input: nums = [1,2,2,3,3,3], k = 2
    Output: [2,3]

    Input: nums = [7,7], k = 1
    Output: [7]
    */

    public static int[] topKFrequentElement(int[] nums, int k) {

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num: nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> count = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            count.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry: freqs.entrySet()) {
            count.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = count.size() - 1; i >= 0; i--) {
            for (int element: count.get(i)) {
                if (index == k) {
                    return result;
                }
                result[index] = element;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        System.out.println(Arrays.toString(topKFrequentElement(nums, 2)));
        // Output: [2, 3]
    }


}
