package com.example.triptest.ui.feature.baggage.baglist

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BagListViewModel : ViewModel() {
    // 行程選擇相關
    val selectedTrip = mutableStateOf("選擇一個行程")
    val tripOptions = listOf(
        "trip 1", "trip 2", "trip 3", "trip 4", "trip 5",
        "trip 6", "trip 7", "trip 8", "trip 9", "trip 10"
    )

    // 行李清單相關
    val itemList = mutableStateListOf<String>().apply {
        addAll((1..25).map { "Item $it" })
    }
    val checkedState = mutableStateMapOf<String, Boolean>()
    val isEditing = mutableStateOf(false)

    // 選擇行程
    fun selectTrip(trip: String) {
        selectedTrip.value = trip
    }

    // 添加新物品
    fun addItem(item: String) {
        itemList.add(item)
    }

    // 刪除物品
    fun removeItem(item: String) {
        itemList.remove(item)
        checkedState.remove(item)
    }

    // 切換編輯模式
    fun toggleEditing() {
        isEditing.value = !isEditing.value
    }

    // 標記/取消標記物品
    fun toggleItemChecked(item: String) {
        checkedState[item] = !(checkedState[item] ?: false)
    }
}
