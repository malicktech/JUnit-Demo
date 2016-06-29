package demo2.testhelpers;

import testhelpers.ComparabilityTestCase;

public class ComparableTest extends
		ComparabilityTestCase<ComparableTest.SomeComparator> {
	@Override
	protected SomeComparator createEqualInstance() throws Exception {
		return new SomeComparator(10);
	}

	@Override
	protected SomeComparator createLessInstance() throws Exception {
		return new SomeComparator(5);
	}

	@Override
	protected SomeComparator createGreaterInstance() throws Exception {
		return new SomeComparator(15);
	}

	class SomeComparator implements Comparable<SomeComparator> {
		Integer anInt;

		SomeComparator(int theInt) {
			anInt = theInt;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((anInt == null) ? 0 : anInt.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SomeComparator other = (SomeComparator) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (anInt == null) {
				if (other.anInt != null)
					return false;
			} else if (!anInt.equals(other.anInt))
				return false;
			return true;
		}

		@Override
		public int compareTo(SomeComparator o) {
			return anInt.compareTo(o.anInt);
		}

		private ComparableTest getOuterType() {
			return ComparableTest.this;
		}
	}
}
