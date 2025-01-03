package com.example.triptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.triptest.ui.feature.baggage.baglist.BAG_NAVIGATION_ROUTE
import com.example.triptest.ui.feature.baggage.baglist.bagListScreenRoute
import com.example.triptest.ui.feature.baggage.itemlist.addItemScreenRoute
import com.example.triptest.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            triptest()
        }
    }
}


@Composable
fun content(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) { }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun triptest(
    navController: NavHostController = rememberNavController()
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "旅帳清單",
                    fontSize = 18.sp,
                )},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = purple200,
                    titleContentColor = white200
                ),
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "back",
                        modifier = Modifier.padding(24.dp,0.dp,0.dp,0.dp)
                    )
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.baseline_delete_24),
                        contentDescription = "delete",
                        modifier = Modifier.padding(0.dp,0.dp,24.dp,0.dp)
                    )
                }
            )



        },
        bottomBar = {
            BottomAppBar(
                contentColor = white200,
            ) {



            }

        }



    ) { innerPadding ->


        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            TripNavHost(navController)
        }
    }
}


@Composable
fun TripNavHost(navController: NavHostController) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        // 初始頁面
        startDestination = BAG_NAVIGATION_ROUTE
    ) {
        // 畫面路徑-ruby
//        spendingListRoute(navController = navController)
//        spendingSetRoute(navController = navController)
//        spendingAddRoute(navController = navController)
//        spendingDepositRoute(navController = navController)
//        Ashley
        bagListScreenRoute(navController = navController)
        addItemScreenRoute(navController = navController)
    }
}



@Preview(showBackground = true)
@Composable
fun triptestPre(){
    triptest()
}







































