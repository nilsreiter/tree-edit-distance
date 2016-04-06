package treedist;

public class ForestPair {
	private final Forest forest1, forest2;

	/**
	 * Make a new forest pair.
	 *
	 * Null is acceptable.
	 *
	 */
	public ForestPair(Forest forest1, Forest forest2) {
		this.forest1 = forest1;
		this.forest2 = forest2;
	}

	@Override
	public int hashCode() {
		final int h1 = forest1 == null ? 0 : forest1.hashCode();
		final int h2 = forest2 == null ? 0 : forest2.hashCode();
		return Integer.rotateLeft(h1, 8) ^ h2;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object instanceof ForestPair) {
			return this.equals((ForestPair) object);
		} else {
			return false;
		}
	}

	public boolean equals(ForestPair pair) {
		return optionalForestEquqlas(forest1, pair.forest1) && optionalForestEquqlas(forest2, pair.forest2);
	}

	private static boolean optionalForestEquqlas(Forest f1, Forest f2) {
		if ((f1 == null) && (f2 == null)) {
			return true;
		} else if ((f1 == null) || (f2 == null)) {
			return false;
		} else {
			return f1.equals(f2);
		}
	}
}
