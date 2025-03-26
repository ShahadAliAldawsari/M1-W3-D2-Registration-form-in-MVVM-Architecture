package com.example.m1w3d2registrationforminmvvmarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.OnboardingNav1
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.OnboardingNav2
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.OnboardingNav3
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignInScreenNav
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignUpScreenNav
import com.example.m1w3d2registrationforminmvvmarchitecture.View.Onboarding
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
//                Onboarding(
//                            isLast = false,
//                            image = R.drawable.online_discussion,
//                            title = R.string.numerous_free_trial_courses,
//                            content = R.string.free_courses_message,
//                            navCtrl = navCtrl,
//                        )
//                Onboarding(
//                            isLast = false,
//                            image = R.drawable.best_teacher,
//                            title = R.string.quick_easy_learning,
//                            content = R.string.easy_fast_learning,
//                            navCtrl = navCtrl,
//                        )
//                Onboarding(
//                            isLast = true,
//                            image = R.drawable.startup,
//                            title = R.string.create_study_plan,
//                            content = R.string.create_account,
//                            navCtrl = navCtrl,
//                        )
                NavHost(
                    navController = navCtrl,
                    startDestination = OnboardingNav1
                ) {

                    composable<OnboardingNav1>{
                        Onboarding(
                            isLast = false,
                            image = R.drawable.online_discussion,
                            title = R.string.numerous_free_trial_courses,
                            content = R.string.free_courses_message,
                            navCtrl = navCtrl,
                            onNavigation = {navCtrl.navigate(OnboardingNav2())},
                        )
                    }
                    composable<OnboardingNav2>{
                        Onboarding(
                            isLast = false,
                            image = R.drawable.best_teacher,
                            title = R.string.quick_easy_learning,
                            content = R.string.easy_fast_learning,
                            navCtrl = navCtrl,
                            onNavigation = {navCtrl.navigate(OnboardingNav3())}
                        )
                    }
                    composable<OnboardingNav3>{
                        Onboarding(
                            isLast = true,
                            image = R.drawable.startup,
                            title = R.string.create_study_plan,
                            content = R.string.create_account,
                            navCtrl = navCtrl,
                            onNavigation = {navCtrl.navigate(SignInScreenNav())},
                        )
                    }

                    composable<SignInScreenNav> {
                        SignInScreen(navCtrl)
                    }

                    composable<SignUpScreenNav> {
                        SignUpScreen(viewModel = homeViewModel, navCtrl = navCtrl)
                    }
                }
            }
        }
    }
}

