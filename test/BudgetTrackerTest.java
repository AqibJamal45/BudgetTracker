
/**
 *
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.map.Map;

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

    @Test
    public void addTransaction() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        assertEquals(eX, x);
    }

    @Test
    public void addTransaction2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        assertEquals(eX, x);
    }

    @Test
    public void addTransaction3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        assertEquals(eX, x);
    }

    @Test
    public void removeTransaction1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        x.removeTransaction("rent");
        eX.removeTransaction("rent");
        assertEquals(eX, x);
    }

    @Test
    public void removeTransaction2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        x.removeTransaction("rent");
        eX.removeTransaction("rent");
        x.removeTransaction("food");
        eX.removeTransaction("food");
        assertEquals(eX, x);
    }

    @Test
    public void removeTransaction3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        x.removeTransaction("rent");
        eX.removeTransaction("rent");
        x.removeTransaction("food");
        eX.removeTransaction("food");
        x.removeTransaction("games");
        eX.removeTransaction("games");
        assertEquals(eX, x);
    }

    @Test
    public void budgetSize1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        x.removeTransaction("rent");
        eX.removeTransaction("rent");
        x.removeTransaction("food");
        eX.removeTransaction("food");
        x.removeTransaction("games");
        eX.removeTransaction("games");
        int xSize = x.budgetSize();
        int eXSize = eX.budgetSize();
        assertEquals(eXSize, xSize);
    }

    @Test
    public void budgetSize2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        x.removeTransaction("rent");
        eX.removeTransaction("rent");
        x.removeTransaction("food");
        eX.removeTransaction("food");
        int xSize = x.budgetSize();
        int eXSize = eX.budgetSize();
        assertEquals(eXSize, xSize);
    }

    @Test
    public void budgetSize3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        int xSize = x.budgetSize();
        int eXSize = eX.budgetSize();
        assertEquals(eXSize, xSize);
    }

    @Test
    public void hasTransaction1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        boolean checkX = x.hasTransaction("rent");
        boolean checkEx = eX.hasTransaction("rent");
        assertEquals(checkEx, checkX);
    }

    @Test
    public void hasTransaction2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        boolean checkX = x.hasTransaction("utilities");
        boolean checkEx = eX.hasTransaction("utilities");
        assertEquals(checkEx, checkX);
    }

    @Test
    public void hasTransaction3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        boolean checkX = x.hasTransaction("food");
        boolean checkEx = eX.hasTransaction("food");
        assertEquals(checkEx, checkX);
    }

    @Test
    public void checkPrice1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        Double checkX = x.checkPrice("rent");
        Double checkEx = eX.checkPrice("rent");
        assertEquals(checkEx, checkX);
    }

    @Test
    public void checkPrice2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        Double checkX = x.checkPrice("games");
        Double checkEx = eX.checkPrice("games");
        assertEquals(checkEx, checkX);
    }

    @Test
    public void checkPrice3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        Double checkX = x.checkPrice("food");
        Double checkEx = eX.checkPrice("food");
        assertEquals(checkEx, checkX);
    }

    @Test
    public void randomRemove1() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        x.addTransaction("rent", 1400.00);
        eX.addTransaction("rent", 1400.00);
        Map.Pair<String, Double> remove = x.randomRemove();
        boolean check = eX.hasTransaction(remove.key());
        assertTrue(check);
        String removeTwo = eX.removeTransaction(remove.key());
        assertEquals(eX, x);
        assertEquals(removeTwo, remove.key());
    }

    @Test
    public void randomRemove2() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        x.addTransaction("games", 50.00);
        eX.addTransaction("games", 50.00);
        Map.Pair<String, Double> remove = x.randomRemove();
        boolean check = eX.hasTransaction(remove.key());
        assertTrue(check);
        String removeTwo = eX.removeTransaction(remove.key());
        assertEquals(eX, x);
        assertEquals(removeTwo, remove.key());
    }

    @Test
    public void randomRemove3() {
        BudgetTracker x = new BudgetTracker1L();
        BudgetTracker eX = new BudgetTracker1L();
        x.addTransaction("food", 90.00);
        eX.addTransaction("food", 90.00);
        Map.Pair<String, Double> remove = x.randomRemove();
        boolean check = eX.hasTransaction(remove.key());
        assertTrue(check);
        String removeTwo = eX.removeTransaction(remove.key());
        assertEquals(eX, x);
        assertEquals(removeTwo, remove.key());
    }

}
