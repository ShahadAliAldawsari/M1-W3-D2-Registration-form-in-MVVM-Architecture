package com.example.m1w3d2registrationforminmvvmarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignIn_Screen
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignUp_Screen
import com.example.m1w3d2registrationforminmvvmarchitecture.View.SignInScreen
import com.example.m1w3d2registrationforminmvvmarchitecture.View.SignUpScreen
import com.example.m1w3d2registrationforminmvvmarchitecture.ViewModel.HomeViewModel
import com.example.m1w3d2registrationforminmvvmarchitecture.ui.theme.M1W3D2RegistrationFormInMVVMArchitectureTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // The tutorial_1 MVVM: https://www.youtube.com/watch?v=9eIhMFTs1Q8
        // The tutorial_2 Navigation: https://www.youtube.com/watch?v=AIC_OFQ1r3k

        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
        setContent {
            M1W3D2RegistrationFormInMVVMArchitectureTheme {
                val navCtrl = rememberNavController()
                NavHost(
                    navController = navCtrl,
                    startDestination = SignUp_Screen
                ) {
                    composable<SignUp_Screen> {
                        SignUpScreen(modifier = Modifier, homeViewModel, navCtrl)
                    }

                    composable<SignIn_Screen> {
                        SignInScreen(modifier = Modifier, homeViewModel, navCtrl)
                    }
                }
            }
        }
    }
}

