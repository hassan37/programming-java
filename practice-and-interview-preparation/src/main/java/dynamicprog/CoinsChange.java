package dynamicprog;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Bottom up do
 */
public class CoinsChange {

	int coinsChange(int[] coins, int target) {
		int[] amounts = new int[target + 1];
		int defVal = target+2;
		Arrays.fill(amounts, defVal);
		amounts[0] = 0;

		for (int amount = 1; amount <= target; amount++)
			for (int coin : coins)
				if (amount - coin >= 0)
					amounts[amount] = Integer.min(amounts[amount], 1 + amounts[amount-coin]);

		return amounts[target] == defVal ? -1 : amounts[target];
	}

	@Test public void returnsThreeForGivenCoinsByLC2()                { assertEquals(-1, new CoinsChange().coinsChange(new int[]{2} , 3)); }

	@Test public void returnsOneWhenCoinsAndTargetAreSame()             { assertEquals(1, new CoinsChange().coinsChange(new int[]{1,5}, 5)); }
	@Test public void returnsTargetWhenCoinIsOne()                      { assertEquals(5, new CoinsChange().coinsChange(new int[]{25,1}, 5)); }
	@Test public void returnsZeroWhenCoinIsLargerThanTarget()           { assertEquals(-1, new CoinsChange().coinsChange(new int[]{7,15}, 5)); }

	@Test public void returnsTwoWhenCoinIsTwoAndTargetIsFour()          { assertEquals(2, new CoinsChange().coinsChange(new int[]{1,2,3}, 4)); }
	@Test public void returnsTwoWhenCoinIsHalfOfTargetEven()                { assertEquals(2, new CoinsChange().coinsChange(new int[]{1,2,3,4,5,7,8,15}, 30)); }
	@Test public void returnsThreeWhenCoinIsHalfOfTargetOdd()                { assertEquals(2, new CoinsChange().coinsChange(new int[]{1,2,3,4,5,7,8}, 15)); }

	@Test public void returnsFourForGivenCoins()                { assertEquals(4, new CoinsChange().coinsChange(new int[]{1,5,12,19}, 16)); }

	@Test public void returnsThreeForGivenCoins()                { assertEquals(3, new CoinsChange().coinsChange(new int[]{1,3,5,7}, 15)); }
	@Test public void returnsThreeForGivenCoinsByWaqas()                { assertEquals(2, new CoinsChange().coinsChange(new int[]{1, 2, 3, 8, 11} , 12)); }
	@Test public void returnsThreeForGivenCoinsByLC3()                { assertEquals(2, new CoinsChange().coinsChange(new int[]{1,3,4,5} , 7)); }

}
