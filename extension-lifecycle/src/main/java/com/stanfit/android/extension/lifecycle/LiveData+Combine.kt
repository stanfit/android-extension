package com.stanfit.android.extension.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.distinctUntilChanged

/**
 * A function that monitors multiple LiveData values and outputs results when one of the values is changed.
 *
 * @param T output type.
 * @param LIVE1 monitoring live data type.
 * @param initialValue initial value.
 * @param liveData1 monitoring live data.
 * @param block output function.
 * @return live data
 */
inline fun <T : Any, LIVE1 : Any> combine(
    initialValue: T,
    liveData1: LiveData<LIVE1>,
    crossinline block: (T, LIVE1) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        value = initialValue
        listOf(liveData1).forEach { liveData ->
            addSource(liveData) {
                val currentValue = value
                val liveData1Value = liveData1.value
                if (currentValue != null && liveData1Value != null) {
                    value = block(currentValue, liveData1Value)
                }
            }
        }
    }.distinctUntilChanged()
}

/**
 * A function that monitors multiple LiveData values and outputs results when one of the values is changed.
 *
 * @param T output type.
 * @param LIVE1 monitoring live data type.
 * @param LIVE2 monitoring live data type.
 * @param initialValue initial value.
 * @param liveData1 monitoring live data.
 * @param liveData2 monitoring live data.
 * @param block output function.
 * @return live data
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any> combine(
    initialValue: T,
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    crossinline block: (T, LIVE1, LIVE2) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        value = initialValue
        listOf(liveData1, liveData2).forEach { liveData ->
            addSource(liveData) {
                val currentValue = value
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                if (currentValue != null && liveData1Value != null && liveData2Value != null) {
                    value = block(currentValue, liveData1Value, liveData2Value)
                }
            }
        }
    }.distinctUntilChanged()
}

/**
 * A function that monitors multiple LiveData values and outputs results when one of the values is changed.
 *
 * @param T output type.
 * @param LIVE1 monitoring live data type.
 * @param LIVE2 monitoring live data type.
 * @param LIVE3 monitoring live data type.
 * @param initialValue initial value.
 * @param liveData1 monitoring live data.
 * @param liveData2 monitoring live data.
 * @param liveData3 monitoring live data.
 * @param block output function.
 * @return live data
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any, LIVE3 : Any> combine(
    initialValue: T,
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    liveData3: LiveData<LIVE3>,
    crossinline block: (T, LIVE1, LIVE2, LIVE3) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        value = initialValue
        listOf(liveData1, liveData2, liveData3).forEach { liveData ->
            addSource(liveData) {
                val currentValue = value
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                val liveData3Value = liveData3.value
                if (currentValue != null && liveData1Value != null &&
                    liveData2Value != null && liveData3Value != null
                ) {
                    value = block(currentValue, liveData1Value, liveData2Value, liveData3Value)
                }
            }
        }
    }.distinctUntilChanged()
}

/**
 * A function that monitors multiple LiveData values and outputs results when one of the values is changed.
 *
 * @param T
 * @param LIVE1 monitoring live data type.
 * @param LIVE2 monitoring live data type.
 * @param LIVE3 monitoring live data type.
 * @param LIVE4 monitoring live data type.
 * @param initialValue initial value.
 * @param liveData1 monitoring live data.
 * @param liveData2 monitoring live data.
 * @param liveData3 monitoring live data.
 * @param liveData4 monitoring live data.
 * @param block output function.
 * @return live data
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any, LIVE3 : Any, LIVE4 : Any> combine(
    initialValue: T,
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    liveData3: LiveData<LIVE3>,
    liveData4: LiveData<LIVE4>,
    crossinline block: (T, LIVE1, LIVE2, LIVE3, LIVE4) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        value = initialValue
        listOf(liveData1, liveData2, liveData3, liveData4).forEach { liveData ->
            addSource(liveData) {
                val currentValue = value
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                val liveData3Value = liveData3.value
                val liveData4Value = liveData4.value
                if (currentValue != null && liveData1Value != null &&
                    liveData2Value != null && liveData3Value != null &&
                    liveData4Value != null
                ) {
                    value = block(
                        currentValue,
                        liveData1Value,
                        liveData2Value,
                        liveData3Value,
                        liveData4Value
                    )
                }
            }
        }
    }.distinctUntilChanged()
}

/**
 * A function that monitors multiple LiveData values and outputs results when one of the values is changed.
 *
 * @param T
 * @param LIVE1 monitoring live data type.
 * @param LIVE2 monitoring live data type.
 * @param LIVE3 monitoring live data type.
 * @param LIVE4 monitoring live data type.
 * @param LIVE5 monitoring live data type.
 * @param initialValue initial value.
 * @param liveData1 monitoring live data.
 * @param liveData2 monitoring live data.
 * @param liveData3 monitoring live data.
 * @param liveData4 monitoring live data.
 * @param liveData5 monitoring live data.
 * @param block output function.
 * @return live data
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any, LIVE3 : Any, LIVE4 : Any, LIVE5 : Any> combine(
    initialValue: T,
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    liveData3: LiveData<LIVE3>,
    liveData4: LiveData<LIVE4>,
    liveData5: LiveData<LIVE5>,
    crossinline block: (T, LIVE1, LIVE2, LIVE3, LIVE4, LIVE5) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        value = initialValue
        listOf(liveData1, liveData2, liveData3, liveData4, liveData5).forEach { liveData ->
            addSource(liveData) {
                val currentValue = value
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                val liveData3Value = liveData3.value
                val liveData4Value = liveData4.value
                val liveData5Value = liveData5.value
                if (currentValue != null && liveData1Value != null &&
                    liveData2Value != null && liveData3Value != null &&
                    liveData4Value != null && liveData5Value != null
                ) {
                    value = block(
                        currentValue,
                        liveData1Value,
                        liveData2Value,
                        liveData3Value,
                        liveData4Value,
                        liveData5Value
                    )
                }
            }
        }
    }.distinctUntilChanged()
}