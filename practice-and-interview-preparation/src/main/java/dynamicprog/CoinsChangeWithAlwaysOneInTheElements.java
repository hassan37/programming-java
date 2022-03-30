package dynamicprog;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinsChangeWithAlwaysOneInTheElements {

	int coinsChangeRecursive(int[] coins, int target) {
		int minCoinsUsed = Integer.MAX_VALUE;
		for (int i = coins.length-1; i > -1; i--) {
			int coin = coins[i];

			if (coin == target) return 1;
			if (coin > target)  continue;

			if (1 == coin) minCoinsUsed =           Math.min(minCoinsUsed, target);
			if (0 == target%coin) minCoinsUsed =    Math.min(minCoinsUsed, target/coin);
			else {
				int totalCoins = totalCoins(coins, target, i);
				System.out.println("i: " + i + " | coin: " + coin + " | totalCoins: " + totalCoins);
				minCoinsUsed = Math.min(minCoinsUsed, totalCoins);
			}
		}

		return Integer.MAX_VALUE == minCoinsUsed ? 0 : minCoinsUsed;
	}

	int totalCoins(int[] coins, int target, int i) {
		if (i < 0) return 0;

		int totalCoins = 0;
		int coin = coins[i];
		if (coin > target) {
			int nextCoinIndex = --i;
			totalCoins = totalCoins(coins, target, nextCoinIndex);
		} else {
			target = target - coin;
			totalCoins = totalCoins(coins, target, i) + 1;
		}

		return totalCoins;
	}

	@Test public void returnsOneWhenCoinsAndTargetAreSame()             { assertEquals(1, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,5}, 5)); }
	@Test public void returnsTargetWhenCoinIsOne()                      { assertEquals(5, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{25,1}, 5)); }
	@Test public void returnsZeroWhenCoinIsLargerThanTarget()           { assertEquals(0, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{7,15}, 5)); }

	@Test public void returnsTwoWhenCoinIsTwoAndTargetIsFour()          { assertEquals(2, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,2,3}, 4)); }
	@Test public void returnsTwoWhenCoinIsHalfOfTargetEven()                { assertEquals(2, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,2,3,4,5,7,8,15}, 30)); }
	@Test public void returnsThreeWhenCoinIsHalfOfTargetOdd()                { assertEquals(2, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,2,3,4,5,7,8}, 15)); }

	@Test public void returnsFourForGivenCoins()                { assertEquals(4, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,5,12,19}, 16)); }

	@Test public void returnsThreeForGivenCoins()                { assertEquals(3, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,3,5,7}, 15)); }
	@Test public void returnsThreeForGivenCoinsByWaqas()                { assertEquals(2, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1, 2, 3, 8, 11} , 12)); }
	@Test public void returnsThreeForGivenCoinsByLC3()                { assertEquals(2, new CoinsChangeWithAlwaysOneInTheElements().coinsChangeRecursive(new int[]{1,3,4,5} , 7)); }


}
