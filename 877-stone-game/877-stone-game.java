class Solution {
  public boolean stoneGame(int[] piles) {
		int n = piles.length;

		// dp(i,j) represents the relative score that i can achieve
		// if i got to play the first hand, where the piles remaining are [i, j]
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = piles[i]; // diagonal elements, interval length = 0
		}

		// length of interval from [1, n-1]
		for (int interval = 1; interval < n; interval++) {

			for (int l = 0; l < n - interval; l++) { // start of interval

				int r = l + interval; // end of interval

				// the gain of picking left stone,
				// minus the gain of my opponent playing first hand at interval [l+1, r]
				int pickLeft = piles[l] - dp[l + 1][r];

				// the gain of picking right stone,
				// minus the gain of my opponent picking first hand at interval [l, r-1]
				int pickRight = piles[r] - dp[l][r - 1];

				dp[l][r] = dp[l][r] = Math.max(pickLeft, pickRight);
			}
		}
		return dp[0][n - 1] > 0;
	}
}