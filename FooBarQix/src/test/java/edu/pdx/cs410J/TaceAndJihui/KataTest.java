package edu.pdx.cs410J.TaceAndJihui;

import org.junit.jupiter.api.Test;

import static edu.pdx.cs410J.TaceAndJihui.Kata.compute;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KataTest
{

  @Test
  void canInstantiateKataClass() {
    new Kata();
  }

  @Test
  void oneReturnsOne() {
    assertThat(compute("1"), equalTo("1"));
  }
  @Test
  void divisibleByThreeReturnsFoo() {
    assertThat(compute("6"), equalTo("Foo"));
  }

  @Test
  void divisibleByFiveReturnsFoo() {
    assertThat(compute("10"), equalTo("Bar"));
  }

  @Test
  void divisibleBySevenReturnsFoo() {
    assertThat(compute("14"), equalTo("Qix"));
  }

  @Test
  void threeReturnsFooFoo() {
    assertThat(compute("3"), equalTo("FooFoo"));
  }

  @Test
  void fiveReturnsBarBar() {
    assertThat(compute("5"), equalTo("BarBar"));
  }

  @Test
  void sevenReturnsQixQix() {
    assertThat(compute("7"), equalTo("QixQix"));
  }

  @Test
  void testComplexResults() {
    assertThat(compute("15"), equalTo("FooBarBar"));
    assertThat(compute("21"), equalTo("FooQix"));
    assertThat(compute("33"), equalTo("FooFooFoo"));
  }

  @Test
  void okayNowWeAddedTheZeroThing() {
    assertThat(compute("101"), equalTo("1*1"));
    assertThat(compute("303"), equalTo("FooFoo*Foo"));
    assertThat(compute("105"), equalTo("FooBarQix*Bar"));
    assertThat(compute("10101"), equalTo("FooQix**"));
  }
}
