/* You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

1 <= nums.length <= 200
1 <= nums[i] <= nums.length */


class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, new LinkedList<>());
            map.get(num).offer(num);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!map.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            Iterator<Map.Entry<Integer, Queue<Integer>>> it = map.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Integer, Queue<Integer>> entry = it.next();
                row.add(entry.getValue().poll());

                if (entry.getValue().isEmpty()) {
                    it.remove();
                }
            }

            result.add(row);
        }

        return result;
    }
}
