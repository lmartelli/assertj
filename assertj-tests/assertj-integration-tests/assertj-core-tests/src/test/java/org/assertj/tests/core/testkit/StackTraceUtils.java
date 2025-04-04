/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2025 the original author or authors.
 */
package org.assertj.tests.core.testkit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.Arrays;

public class StackTraceUtils {

  /**
   * Returns true if given {@link Throwable} stack trace contains AssertJ related elements, false otherwise.
   *
   * @param throwable the {@link Throwable} we want to check stack trace for AssertJ related elements.
   * @return true if given {@link Throwable} stack trace contains AssertJ related elements, false otherwise.
   */
  public static boolean hasAssertJStackTraceElement(Throwable throwable) {
    return Arrays.stream(throwable.getStackTrace())
                 .anyMatch(stackTraceElement -> stackTraceElement.getClassName().contains("org.assertj.core"));
  }

  public static void checkNoAssertjStackTraceElementIn(Throwable throwable) {
    StackTraceElement[] stackTrace = throwable.getStackTrace();
    then(stackTrace).noneSatisfy(stackTraceElement -> assertThat(stackTraceElement.toString()).contains("org.assertj.core"));
  }

}
