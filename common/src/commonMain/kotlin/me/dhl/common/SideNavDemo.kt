package me.dhl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SideNavDemo() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("WanAndroid") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent()
        },
        content = {
            MainContent()
        }
    )
}

@Composable
fun DrawerContent() {
    Column(modifier = Modifier
        .width(100.dp)) {
        Text(text = "Item 1", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
        Text(text = "Item 2", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
        Text(text = "Item 3", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun MainContent() {
    Column {
        Text("Hello, World!")
    }
}
