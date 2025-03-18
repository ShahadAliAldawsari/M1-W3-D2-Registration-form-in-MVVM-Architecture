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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignIn_Screen
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.UserData
import com.example.m1w3d2registrationforminmvvmarchitecture.ViewModel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(modifier:Modifier=Modifier, viewModel:HomeViewModel, navCtrl:NavController){
    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var passConf by remember { mutableStateOf("")}

    val mainColor = Color(0xFF7858C0)
    val darkColor = Color(0xFF432B8A)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top=32.dp, start=16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Screen Title
        Text("Sign Up",
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            color = darkColor
        )

        //Sign up image
        AsyncImage(
            model = "https://t4.ftcdn.net/jpg/05/58/06/81/360_F_558068185_sZmfyrWuzHTfzLdwJuj1ALQcBtbKAtbA.jpg",
            contentDescription = "sign up image",
            modifier = Modifier.fillMaxWidth()
        )

        //the name text field
        TextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Enter Your Name:", color = darkColor)},
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(16.dp))

        //the email text field
        TextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Enter Your Email:", color = darkColor)},
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(16.dp))

        //the password text field
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

        //the confirm password text field
        TextField(
            value = passConf,
            onValueChange = {passConf = it},
            label = {Text("Confirm Your Password:", color = darkColor)},
            modifier = Modifier,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(32.dp))

        //sign up button
        Button(onClick = {
            //1- save data "first it will call the validation fun"
            val saved = viewModel.saveUserData(UserData(name, email, password, passConf))
            //2- if the data valid and saved move to Sign in screen
            if (saved) {
                navCtrl.navigate(SignIn_Screen())
            }
            navCtrl.navigate(SignIn_Screen())
        },
            colors = ButtonDefaults.buttonColors(mainColor)
            ){
            Text("Sign Up")

        }

    }
}
