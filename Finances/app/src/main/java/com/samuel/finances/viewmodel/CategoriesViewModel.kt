package com.samuel.finances.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.samuel.finances.repository.MockCategoryRepository

class CategoriesViewModel : ViewModel() {

    private val repository = MockCategoryRepository

    val categories = repository.getCategories()

    var selectedCategory by mutableStateOf("")
        private set

    fun updateCategory(newCategory: String) {
        selectedCategory = newCategory
    }
}