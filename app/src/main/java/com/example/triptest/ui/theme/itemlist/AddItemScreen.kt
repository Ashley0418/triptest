package com.example.triptest.ui.feature.baggage.itemlist

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.triptest.ui.feature.baggage.baglist.BagListScreen

@Composable
fun AddItemRoute(navController: NavHostController) {
    AddItemScreen(navController)
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun AddItemScreen(navController: NavHostController) {
    var itemName = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("新增物品") },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "回到上一頁")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
        ) {
            Text("輸入物品名稱")
            TextField(
                value = itemName.value,
                onValueChange = { itemName.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("物品名稱") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // 在這裡可以處理新增物品的邏輯
                navController.popBackStack()  // 返回上一頁
            }) {
                Text("新增物品")
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddItemScreen() {
    AddItemScreen(navController = NavHostController(LocalContext.current))
}