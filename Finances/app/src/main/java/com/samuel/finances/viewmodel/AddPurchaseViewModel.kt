package com.samuel.finances.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.samuel.finances.repository.MockCategoryRepository
import com.samuel.finances.repository.MockPaymentMethodRepository
import java.time.LocalDate

class AddPurchaseViewModel : ViewModel() {
    var description by mutableStateOf("")
        private set

    var value by mutableStateOf("")
        private set

    var date by mutableStateOf(LocalDate.now().toString())
        private set

    fun updateDescription(newDescription: String) {
        this.description = newDescription
    }

    fun updateValue(newValue: String) {
        this.value = newValue
    }
    fun updateDate(newDate: String) {
        this.date = newDate
    }
}