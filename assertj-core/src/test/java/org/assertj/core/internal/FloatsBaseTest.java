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
package org.assertj.core.internal;

import static org.assertj.core.testkit.TestData.someInfo;
import static org.mockito.Mockito.spy;

import org.assertj.core.api.WritableAssertionInfo;
import org.assertj.core.util.AbsValueComparator;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base class for testing <code>{@link Floats}</code>, set up an instance with {@link StandardComparisonStrategy} and another with
 * {@link ComparatorBasedComparisonStrategy}.
 * <p>
 * Is in <code>org.assertj.core.internal</code> package to be able to set {@link Floats#failures} appropriately and to use
 * {@link Floats#NaN()}.
 *
 * @author Joel Costigliola
 */
public class FloatsBaseTest {

  protected static final WritableAssertionInfo INFO = someInfo();

  protected Failures failures;
  protected Floats floats;

  protected ComparatorBasedComparisonStrategy absValueComparisonStrategy;
  protected Floats floatsWithAbsValueComparisonStrategy;

  @BeforeEach
  public void setUp() {
    failures = spy(Failures.instance());
    floats = new Floats();
    floats.setFailures(failures);
    absValueComparisonStrategy = new ComparatorBasedComparisonStrategy(new AbsValueComparator<Float>());
    floatsWithAbsValueComparisonStrategy = new Floats(absValueComparisonStrategy);
    floatsWithAbsValueComparisonStrategy.failures = failures;
  }

  protected Float NaN() {
    return floats.NaN();
  }

  protected Float absDiff(Float actual, Float other) {
    return Floats.instance().absDiff(actual, other);
  }
}
