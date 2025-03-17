package com.example.m1w3d2registrationforminmvvmarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.m1w3d2registrationforminmvvmarchitecture.View.SignUpScreen
import com.example.m1w3d2registrationforminmvvmarchitecture.ui.theme.M1W3D2RegistrationFormInMVVMArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M1W3D2RegistrationFormInMVVMArchitectureTheme {
//                Scaffold(modifier = Modifier.fillMaxSize())
//                { innerPadding ->
//
//                }
                SignUpScreen()
            }
        }
    }
}