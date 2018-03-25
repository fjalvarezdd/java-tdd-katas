package com.fjalvarez.tdd.darts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;

public class DartsTest {
    private Darts d;

    @Before
    public void setUpGame() {
        d = new Darts();
    }

    @Test
    public void aGameShouldStartAt301() {
        assertThat(d.score(), equalTo(301));
        assertThat(d.isFinished(), is(false));
    }

    @Test
    public void shouldCountADoubleThrow() {
        d.dart(20, Darts.Multiplier.DOUBLE);
    }

    @Test
    public void shouldCountAtTripleThrow() {
        d.dart(30, Darts.Multiplier.TRIPLE);
    }

    @Test
    public void shouldCountTheTurnInitially() {
        assertThat(d.getTurn(), is(1));
    }

    @Test
    public void shouldCountTheTurn() {
        d.dart(1);
        assertThat(d.getTurn(), is(1));
        assertThat(d.dartsLeft(), is(2));

        d.dart(1);
        assertThat(d.getTurn(), is(1));
        assertThat(d.dartsLeft(), is(1));

        d.dart(1);
        assertThat(d.getTurn(), is(2));
        assertThat(d.dartsLeft(), is(3));
    }

    @Test
    public void shouldGoBustReaching1() {
        // Lets reach 121
        for (int i=0; i<3; i++) {
            d.dart(20, Darts.Multiplier.TRIPLE);
        }
        d.dart(20, Darts.Multiplier.TRIPLE);
        d.dart(20, Darts.Multiplier.TRIPLE); // 1!

        assertEquals(121, d.score());
        assertEquals(3, d.getTurn());
        assertEquals(3, d.dartsLeft());
    }

    @Test
    public void shouldGoBustAboveZero() {
        // Lets reach 121
        for (int i=0; i<3; i++) {
            d.dart(20, Darts.Multiplier.TRIPLE);
        }
        d.dart(15, Darts.Multiplier.TRIPLE); // 76
        d.dart(15, Darts.Multiplier.TRIPLE); // 31
        d.dart(20, Darts.Multiplier.TRIPLE); // -29! Gone

        assertEquals(121, d.score());
        assertEquals(3, d.getTurn());
        assertEquals(3, d.dartsLeft());
    }

    @Test
    public void shouldCompleteAGameWithADouble() {
        // Lets reach 121
        for (int i=0; i<3; i++) {
            d.dart(20, Darts.Multiplier.TRIPLE);
        }
        d.dart(17, Darts.Multiplier.TRIPLE); // 70
        d.dart(20, Darts.Multiplier.TRIPLE); // 10
        d.dart(5, Darts.Multiplier.DOUBLE); // 0

        assertTrue(d.isFinished());
    }
}
