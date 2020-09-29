import java.awt.Toolkit;
import java.util.Arrays;

/* Dynamic Programming Java implementation of LCS problem */
public class DynamicLongestCommonSubsequence {

	StringBuilder lcsSB = new StringBuilder();
	int length = 0;

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	void lcs(final char[] X, final char[] Y, final int m, final int n )
	{
		final int[][] LCSLength = new int[m+1][n+1];

		/* Following steps build L[m+1][n+1] in bottom up fashion. Note
			that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		for (int i=0; i<=m; i++)
		{
		for (int j=0; j<=n; j++)
		{
			if (0 == i || 0 == j)
				LCSLength[i][j] = 0;
			else if (X[i-1] == Y[j-1])
				LCSLength[i][j] = LCSLength[i-1][j-1] + 1;
			else
				LCSLength[i][j] = max(LCSLength[i-1][j], LCSLength[i][j-1]);
		}
		}


		// Following code is used to print LCS
		int index = LCSLength[m][n];
		final int temp = index;

		// Create a character array to store the lcs string
		final char[] lcs = new char[index+1];
		lcs[index] = ' '; // Set the terminating character

		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		int i = m, j = n;
		while (i > 0 && j > 0)
		{
			// If current character in X[] and Y[] are same, then
			// current character is part of LCS
			if (X[i-1] == Y[j-1])
			{
				// Put current character in result
				lcs[index-1] = X[i-1];

				// reduce values of i, j and index
				i--;
				j--;
				index--;
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (LCSLength[i-1][j] > LCSLength[i][j-1])
				i--;
			else
				j--;
		}
		final StringBuilder sb1 = new StringBuilder();
		final StringBuilder sb2 = new StringBuilder();

		for (final char c: X) {
			sb1.append(c);
		}

		for (final char c: Y) {
			sb2.append(c);
		}


		// Print the lcs
		System.out.println("LCS of "+ sb1.toString() +" and "+ sb2.toString() +" is ");
		for(int k=0;k<=temp;k++){
			lcsSB.append(lcs[k]);
			System.out.print(lcs[k]);
		}

		length = LCSLength[m][n];
	}

	/* Utility function to get max of 2 integers */
	private int max(final int a, final int b)
	{
		return Math.max(a, b);
	}

//	public static void main(String[] args)
//	{
//		LCSD lcs = new LCSD();
//		String data = "AGGTAB";
//		String sequence = "GXTXAYB";
//
//		char[] X=data.toCharArray();
//		char[] Y=sequence.toCharArray();
//		int m = X.length;
//		int n = Y.length;
//
//		System.out.println("Length of LCS is" + " " +
//									lcs.lcs( X, Y, m, n ) );
//	}
}

