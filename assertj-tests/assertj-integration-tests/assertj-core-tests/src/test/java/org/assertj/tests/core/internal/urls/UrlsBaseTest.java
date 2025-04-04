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
package org.assertj.tests.core.internal.urls;

import static org.apache.commons.lang3.reflect.FieldUtils.writeField;
import static org.assertj.tests.core.testkit.TestData.someInfo;
import static org.mockito.Mockito.spy;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.Failures;
import org.assertj.core.internal.Urls;
import org.junit.jupiter.api.BeforeEach;

public abstract class UrlsBaseTest {

  protected Failures failures;
  protected Urls urls;
  protected AssertionInfo info;

  @BeforeEach
  void setUp() throws IllegalAccessException {
    failures = spy(Failures.instance());
    urls = Urls.instance();
    writeField(urls, "failures", failures, true);
    info = someInfo();
  }

}
