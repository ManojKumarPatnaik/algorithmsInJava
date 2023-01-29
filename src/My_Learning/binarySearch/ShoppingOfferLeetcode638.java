package My_Learning.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingOfferLeetcode638 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		return shoppingOffers(price, special, needs, new HashMap<>());
	}

	/**
	 * Recursively check for minimum price
	 * 
	 * @param price
	 * @param special
	 * @param needs
	 * @param cache
	 * @return
	 */
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
			HashMap<List<Integer>, Integer> cache) {
		int cachedPrice = cache.getOrDefault(needs, -1); // if cache has this result then return the already calculated
															// price for this needs
		if (cachedPrice != -1)
			return cachedPrice;
		int total = getIndividualPrice(price, needs); // calculate price if every item is bought individually
		for (int i = 0; i < special.size(); i++) {
			if (isOfferValid(special.get(i), needs)) { // check if offer is valid

				List<Integer> cloned = new ArrayList<>(); // remaining needs after taking this special offer
				for (int k = 0; k < needs.size(); k++) {
					// update the
					cloned.add(needs.get(k) - special.get(i).get(k)); // update remaining needs
				}
				// calculate price for rest of needs recursively
				int priceWithThisOffer = shoppingOffers(price, special, cloned, cache)
						+ special.get(i).get(needs.size());
				total = Math.min(priceWithThisOffer, total); // total would be minimum of total or price with this offer
			}
		}

		cache.put(needs, total);
		return total;
	}

	public int getIndividualPrice(List<Integer> price, List<Integer> needs) {
		int cost = 0;
		for (int i = 0; i < needs.size(); i++) {
			cost += (needs.get(i) * price.get(i));
		}
		return cost;
	}

	// Offer is only valid if each item's count is <= needs
	boolean isOfferValid(List<Integer> offer, List<Integer> needs) {
		for (int i = 0; i < needs.size(); i++) {
			if (needs.get(i) < offer.get(i))
				return false;
		}
		return true;
	}

}
