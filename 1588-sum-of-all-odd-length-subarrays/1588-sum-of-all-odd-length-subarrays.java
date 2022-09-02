class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
	int total = 0;

	for (int windowSize = 1; windowSize <= arr.length; windowSize += 2) {
		// sum up all the elements in the first window, W1
		int windowSum = 0;
		for (int i = 0; i < windowSize; i++)
			windowSum += arr[i];
		total += windowSum;

		// slide W1 one element at a time.
		// remove (subtract) the first element from the W1 and insert (add) the last element of the slided W1 into the previous sum.
		for (int i = 1; i + windowSize <= arr.length; i++) {
			windowSum = windowSum - arr[i - 1] + arr[i + windowSize - 1];
			total += windowSum;
		}
	}
	return total;
}
}