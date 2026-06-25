package com.samuel.finances.screen.addpurchase

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samuel.finances.components.DropdownSelector
import com.samuel.finances.repository.MockCategoryRepository
import com.samuel.finances.repository.MockPaymentMethodRepository
import com.samuel.finances.ui.theme.Sizes
import com.samuel.finances.viewmodel.AddPurchaseViewModel
import com.samuel.finances.viewmodel.CategoriesViewModel
import com.samuel.finances.viewmodel.PaymentMethodViewModel
import java.time.LocalDate


@Composable
fun AddPurchaseScreen() {
    val addPurchaseViewModel: AddPurchaseViewModel = viewModel()
    val categoriesViewModel: CategoriesViewModel = viewModel()
    val paymentMethodViewModel : PaymentMethodViewModel = viewModel()

    var description = addPurchaseViewModel.description

    var value = addPurchaseViewModel.value

    var date = addPurchaseViewModel.date

    val getCategories = categoriesViewModel.categories.map {it.name}

    val getPaymentMethods = paymentMethodViewModel.paymentMethods.map {it.name}

    var selectedCategory = categoriesViewModel.categories.first().name

    var selectedPaymentMethod = paymentMethodViewModel.paymentMethods.first().name

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Sizes.screenPadding),
        verticalArrangement =
                Arrangement.spacedBy(Sizes.spacers)
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
            items = getCategories,
            selectedItem = selectedCategory,
            onItemSelected = {
                selectedCategory = it
            }
        )

        DropdownSelector(
            label = "Payment Method",
            items = getPaymentMethods,
            selectedItem = selectedPaymentMethod,
            onItemSelected = {
                selectedPaymentMethod = it
            }
        )

        OutlinedTextField(
            value = date,
            onValueChange = { addPurchaseViewModel.updateDate(it) },
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
            onValueChange = { addPurchaseViewModel.updateValue(it) },
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
            onValueChange = { addPurchaseViewModel.updateDescription(it) },
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