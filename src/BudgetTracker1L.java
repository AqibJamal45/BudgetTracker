import components.map.Map;
import components.map.Map1L;

/**
 * Create a component to track monthly expenses.
 *
 * @convention no duplicates are allowed in the to do list
 *
 * @correspondance the BudgetTracker is a Map (transaction, price of
 *                 transaction) and it has no order.
 *
 * @author Aqib Jamal
 *
 */
public final class BudgetTracker1L extends BudgetTrackerSecondary {
    /**
     * Representation of {@code this}.
     */
    private Map<String, Double> budget;

    /**
     */
    public BudgetTracker1L() {
        this.budget = new Map1L<String, Double>();
    }

    /**
     * the is creating a new rep.
     */
    public void createNewRep() {
        this.budget = new Map1L<String, Double>();
    }

    /**
     * clears the BudgetTracker.
     */
    @Override
    public void clear() {

        this.createNewRep();
    }

    /**
     * @return a new BudgetTracker object
     */
    @Override
    public BudgetTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "cannot construct object of type" + this.getClass());
        }
    }

    /**
     * Transfer from one budget tracker to another.
     *
     * @param source
     * @updates this
     */
    @Override
    public void transferFrom(BudgetTracker source) {
        BudgetTracker1L localSource = (BudgetTracker1L) source;
        this.budget = localSource.budget;
        localSource.createNewRep();
    }

    /**
     * Adds a transaction to the bugdet with the expense name and price.
     *
     * @param price
     *            the price of the item
     * @param expense
     *            the name of the item
     */
    @Override
    public void addTransaction(String expense, Double price) {
        this.budget.add(expense, price);
    }

    /**
     * Removes a transaction from the budget.
     *
     * @param expense
     *            The name of transaction that will be removed
     *
     * @return expense that is removed
     */
    @Override
    public String removeTransaction(String expense) {

        this.budget.remove(expense);
        return expense;
    }

    /**
     * Returns the amount of transactions in the budget.
     *
     * @return size of the budget
     */
    @Override
    public int budgetSize() {

        int size = this.budget.size();
        return size;
    }

    /**
     * Returns if the transaction exists in the budget.
     *
     * @param expense
     *            The name of the transaction being checked
     *
     * @return boolean check
     */
    @Override
    public boolean hasTransaction(String expense) {

        boolean check = false;
        if (this.budget.hasKey(expense)) {
            check = true;
        }
        return check;
    }

    /**
     * Returns a random transacton in the budget.
     *
     * @return a random expense from the bugdet
     */
    @Override
    public Map.Pair<String, Double> randomRemove() {

        return this.budget.removeAny();
    }

    /**
     * Returns a random transacton in the budget.
     *
     * @param expense
     *            The name of the transaction being checked
     *
     * @return a random expense from the bugdet
     */
    @Override
    public Double checkPrice(String expense) {

        double price = 0;
        boolean check = false;
        if (this.budget.hasKey(expense)) {
            check = true;
        }
        if (check) {
            price = this.budget.value(expense);
        }
        return price;
    }

    /**
     * Returns the total money spent in the budget.
     *
     * @return the total money spent in the budget
     */
    @Override
    public Double currentSpent() {

        double spent = 0;
        Map<String, Double> test = this.budget.newInstance();
        while (this.budget.size() != 0) {
            Map.Pair<String, Double> removed = this.budget.removeAny();
            double price = removed.value();
            spent += price;
            test.add(removed.key(), removed.value());
        }
        this.budget.transferFrom(test);
        return spent;
    }

    // @Override
    // public String toString() {
    //     return this.budget.toString();
    // }
}
