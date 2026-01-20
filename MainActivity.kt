package com.khotornak.guard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KhotornakTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text("KHOTORNAK SHIELD v2.0", color = Color.Cyan, style = MaterialTheme.typography.headlineMedium)
                        Spacer(modifier = Modifier.height(20.dp))
                        
                        // রিয়েল টাইম স্ট্যাটাস কার্ড
                        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("DNS: AdGuard Active", color = Color.Green)
                                Text("Blocked Ads: 1,245", color = Color.White)
                                Text("Data Saved: 45 MB", color = Color.Yellow)
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(
                            onClick = { /* Start VPN Service Logic */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("ACTIVATE KILLER MODE", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
