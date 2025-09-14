/* Zainab Syed
 * Programming Assignment 4
 */
public class HopStepGame {

	// recursive DP
	public static int minCost(int[] cost, int nS) 
	{
		// base case, last 2 squares reached
		if(nS == 1 || nS == 0) 
			return cost[nS];
		
		// add current position and lowest next spot
		int result = cost[nS] + Math.min(minCost(cost, nS-1), minCost(cost, nS-2));

		return result;
	}
	
	// Memoization
	public static int minCostMemoization(int[] cost, int nS, int[] pR) 
	{		
		int result = 0;
		
		// result already exists
		if(pR[nS] != 0) 
			return pR[nS];
		
		// base cases
		if(nS == 0)
			return cost[0];
		if(nS == 1)
			return cost[1];
		
		// add current position and next lowest cost
		else
			result = cost[nS] + Math.min(minCostMemoization(cost, nS-2, pR), 
					minCostMemoization(cost, nS-1, pR));
		
		pR[nS] = result;
		
		return result;
	}
	
	public static int minCostTabulation(int[] cost) 
	{		
		int length = cost.length;
		int results[] = new int[length+1];
		
		// initial costs
		results[0] = cost[0];
		results[1] = cost[1];
		
		// add current cost and cheaper result of past 2 results
		for(int i = 2; i < length; i++) 
		{
			results[i] = cost[i] + Math.min(results[i-1], results[i-2]);
		}
		return Math.min(results[length-1], results[length-2]);
	}

}