//package com.example.triptest
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.AddCircle
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Done
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.SnackbarHost
//import androidx.compose.material3.SnackbarHostState
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.material3.rememberTopAppBarState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateMapOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Alignment.Companion.Center
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.triptest.ui.theme.TriptestTheme
//import kotlinx.coroutines.launch
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            TriptestTheme {
//                Main()
//            }
//        }
//    }
//}
//
////TopAppBar、行李箱、floatingActionButton
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Main() {
//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember { SnackbarHostState() }
////下拉選單的狀態
//    val manuExpanded = remember { mutableStateOf(false) }
//    val selectedOption = remember { mutableStateOf("選擇一個行程") }
////下拉選單的選項
//    val options =
//        listOf(
//            "trip 1",
//            "trip 2",
//            "trip 3",
//            "trip 4",
//            "trip 5",
//            "trip 6",
//            "trip 7",
//            "trip 8",
//            "trip 9",
//            "trip 10"
//        )
//
////    版面配置
//    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
////    最上方標題
//        topBar = {
//            Column {
//                CenterAlignedTopAppBar(colors = TopAppBarDefaults.run {
//                    topAppBarColors(
//                        containerColor = colorResource(id = R.color.teal_200),
//                        titleContentColor = colorResource(id = R.color.black),
//                    )
//                }, title = {
//                    Text(text = "我的行李")
//                }, navigationIcon = {
//                    IconButton(onClick = {
//                        scope.launch {
//                            snackbarHostState.showSnackbar(
//                                "回到上一頁", withDismissAction = true
//                            )
//                        }
//                    }) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "back"
//                        )
//                    }
//                },
////                動作按鈕
//                    actions = {
//                        IconButton(onClick = {
//                            scope.launch {
//                                snackbarHostState.showSnackbar(
//                                    "前往我的會員", withDismissAction = true
//                                )
//                            }
//                        }) {
//                            Icon(
//                                imageVector = Icons.Filled.AccountCircle,
//                                contentDescription = "我的會員"
//                            )
//                        }
//                    }, scrollBehavior = scrollBehavior
//                )
//
////                行李箱圖片
//                Box(
//                    modifier = Modifier
//                        .padding(16.dp) // 整個 Box 與外部的間距
//                        .size(225.dp) // 控制背景區域大小
//                        .border( // 添加邊框
//                            width = 4.dp, // 邊框寬度
//                            color = Color.Gray, // 邊框顏色
//                            shape = RoundedCornerShape(50) // 邊框形狀要與背景一致
//                        )
//                        .background(
//                            color = colorResource(id = R.color.white),
//                            shape = RoundedCornerShape(50)
//                        ) // 設定背景樣式
//                        .align(Alignment.CenterHorizontally) // 置中
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.myicon_suitcase_1),
//                        contentDescription = "suitcase Icon",
//                        modifier = Modifier
//                            .padding(16.dp) // 調整圖片與背景的間距
////                            .size(180.dp) // 限制圖片大小，讓背景更顯眼
//                            .align(Alignment.Center), // 確保圖片在背景的正中心
//                        colorFilter = ColorFilter.tint(colorResource(id = R.color.purple_500))
//                    )
//                }
//
////                下拉式選單
//                TripPickDropdown(
//                    options = options,
//                    selectedOption = selectedOption.value,
//                    onOptionSelected = { selectedOption.value = it },
//                    modifier = Modifier
//                        .width(280.dp)
//                        .height(74.dp)
//                        .align(Alignment.CenterHorizontally),
//                )
//            }
//        },
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    scope.launch {
//                        snackbarHostState.showSnackbar(
//                            "跳轉至增加物品頁", withDismissAction = true
//                        )
//                    }
//                },
//            ) {
//                Icon(Icons.Filled.AddCircle, "增加物品")
//            }
//        },
//    ) { innerPadding ->
//        ScrollContent(innerPadding)
//    }
//}
//
//@Composable
//fun TripPickDropdown(
//    options: List<String>,
//    selectedOption: String,
//    onOptionSelected: (String) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val menuExpanded = remember { mutableStateOf(false) }
//
//    Box(
//        modifier = modifier
//            .background(
//                color = Color(0xFFE8DEF8),
//                shape = RoundedCornerShape(
//                    topStart = 30.dp,
//                    topEnd = 30.dp,
//                    bottomStart = if (menuExpanded.value) 0.dp else 30.dp,  // 未展開時圓角，展開後下端無圓角
//                    bottomEnd = if (menuExpanded.value) 0.dp else 30.dp      // 未展開時圓角，展開後下端無圓角
//                )
//            )
//            .border(
//                width = 1.dp,
//                color = Color(0xFF65558F),
//                shape = RoundedCornerShape(
//                    topStart = 30.dp,
//                    topEnd = 30.dp,
//                    bottomStart = if (menuExpanded.value) 0.dp else 30.dp,
//                    bottomEnd = if (menuExpanded.value) 0.dp else 30.dp
//                )
//            )
//            .clickable { menuExpanded.value = true }
//            .padding(1.dp)
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically, // 垂直方向居中
//            horizontalArrangement = Arrangement.SpaceBetween, // 水平方向居中
//            modifier = Modifier
//                .fillMaxSize() // 填滿父容器
//                .padding(horizontal = 16.dp) // 添加適當的水平內邊距
//        ) {
//            Icon(
//                imageVector = Icons.Default.DateRange, // 左側圖標
//                contentDescription = "Trip Icon",
//                tint = Color.Black,
//                modifier = Modifier.size(30.dp)
//            )
//            Box(
//                modifier = Modifier
//                    .weight(1f) // 文本容器占據剩餘空間
//                    .fillMaxHeight(), // 垂直方向填滿
//                contentAlignment = Center // 完全置中
//            ) {
//                Text(
//                    text = selectedOption,
//                    fontSize = 18.sp,
//                    color = Color.Black,
//                    maxLines = 1 // 保證文本不換行
//                )
//            }
//            Icon(
//                painter = painterResource(id = R.drawable.baseline_arrow_drop_down_circle_24), // 右側下拉圖標
//                contentDescription = "Dropdown Icon",
//                tint = Color.Black,
//                modifier = Modifier.size(30.dp)
//            )
//        }
//
//        DropdownMenu(
//            expanded = menuExpanded.value,
//            onDismissRequest = { menuExpanded.value = false },
//            modifier = Modifier
//                .width(280.dp) // 與外層 Box 寬度一致
//                .height(336.dp)
//                .background(
//                    color = Color(0xFFE8DEF8),
//                    shape = RoundedCornerShape(
//                        topStart = 0.dp,
//                        topEnd = 0.dp,
//                        bottomStart = if (menuExpanded.value) 30.dp else 0.dp,  // 未展開時圓角，展開後下端無圓角
//                        bottomEnd = if (menuExpanded.value) 30.dp else 0.dp      // 未展開時圓角，展開後下端無圓角
//                    )
//                )
//                .border(
//                    1.dp, Color(0xFF65558F),
//                    shape = RoundedCornerShape(
//                        topStart = 0.dp,
//                        topEnd = 0.dp,
//                        bottomStart = if (menuExpanded.value) 30.dp else 0.dp,  // 未展開時圓角，展開後下端無圓角
//                        bottomEnd = if (menuExpanded.value) 30.dp else 0.dp      // 未展開時圓角，展開後下端無圓角
//                    )
//                )
//        ) {
//            options.forEach { option ->
//                DropdownMenuItem(
//                    onClick = {
//                        onOptionSelected(option)
//                        menuExpanded.value = false
//                    },
//
//                    text = {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth() // 選單項目寬度填滿
//                                .height(56.dp) // 與外層 Box 高度一致
//                                .background(
//                                    color = Color(100f,100f,100f,0f)
//                                ),
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.Center
//                        ) {
//                            Text(
//                                text = option,
//                                fontSize = 18.sp,
//                                color = Color.Black
//                            )
//                        }
//                    }
//                )
//            }
//        }
//    }
//}
//
//
////物品清單
//@Composable
//fun ScrollContent(innerPadding: PaddingValues) {
////    保存選擇狀態
//    val checkedState = remember { mutableStateMapOf<String, Boolean>() }
//    // 保存是否編輯狀態
//    val isEditing = remember { mutableStateOf(false) }
//    // 物品列表
//    val itemList =
//        remember { mutableStateListOf<String>().apply { addAll((1..25).map { "Item $it" }) } }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(innerPadding)
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(start = 30.dp, end = 30.dp)
//        ) {
//            Text(
//                text = "物品清單", fontSize = 20.sp, modifier = Modifier.weight(1f)
//            )
//            IconButton(onClick = {
//                isEditing.value = !isEditing.value
//            }) {
//                Icon(
//                    imageVector = if (isEditing.value) Icons.Filled.Done else Icons.Filled.Edit,
//                    contentDescription = if (isEditing.value) "完成編輯" else "編輯"
//                )
//            }
//        }
//
////       列表
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(4.dp),
//        ) {
//            items(itemList.size) { index ->
//                val itemName = itemList[index]
//                val isChecked = checkedState[itemName] ?: false //默認未選
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Start,
//                    modifier = Modifier
//                        .border(
//                            width = 1.dp,
//                            color = Color(0x8065558F),
//                            shape = RoundedCornerShape(size = 10.dp)
//                        )
//                        .width(317.dp)
//                        .height(44.dp)
//                        .background(
//                            color = Color(0xFFE8DEF8),
//                            shape = RoundedCornerShape(size = 10.dp)
//                        )
//                        .clickable(enabled = !isEditing.value) { // 非編輯狀態才可打勾
//                            checkedState[itemName] = !isChecked
//                        }
//                        .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
//                ) {
//                    Box(
//                        modifier = Modifier.size(24.dp)
//                    ) {
//
//                        if (isChecked) {
//                            Image(
//                                painter = painterResource(id = R.drawable.baseline_check_circle_24),
//                                contentDescription = "Checked",
//                            )
//                        } else {
//                            Image(
//                                painter = painterResource(id = R.drawable.baseline_check_circle_outline_24),
//                                contentDescription = "Unchecked"
//                            )
//                        }
//                    }
//
//                    Spacer(modifier = Modifier.width(24.dp))
//                    // 物品名稱
//                    Text(
//                        text = itemName,
//                        modifier = Modifier.weight(1f)
//                    )
//                    if (isEditing.value) {
//                        IconButton(onClick = {
//                            itemList.removeAt(index) // 删除物品
//                            checkedState.remove(itemName) // 删除對應的已選狀態
//                        }) {
//                            Icon(
//                                imageVector = Icons.Filled.Delete,
//                                contentDescription = "刪除"
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun Preview(){MainActivity()
//
//}