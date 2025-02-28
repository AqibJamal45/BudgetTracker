import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Create a component to track monthly expenses.
 *
 * @author Aqib Jamal
 *
 */
public final class BudgetTracker {
    /**
     * Representation of {@code this}.
     */
    private Map<String, Double> budget;

    /**
     */
    public BudgetTracker() {
        this.budget = new Map1L<String, Double>();
    }

    /**
     * Adds a transaction to the bugdet with the expense name and price.
     *
     * @param price
     *            the price of the item
     * @param expense
     *            the name of the item
     */
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
    public String removeTransaction(String expense) {

        this.budget.remove(expense);
        return expense;
    }

    /**
     * Returns the amount of transactions in the budget.
     *
     * @return size of the budget
     */
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
    public Map.Pair<String, Double> removeAny() {

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
    public Double currentSpent() {

        double spent = 0;
        while (this.budget.size() != 0) {
            Map.Pair<String, Double> removed = this.budget.removeAny();
            double price = removed.value();
            spent += price;
        }
        return spent;
    }

    /**
     * Main Method.
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
    }
}
