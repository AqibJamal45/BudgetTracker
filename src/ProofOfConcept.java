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
public final class ProofOfConcept {
    /**
     * Representation of {@code this}.
     */
    private Map<String, Double> budget;

    /**
     */
    public ProofOfConcept() {
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

    @Override
    public String toString() {
        return this.budget.toString();
    }

    /**
     * Main Method.
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        ProofOfConcept budget = new ProofOfConcept();

        String rent = "rent";
        final Double rentPrice = 1500.00;
        budget.addTransaction(rent, rentPrice);
        String utilities = "utilities";
        final Double utilitiesPrice = 300.00;
        budget.addTransaction(utilities, utilitiesPrice);
        String groceries = "groceries";
        final Double groceriesPrice = 500.00;
        budget.addTransaction(groceries, groceriesPrice);
        String amazon = "amazon";
        final Double amazonPrice = 100.00;
        budget.addTransaction(amazon, amazonPrice);
        out.println();
        out.println("This is the state of bugdet when things are added");
        out.println(budget);
        out.println();

        String removed = budget.removeTransaction(rent);
        out.println("This component was manually removed");
        out.println(removed);
        out.println();
        out.println("This is the state of bugdet when item removed");
        out.println(budget);
        out.println();

        int size = budget.budgetSize();
        out.println("This is the size of the budget");
        out.println(size);
        out.println();

        boolean check = budget.hasTransaction(rent);
        out.println("This is returning hasTransaction(rent)");
        out.println(check);
        out.println();

        final Double checkPrice = budget.checkPrice(amazon);
        out.println("Returning price of specific transaction");
        out.println(checkPrice);
        out.println();

        final Double totalSpent = budget.currentSpent();
        out.println("This the total amount spent so far");
        out.println(totalSpent);
        out.println();

        Map.Pair<String, Double> random = budget.randomRemove();
        out.println("This is the random compoenent removed");
        out.println(random);
        out.println();

        out.close();
        in.close();
    }
}
