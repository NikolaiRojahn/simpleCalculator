/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtests;

import static com.sun.javafx.animation.TickCalculation.sub;
import java.io.IOException;
import static javafx.beans.binding.Bindings.add;
import static javax.management.Query.div;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.HttpClient;

/**
 *
 * @author nr
 */
public class WebCalculatorTest {

    HttpClient client = new HttpClient("http://localhost:7777/simpleCalculator/calculator");

    public WebCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addTest() throws IOException {
        String res = client.makeHttpRequest("?operation=add&n1=2&n2=3");
        assertEquals("Result of: 2+3 = 5", res);
    }

    @Test
    public void subTest() throws IOException {
        String res = client.makeHttpRequest("?operation=sub&n1=7&n2=3");
        assertEquals("Result of: 7-3 = 4", res);
    }

    @Test
    public void mulTest() throws IOException {
        String res = client.makeHttpRequest("?operation=mul&n1=10&n2=19");
        assertEquals("Result of: 10*19 = 190", res);
    }

    @Test
    public void divTest() throws IOException, ArithmeticException {
        String res = client.makeHttpRequest("?operation=div&n1=50&n2=5");
        assertEquals("Result of: 50/5 = 10", res);
    }

    @Test (expected = IOException.class)
    public void divZeroTest() throws IOException, ArithmeticException {
        String res = client.makeHttpRequest("?operation=div&n1=17&n2=0");
    }
    
}
