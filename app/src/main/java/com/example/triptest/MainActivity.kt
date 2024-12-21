package com.example.triptest

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triptest.ui.theme.TriptestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriptestTheme {
                Main()
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
//下拉選單的狀態
    val expanded = remember { mutableStateOf(false) }
    val selectedOption = remember { mutableStateOf("trip 1") }
//下拉選單的選項
    val options =
        listOf("trip 1", "trip 2", "trip 3,trip 4,trip 5,trip 6,trip 7,trip 8,trip 9,trip 10")

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                CenterAlignedTopAppBar(colors = TopAppBarDefaults.run {
                    topAppBarColors(
                        containerColor = colorResource(id = R.color.teal_200),
                        titleContentColor = colorResource(id = R.color.black),
                    )
                }, title = {
                    Text(text = "我的行李")
                }, navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "回到上一頁", withDismissAction = true
                            )
                        }
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
//                動作按鈕
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "前往我的會員", withDismissAction = true
                                )
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = "我的會員"
                            )
                        }
                    }, scrollBehavior = scrollBehavior
                )
//                行李箱圖片
                Image(
                    painter = painterResource(id = R.mipmap.suitcase_foreground),
                    contentDescription = "suitcase Icon",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(225.dp)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(50)
                        )
                        .align(Alignment.CenterHorizontally)
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "跳轉至增加物品頁", withDismissAction = true
                        )
                    }
                },
            ) {
                Icon(Icons.Filled.AddCircle, "增加物品")
//                Spacer(modifier = Modifier.width(150.dp))
//                Text(
//                    text = "增加物品",
//                    fontSize = 20.sp
//                )
            }
        },
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}


@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val checkedState =
        remember { mutableStateListOf<Boolean>().apply { repeat(25) { add(false) } } }
    val isEditing = remember { mutableStateListOf<Boolean>().apply { repeat(25) { add(false) } } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
        ) {
            Text(
                text = "物品清單",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = {
                val newState = !isEditing.contains(true)
                for (i in isEditing.indices) {
                    isEditing[i] = newState
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "編輯"
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(25) { Number ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0x8065558F),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .width(317.dp)
                        .height(44.dp)
                        .background(
                            color = Color(0xFFE8DEF8),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .clickable { checkedState[Number] = !checkedState[Number] }
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp) // 圖標的大小
                    ) {
                        if (checkedState[Number]) {
                            // 顯示選中的自訂圖標
                            Image(
                                painter = painterResource(id = R.drawable.baseline_check_circle_24),
                                contentDescription = "Checked",
                            )
                        } else {
                            // 顯示未選中的自訂圖標
                            Image(
                                painter = painterResource(id = R.drawable.baseline_check_circle_outline_24),
                                contentDescription = "Unchecked"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
//                Checkbox(
//                    checked = checkedState[Number],
//                    onCheckedChange = { isChecked -> checkedState[Number] = isChecked },
//                    modifier = Modifier.padding(end = 16.dp)
//                )
                    Text(
                        text = "Item ${Number + 1}",
                        modifier = Modifier.weight(1f)
                    )


                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriptestTheme {
        Main()
    }
}