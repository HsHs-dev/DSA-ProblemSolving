package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
    Given an array of integers nums, return the length of the longest consecutive sequence
    of elements that can be formed.
    A consecutive sequence is a sequence of elements in which each element is exactly 1
    greater than the previous element.
    The elements do not have to be consecutive in the original array.
    You must write an algorithm that runs in O(n) time.

    Input: nums = [2,20,4,10,3,4,5]
    Output: 4
    Explanation: The longest consecutive sequence is [2, 3, 4, 5].

    Input: nums = [0,3,2,5,4,6,1,1]
    Output: 7
    */

    public static int longestConsecutive(int[] nums) {

        Set<Integer> elements = new HashSet<>();
        for (int num: nums) {
            elements.add(num);
        }

        int longest = 0;
        for (int num: nums) {

            // not a start of a sequence
            if (elements.contains(num - 1)) {
                continue;
            }

            int seq = 0;
            for (int next: nums) {
                if (elements.contains(num + seq)) {
                    seq++;
                }
            }

            if (seq > longest) {
                longest = seq;
            }
        }

        return longest;
    }


    public static void main(String[] args) {
        int[] nums1 = {2,20,4,10,3,4,5};
        System.out.println(longestConsecutive(nums1)); // 4

        int[] nums2 = {0,3,2,5,4,6,1,1};
        System.out.println(longestConsecutive(nums2)); // 7
    }

}
