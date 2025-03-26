package com.example.m1w3d2registrationforminmvvmarchitecture.View


import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.OnboardingNav3
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignInScreenNav
import com.example.m1w3d2registrationforminmvvmarchitecture.Model.SignUpScreenNav
import com.example.m1w3d2registrationforminmvvmarchitecture.R
import com.example.m1w3d2registrationforminmvvmarchitecture.ui.theme.darkColor
import com.example.m1w3d2registrationforminmvvmarchitecture.ui.theme.mainColor


@Composable
fun Onboarding(isLast: Boolean, image: Int, title: Int, content: Int, navCtrl: NavController, onNavigation: () -> Unit) {
    Column (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            //only if it's not last onboard screen show the "skip" option
            //I used inner if so the row will hold its place in all cases
            Button(
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.padding(0.dp),
                onClick = {
                    navCtrl.navigate(OnboardingNav3())
                }) {
                Text(
                    text = if (!isLast) stringResource(R.string.skip) else "",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(Modifier.width(128.dp))

            //only if it's not last onboard screen show the "Next" option
            //I used inner if so the row will hold its place in all cases
            Button(
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.padding(0.dp),
                onClick = {
                    onNavigation()
                }) {
                Text(
                    text = if (!isLast) stringResource(R.string.next) else "",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        Spacer(Modifier.height(32.dp))

        //Adding animation for the image
        val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
        val scale by infiniteTransition.animateFloat(
            initialValue = 0.7f,
            targetValue = 0.9f,
            animationSpec = infiniteRepeatable(tween(2000), RepeatMode.Reverse),
            label = "scale"
        )
            Image(
                painter = painterResource(image),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        transformOrigin = TransformOrigin.Center
                    },

                // this line will center crop the image into the available space.
                contentScale = ContentScale.Crop,

                )
//        }
        Spacer(Modifier.height(64.dp))

        //title
        Text(stringResource(title),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(16.dp))
        //content
        Text(stringResource(content),
            modifier = Modifier.padding(horizontal = 32.dp),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(64.dp))

        //if it's last onboard screen
        //I used inner if so the row will hold its place in all cases
        val buttonWidth = 100.dp
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 64.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
        ) {
            if (isLast) {
                //sign up button
                Button(
                    modifier = Modifier
                        .padding(0.dp)
                        .width(buttonWidth),
                    onClick = {navCtrl.navigate(SignUpScreenNav())},
                    colors = ButtonDefaults.buttonColors(mainColor)
                ) {
                    Text(stringResource(R.string.sign_up))

                }

                Spacer(Modifier.width(100.dp))

                //log in button
                Button(
                    modifier = Modifier
                        .padding(0.dp)
                        .width(buttonWidth),
                    onClick = { navCtrl.navigate(SignInScreenNav()) },
                    colors = ButtonDefaults.buttonColors(darkColor)
                ) {
                    Text(stringResource(R.string.log_in))

                }
            }
        }
    }

}