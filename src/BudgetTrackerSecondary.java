/**
 *
 */
interface BudgetTrackerSecondary extends BudgetTrackerKernel {

    /**
     * Returns the total money spent in the budget.
     *
     * @pre this.budget > 0
     *
     * @ensures total spent is sum of all values in this.budget
     *
     * @return the total money spent in the budget
     */
    Double currentSpent();

}
