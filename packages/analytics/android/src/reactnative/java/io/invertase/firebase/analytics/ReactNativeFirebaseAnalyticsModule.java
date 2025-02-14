package io.invertase.firebase.analytics;

/*
 * Copyright (c) 2016-present Invertase Limited & Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this library except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */


import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import javax.annotation.Nullable;

import io.invertase.firebase.common.ReactNativeFirebaseModule;

public class ReactNativeFirebaseAnalyticsModule extends ReactNativeFirebaseModule {
  private static final String SERVICE_NAME = "Analytics";
  private final UniversalFirebaseAnalyticsModule module;

  ReactNativeFirebaseAnalyticsModule(ReactApplicationContext reactContext) {
    super(reactContext, SERVICE_NAME);
    module = new UniversalFirebaseAnalyticsModule(reactContext, SERVICE_NAME);
  }

  @ReactMethod
  public void logEvent(String name, @Nullable ReadableMap params, Promise promise) {
    module.logEvent(name, Arguments.toBundle(params)).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }

  @ReactMethod
  public void setAnalyticsCollectionEnabled(Boolean enabled, Promise promise) {
    module.setAnalyticsCollectionEnabled(enabled).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }

  @ReactMethod
  public void setSessionTimeoutDuration(double milliseconds, Promise promise) {
    module.setSessionTimeoutDuration((long) milliseconds).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }

  @ReactMethod
  public void setUserId(String id, Promise promise) {
    module.setUserId(id).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }

  @ReactMethod
  public void setUserProperty(String name, String value, Promise promise) {
    module.setUserProperty(name, value).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }


  @ReactMethod
  public void setUserProperties(ReadableMap properties, Promise promise) {
    module.setUserProperties(Arguments.toBundle(properties)).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }

  @ReactMethod
  public void resetAnalyticsData(Promise promise) {
    module.resetAnalyticsData().addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        promise.resolve(task.getResult());
      } else {
        rejectPromiseWithExceptionMap(promise, task.getException());
      }
    });
  }
}
