/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trello.rxlifecycle2.kotlin

import android.view.View
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

fun <T, E> Observable<T>.bindToLifecycle(provider: LifecycleProvider<E>): Observable<T>
        = this.compose<T>(provider.bindToLifecycle<T>())

fun <T, E> Observable<T>.bindUntilEvent(provider: LifecycleProvider<E>, event: E): Observable<T>
        = this.compose<T>(provider.bindUntilEvent(event))

fun <T> Observable<T>.bindToLifecycle(view: View): Observable<T>
        = this.compose<T>(RxLifecycleAndroid.bindView(view))

fun <E> Completable.bindToLifecycle(provider: LifecycleProvider<E>): Completable
        = this.compose(provider.bindToLifecycle<Completable>())

fun <E> Completable.bindUntilEvent(provider: LifecycleProvider<E>, event: E): Completable
        = this.compose(provider.bindUntilEvent<Completable>(event))

fun Completable.bindToLifecycle(view: View): Completable
        = this.compose(RxLifecycleAndroid.bindView<Completable>(view))

fun <T, E> Single<T>.bindToLifecycle(provider: LifecycleProvider<E>): Single<T>
        = this.compose(provider.bindToLifecycle<T>())

fun <T, E> Single<T>.bindUntilEvent(provider: LifecycleProvider<E>, event: E): Single<T>
        = this.compose(provider.bindUntilEvent<T>(event))

fun <T> Single<T>.bindToLifecycle(view: View): Single<T>
        = this.compose(RxLifecycleAndroid.bindView<T>(view))