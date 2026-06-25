package com.samuel.finances.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.samuel.finances.repository.MockPaymentMethodRepository

class PaymentMethodViewModel : ViewModel() {

    private val repository = MockPaymentMethodRepository

    val paymentMethods = repository.getMethods()
}