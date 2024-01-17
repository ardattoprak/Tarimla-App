package msku.ceng.madlab.tarimlaapp;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void citiesCountTest() { // Written by Arda Toprak
        ArrayList<String> arrayList = Constants.getCitySpinnerChoices();
        assertEquals(81,arrayList.size());
    }
    @Test
    public void productsCountTest() { // Written by Arda Toprak
        ArrayList<String> arrayList = Constants.getProductSpinnerChoises();
        assertEquals(11,arrayList.size());
    }
}