package edu.pdx.cs410J.TeamAwesome;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

class KataIT extends InvokeMainTestCase {

  @Test
  void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }

  @Test
  void invokingMainWithOneArgument() {
    MainMethodResult result = invokeMain(Kata.class, "20");
    assertThat(result.getTextWrittenToStandardOut(), containsString("20"));
  }

  @Test
  void invokingMainWithSampleOne() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "20", "5", "/");
    assertThat(result.getTextWrittenToStandardOut(), containsString("4"));
  }

  @Test
  void invokingMainWithSampleTwo() {
    MainMethodResult result = invokeMain(Kata.class, "4", "2", "+", "3", "-");
    assertThat(result.getTextWrittenToStandardOut(), containsString("3"));
  }

  @Test
  void invokingMainWithSampleThree() {
    MainMethodResult result = invokeMain(Kata.class, "3", "5", "8", "*", "7", "+", "*");
    assertThat(result.getTextWrittenToStandardOut(), containsString("141"));
  }

  @Test
  void invokingMainWithSqrt() {
    MainMethodResult result = invokeMain(Kata.class, "9", "SQRT");
    assertThat(result.getTextWrittenToStandardOut(), containsString("3"));
  }

  @Test
  void invokingMainWithAdditionAndSqrt() {
    MainMethodResult result = invokeMain(Kata.class, "3", "3", "*", "SQRT");
    assertThat(result.getTextWrittenToStandardOut(), containsString("3"));
  }

  @Test
  void invokingMainWithMaxSampleOne() {
    MainMethodResult result = invokeMain(Kata.class, "5", "3", "4", "2", "9", "1", "MAX");
    assertThat(result.getTextWrittenToStandardOut(), containsString("9"));
  }

//  @Test
//  void invokingMainWithMaxSampleTwo() {
//    MainMethodResult result = invokeMain(Kata.class, "4", "5", "MAX", "1", "2", "MAX", "*");
//    assertThat(result.getTextWrittenToStandardOut(), containsString("10"));
//  }
}
