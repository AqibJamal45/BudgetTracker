import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
*/

public final class UseCase2 {

    /**
     *
    */
    private UseCase2() {
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

        BudgetTracker budget = new BudgetTracker1L();

        budget.addTransaction("carInsurance", 350.00);
        budget.addTransaction("dinner", 15.00);
        budget.addTransaction("jerseys", 20.00);
        budget.addTransaction("costco", 4000.00);
        Double spent = budget.currentSpent();
        final double limit = 4300.00;
        if (spent > limit) {
            budget.removeTransaction("jerseys"); // product returned
        }
        boolean check = budget.hasTransaction("costco");
        if (check) {
            budget.checkPrice("costco");
        }
        out.print(budget);
        out.close();
        in.close();
    }

}
