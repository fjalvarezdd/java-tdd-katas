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
        assertThat(d.dartsLeft(), is(0));
    }
}
