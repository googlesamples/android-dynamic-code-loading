package com.google.android.samples.storage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.samples.dynamiccodeloading.StorageFeature
import javax.inject.Inject

class StorageViewModel @Inject constructor(
    private val storageFeature: StorageFeature
) : ViewModel() {
    val counter = MutableLiveData<Int>(storageFeature.loadCounter())
}