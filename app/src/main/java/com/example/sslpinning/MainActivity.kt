package com.example.sslpinning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sslpinning.ui.MainViewModel
import com.example.sslpinning.ui.theme.SSLPinningTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSLPinningTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val user = viewModel.user.collectAsState().value
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(user.name)
                        Spacer(modifier = Modifier.padding(30.dp))
                        Button(modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp), onClick = { viewModel.getUser() }) {
                            Text("Click")
                        }
                    }
                }
            }
        }
    }
}
