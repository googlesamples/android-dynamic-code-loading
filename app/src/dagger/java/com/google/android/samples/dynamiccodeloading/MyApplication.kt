/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.google.android.samples.dynamiccodeloading

import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.samples.dynamiccodeloading.di.BaseComponent
import com.google.android.samples.dynamiccodeloading.di.DaggerBaseComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return baseComponent
    }

    override fun onCreate() {
        super.onCreate()
        SplitCompat.install(this)
        baseComponent.inject(this)
    }

    val baseComponent: BaseComponent by lazy {
        DaggerBaseComponent.builder()
            .application(this)
            .build()
    }
}