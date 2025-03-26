package com.example.m1w3d2registrationforminmvvmarchitecture.View

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignInScreenNav
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.UserData
import com.example.m1w3d2registrationforminmvvmarchitecture.R
import com.example.m1w3d2registrationforminmvvmarchitecture.ViewModel.HomeViewModel
import com.example.m1w3d2registrationforminmvvmarchitecture.ui.theme.darkColor
import com.example.m1w3d2registrationforminmvvmarchitecture.ui.theme.mainColor



@Composable
fun SignUpScreen(viewModel:HomeViewModel, navCtrl:NavController){
    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var passConf by remember { mutableStateOf("")}


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top=32.dp, start=16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Screen Title
        Text(stringResource(R.string.sign_up_heading),
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            color = darkColor
        )

        //Adding animation for the image
        val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
        val scale by infiniteTransition.animateFloat(
            initialValue = 0.7f,
            targetValue = 0.9f,
            animationSpec = infiniteRepeatable(tween(2000), RepeatMode.Reverse),
            label = "scale"
        )
        //Sign up image
        AsyncImage(
            model = "https://t4.ftcdn.net/jpg/05/58/06/81/360_F_558068185_sZmfyrWuzHTfzLdwJuj1ALQcBtbKAtbA.jpg",
            contentDescription = "sign up image",
            modifier = Modifier.fillMaxWidth()
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = TransformOrigin.Center },


            )

        //the name text field
        TextField(
            value = name,
            onValueChange = {name = it},
            label = {Text(stringResource(R.string.name), color = darkColor)},
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(16.dp))

        //the email text field
        TextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(stringResource(R.string.your_email), color = darkColor)},
            modifier = Modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(mainColor)
        )
        Spacer(Modifier.height(16.dp))

        //the password text field
        TextField(
            value = password,
            onValueChange = {password = it},
            label = {Text(stringResource(R.string.password), color = darkColor)},
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
            label = {Text(stringResource(R.string.create_account), color = darkColor)},
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
                navCtrl.navigate(SignInScreenNav)
            }
            navCtrl.navigate(SignInScreenNav)
        },
            colors = ButtonDefaults.buttonColors(mainColor)
            ){
            Text(stringResource(R.string.sign_up))

        }
    }
}
