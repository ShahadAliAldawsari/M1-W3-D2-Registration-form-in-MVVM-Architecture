package com.example.m1w3d2registrationforminmvvmarchitecture.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignUp_Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(modifier: Modifier=Modifier, viewModel: ViewModel, navCtrl:NavController){
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}

    val mainColor = Color(0xFF5B48D7)
    val darkColor = Color(0xFF392B70)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top=32.dp, start=16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Sign In",
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            color = mainColor
        )
        Spacer(Modifier.height(32.dp))

        AsyncImage(
            model = "https://thumbs.dreamstime.com/b/online-registration-sign-up-concept-young-man-signing-login-to-account-smartphone-app-user-interface-secure-password-194944772.jpg",
            contentDescription = "sign up image",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(32.dp))

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Enter Your Email:", color = darkColor)},
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Enter Your Password:", color = darkColor)},
            modifier = Modifier,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(16.dp))

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(mainColor)
        ){
            Text("Sign In")

        }

        Spacer(Modifier.height(16.dp))

        TextButton(onClick = {
            navCtrl.navigate(SignUp_Screen)
        },
            modifier=Modifier,
            colors = ButtonDefaults.buttonColors(Color.Transparent),
        ){
            Text("Is this your first time hear?", color = darkColor, fontSize = 12.sp)
            Text("Sign up", color = mainColor, fontSize = 16.sp)

        }

    }
}
