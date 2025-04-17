import components.map.Map;

/**
 * This is the absract class of the BudgetTracker compoenent.
 */
public abstract class BudgetTrackerSecondary implements BudgetTracker {

    /**
     * Returns the total money spent in the budget.
     *
     * @return the total money spent in the budget
     */
    @Override
    public Double currentSpent() {

        double spent = 0;
        BudgetTracker test = this.newInstance();
        while (this.budgetSize() != 0) {
            Map.Pair<String, Double> removed = this.randomRemove();
            double price = removed.value();
            spent += price;
            test.addTransaction(removed.key(), removed.value());
        }
        this.transferFrom(test);
        return spent;
    }

    /*
     * Changes the budget into a string
     *
     * @returns map of strings
     */
    @Override
    public String toString() {

        String toReturn = "[";
        BudgetTracker test = this.newInstance();
        while (this.budgetSize() != 0) {
            Map.Pair<String, Double> removed = this.randomRemove();
            toReturn += removed + ", ";
            test.addTransaction(removed.key(), removed.value());
        }
        toReturn = toReturn.substring(0, toReturn.length() - 2);
        toReturn += "]";
        return toReturn;
    }

    /*
     * Establishes the equals method for the bugdetTracker.
     *
     */
    @Override
    public boolean equals(Object o) {

        if (o == this) { // aliasing
            return true;
        }

        if (o == null) { // can't compare
            return false;
        }

        if (!(o instanceof BudgetTracker)) { // not the same type
            return false;
        }

        BudgetTracker test = (BudgetTracker) o;

        boolean check = true;
        BudgetTracker copy = this.newInstance();
        BudgetTracker copyTwo = this.newInstance();
        while (test.budgetSize() != 0) {
            Map.Pair<String, Double> removed1 = this.randomRemove();
            Map.Pair<String, Double> removed2 = test.randomRemove();
            if (!removed1.key().equals(removed2.key())
                    || !removed1.value().equals(removed2.value())) {
                this.addTransaction(removed1.key(), removed1.value());
                test.addTransaction(removed2.key(), removed2.value());
                return false;
            }
            copyTwo.addTransaction(removed1.key(), removed1.value());
            copy.addTransaction(removed2.key(), removed2.value());
        }
        this.transferFrom(copyTwo);
        test.transferFrom(copy);
        return check;
    }
}
