package com.fjalvarez.tdd.helloworld;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;

public class GreeterTest {

    @Test
    public void shouldSayHelloToWorld() {
        Greeter greeter = new Greeter();
        String helloMessage = greeter.sayHello();
        assertThat(helloMessage, equalTo("Hello World!"));
    }
}
