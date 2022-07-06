class Solution {
	public int lenLongestFibSubseq(int[] arr) {

		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<arr.length; i++){
			hs.add(arr[i]);
		}

		int count = 0;
		int max = 0;

		for(int i=0; i<arr.length; i++){

			for(int j=i+1; j<arr.length; j++){
				int a = arr[i];
				int b = arr[j];
				int c = arr[i] + arr[j];

				if(hs.contains(c))
					count = 2;

				while(hs.contains(c)){
					count++;
					a = b;
					b = c;
					c = a+b;
				}

				max = Math.max(count , max);

			}
		}

		return max;
	}
}