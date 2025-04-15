
/**
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 */

public class BudgetTrackerTest {
    @Test
    public void testCreateNewRep() {
        BudgetTracker x = new BudgetTracker1L();
        assertEquals(x.newInstance(), x);
    }

    @Test
    public void testTransferfrom1() {
        BudgetTracker w = new BudgetTracker1L();
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = new BudgetTracker1L();
        BudgetTracker z = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        z.addTransaction("food", 90.00);
        y.transferFrom(x);
        assertEquals(y, z);
        assertEquals(x, w);
    }

    @Test
    public void testTransferfrom2() {
        BudgetTracker w = new BudgetTracker1L();
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = new BudgetTracker1L();
        BudgetTracker z = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        x.addTransaction("games", 40.00);
        z.addTransaction("food", 90.00);
        z.addTransaction("games", 40.00);
        y.transferFrom(x);
        assertEquals(y, z);
        assertEquals(x, w);
    }

    @Test
    public void testTransferfrom3() {
        BudgetTracker w = new BudgetTracker1L();
        BudgetTracker x = new BudgetTracker1L();
        w.transferFrom(x);
        assertEquals(x, w);
    }

    @Test
    public void testNewInstance1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        x.addTransaction("games", 40.00);
        BudgetTracker w = x.newInstance();
        assertEquals(w, y);
    }

    @Test
    public void testNewInstance2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        BudgetTracker w = x.newInstance();
        assertEquals(w, y);
    }

    @Test
    public void testNewInstance3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = x.newInstance();
        x.addTransaction("food", 90.00);
        BudgetTracker w = x.newInstance();
        assertEquals(w, y);
    }

    @Test
    public void testClears1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = x.newInstance();
        x.addTransaction("food", 90.00);
        x.clear();
        assertEquals(x, y);
    }

    @Test
    public void testClears2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = x.newInstance();
        x.addTransaction("food", 90.00);
        x.addTransaction("games", 40.00);
        x.clear();
        assertEquals(x, y);
    }

    @Test
    public void testClears3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker y = x.newInstance();
        x.addTransaction("food", 90.00);
        x.addTransaction("games", 40.00);
        x.addTransaction("rent", 1400.00);
        x.clear();
        assertEquals(x, y);
    }

}
