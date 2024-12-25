package com.example.tripapp.ui.feature.baggage

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class Item(
    val id: Int,
    val name: String,
    val isChecked: Boolean
)

class ItemViewModel : ViewModel() {
    // 模擬的物品清單
    private val _items = mutableStateOf(
        List(20) { Item(it, "Item ${it + 1}", false) }
    )
    val items = _items

    // 處理物品勾選狀態的變化
    fun toggleItemCheck(index: Int) {
        val updatedItems = _items.value.toMutableList()
        updatedItems[index] = updatedItems[index].copy(isChecked = !updatedItems[index].isChecked)
        _items.value = updatedItems
    }
}