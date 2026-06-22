package com.samuel.finances.screen.addpurchase

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.samuel.finances.components.DropdownSelector
import com.samuel.finances.repository.MockCategoryRepository
import com.samuel.finances.repository.MockPaymentMethodRepository
import java.time.LocalDate


@Composable
fun AddPurchaseScreen() {
    var description by remember {
        mutableStateOf("")
    }

    var value by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf(
            LocalDate.now().toString()
        )
    }

    val categories =
        MockCategoryRepository
            .getCategories()
            .map {it.name}

    val paymentMethod =
        MockPaymentMethodRepository
            .getMethods()
            .map {it.name}

    var selectedCategory by remember {
        mutableStateOf(categories.first())
    }
    var selectedPaymentMethod by remember {
        mutableStateOf(paymentMethod.first())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement =
                Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Add Purchase",
            style =
                MaterialTheme
                    .typography
                    .headlineMedium
        )

        DropdownSelector(
            label = "Category",
            items = categories,
            selectedItem = selectedCategory,
            onItemSelected = {
                selectedCategory = it
            }
        )

        DropdownSelector(
            label = "Payment Method",
            items = paymentMethod,
            selectedItem = selectedPaymentMethod,
            onItemSelected = {
                selectedPaymentMethod = it
            }
        )

        OutlinedTextField(
            value = date,
            onValueChange = {
                date = it
            },
            label = {
                Text("Date")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
        )

        OutlinedTextField(
            value = value,
            onValueChange = {
                value = it
            },
            label = {
                Text("Value")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
        )

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text("Description")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                println("Purchase Saved")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Purchase")
        }
    }
}