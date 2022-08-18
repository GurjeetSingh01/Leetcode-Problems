class Solution {
public int minSetSize(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> countValues = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        for (int value : countMap.values()) countValues.offer(value);

        int size = arr.length; int result = 0;
        while (size > arr.length / 2) {
            size -= countValues.poll();
            result++;
        }

        return result;
    }
}