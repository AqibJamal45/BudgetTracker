import components.map.Map;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
*/

public final class UseCase {

    /**
     *
    */
    private UseCase() {
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
        budget.removeTransaction(rent);
        String arcade = "arcade";
        final Double aracadePrice = 40.00;
        budget.addTransaction(arcade, aracadePrice);
        int size = budget.budgetSize();
        boolean check = budget.hasTransaction(utilities);
        if (!check) {
            budget.addTransaction(utilities, utilitiesPrice);
            budget.checkPrice(utilities);
        }
        boolean test = false;
        while (!test) {
            Map.Pair<String, Double> copy = budget.randomRemove();
            if (copy.key().equals(arcade)) {
                check = true;
                budget.addTransaction(copy.key(), copy.value());
            }
            budget.addTransaction(copy.key(), copy.value());
        }
        final int five = 5;
        if (size > five) {
            budget.removeTransaction(arcade);
        }
        out.print(budget);
        out.close();
        in.close();
    }

}
