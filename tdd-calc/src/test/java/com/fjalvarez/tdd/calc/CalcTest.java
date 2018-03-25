package com.fjalvarez.tdd.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalcTest {
    @Test
    public void shouldShowZeroWhenJustInstantiated() {
        Calc calc = new Calc();
        assertDisplayAfterKeyStrokes("0", calc);
    }

    @Test
    public void shouldDisplayTheNumberComposedByKeystrokes() {
        assertDisplayAfterKeyStrokes("0", new Calc(), '0');
        assertDisplayAfterKeyStrokes("0", new Calc(), '0', '0');
        assertDisplayAfterKeyStrokes("1", new Calc(), '1');
        assertDisplayAfterKeyStrokes("123", new Calc(), '1', '2', '3');
        assertDisplayAfterKeyStrokes("45", new Calc(), '0', '0', '4', '5');
    }

    @Test
    public void shouldNotDisplayMoreThanNineDigits() {
        assertDisplayAfterKeyStrokes("123456789", new Calc(), '1', '2', '3', '4', '5', '6', '7', '8', '9');
        assertDisplayAfterKeyStrokes("123456789", new Calc(), '1', '2', '3', '4', '5', '6', '7', '8', '9', '1');
        assertDisplayAfterKeyStrokes("123456789", new Calc(), '1', '2', '3', '4', '5', '6', '7', '8', '9', '1', '1');
    }

    @Test
    public void shouldDisplayNumberAsSoonItIsTyped() {
        Calc calc = new Calc();
        assertDisplayAfterKeyStrokes("0", calc, '0');
        assertDisplayAfterKeyStrokes("1", calc, '1');
        assertDisplayAfterKeyStrokes("12", calc, '2');
        assertDisplayAfterKeyStrokes("122", calc, '2');
        assertDisplayAfterKeyStrokes("1220", calc, '0');
        assertDisplayAfterKeyStrokes("12209", calc, '9');
    }

    private void assertDisplayAfterKeyStrokes(String display, Calc calc, Character... keyStrokes) {
        Arrays.asList(keyStrokes).forEach(ks -> calc.press(ks));
        assertThat(calc.display(), equalTo(display));
    }
}
