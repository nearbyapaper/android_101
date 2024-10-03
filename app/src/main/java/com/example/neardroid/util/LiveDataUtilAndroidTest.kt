package com.example.neardroid.util

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS

/*
// designed to observe a LiveData instance and wait for it to emit a value.
// This is typically used in unit tests, where you want to make sure that the LiveData emits a value
// within a specified time frame before continuing the test. If the LiveData doesn't emit a value within the given time,
// the function throws an exception.
 */
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2, // The maximum amount of time to wait for a value.
    timeUnit: TimeUnit = SECONDS, // The unit of time to wait (default is SECONDS).
    afterObserve: () -> Unit = {} // A lambda function that gets executed immediately after the observation starts.
                        // This can be useful to trigger certain actions (e.g., make network calls or set up the environment).
): T {
    var data: T? = null
    val latch = CountDownLatch(1) // A CountDownLatch is a synchronization aid that allows one or more threads
    // to wait until a set of operations being performed in other threads completes.
    // In this case, it waits until the LiveData emits a value.

    val observer = object : Observer<T> {
        // The Observer is created to listen for changes in the LiveData.
        // Once the LiveData emits a value (onChanged is triggered)
        override fun onChanged(value: T) {
            data = value // Stores the emitted value in the data variable.
            latch.countDown() // Calls latch.countDown() to signal that the value has been received and the waiting can stop.
            this@getOrAwaitValue.removeObserver(this) // Removes itself (removeObserver(this)) to avoid memory leaks or additional observations.

        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke() // Calls the afterObserve lambda, which can contain any code you want to execute
                              // after the observation starts.

        // Don't wait indefinitely if LiveData is not set
        if (!latch.await(time, timeUnit)) {
            // This waits for the LiveData to emit a value. If the LiveData emits a value before the time runs out,
            // the await() method returns true, and the function continues. If no value is emitted within the time frame,
            // the method returns false, and a RuntimeException is thrown with the message "LiveData value was never set."
            throw RuntimeException("LiveData value was never set.")
        }

    } finally {
        // the observer is removed, ensuring cleanup happens even if an error occurs.
        this.removeObserver(observer)
    }

    // After the waiting period, the value emitted by the LiveData is returned.
    // If the LiveData emits null, the function throws a NullPointerException with the message
    // "LiveData returned null value."
    return data ?: throw NullPointerException("LiveData returned null value")
}
