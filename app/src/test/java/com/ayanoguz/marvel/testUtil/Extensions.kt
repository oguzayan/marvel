package com.ayanoguz.marvel.testUtil

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    latchCount: Int = 1
): T? {
    var data: T? = null
    val latch = CountDownLatch(latchCount)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            if (latch.count == 0L)
                removeObserver(this)
        }
    }
    observeForever(observer)
    latch.await(time, timeUnit)

    return data
}