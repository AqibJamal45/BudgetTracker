import components.map.Map;
import components.standard.Standard;

/**
 * Kernal methods for the BudgetTracker component.
 */
interface BudgetTrackerKernel extends Standard<BudgetTracker> {

    /**
     * Adds a transaction to the bugdet with the expense name and price.
     *
     * @param price
     *            the price of the item
     * @param expense
     *            the name of the item
     * @ensures expense and price are added to this.budget
     */
    void addTransaction(String expense, Double price);

    /**
     * Removes a transaction from the budget.
     *
     * @param expense
     *            The name of transaction that will be removed
     *
     * @ensures expense is removed from this.budget
     *
     * @return expense that is removed
     */
    String removeTransaction(String expense);

    /**
     * Returns the amount of transactions in the budget.
     *
     * @ensures size of this.budget is returned
     *
     * @return size of the budget
     */
    int budgetSize();

    /**
     * Returns if the transaction exists in the budget.
     *
     * @param expense
     *            The name of the transaction being checked
     *
     * @ensures if expense is in this.budget
     *
     * @return boolean
     */
    boolean hasTransaction(String expense);

    /**
     * Returns and removes a random transacton in the budget.
     *
     * @pre this.budget > 0
     *
     * @ensures #this.budget > this.budget
     *
     * @return a random expense from the bugdet
     */
    Map.Pair<String, Double> randomRemove();

    /**
     * Returns this price of an expense.
     *
     * @param expense
     *            The name of the transaction being checked
     *
     * @ensures price is this value of expense
     *
     * @return the price of expense
     */
    Double checkPrice(String expense);

}
