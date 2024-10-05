package com.ungdungmumau


import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

val commonTextStyle = TextStyle(
    shadow = Shadow(
        color = Color.Gray,
        offset = Offset(4f, 10f),
        blurRadius = 8f
    )
)

private fun DrawScope.drawShadow() {

    val shadowColor = Color.LightGray
    val offsetX = 4f
    val offsetY = 8f



    withTransform({
        translate(offsetX, offsetY)
    }) {
        drawRoundRect(
            color = shadowColor,
            alpha = 0.5f
        )
    }
}

@Composable
fun BackgroundLogin() {
    Image(
        painter = painterResource(id = R.drawable.backgroundlogin),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun LoginForm() {
    Column(
        modifier = Modifier
            .offset(x = 38.dp, y = 211.dp)
            .size(width = 284.dp, height = 402.dp)
    ) {
        TitleLogin()
        Spacer(modifier = Modifier.size(70.dp))
        UsernameForm()
        Spacer(modifier = Modifier.size(16.dp))
        PasswordForm()
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            LoginButton()
        }


    }

}

@Composable
fun TitleLogin() {
    Column(

    ) {
        Text(
            text = "Login",
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.DarkGray,
                    offset = Offset(4f, 10f),
                    blurRadius = 8f
                )
            )
        )
        Text(
            text = "Please login to continue",
            color = Color(0xFF777777),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = commonTextStyle
        )
    }
}

@Composable
fun UsernameForm() {
    Column(
    ) {
        Text(
            text = "Email:",
            color = Color(0xFF575555),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            style = commonTextStyle

        )
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = "dungtapcode@gmail.com",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = null,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawShadow()
                }
                .background(color = Color.White),

            )

    }
}


@Composable
fun PasswordForm() {
    Column(
    ) {
        Text(
            text = "Password:",
            color = Color(0xFF575555),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            style = commonTextStyle
        )
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = "chaotatcamoinguoi",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawShadow()
                }
                .background(color = Color.White),
            visualTransformation = PasswordVisualTransformation(),
        )

    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
           containerColor = Color.Transparent,
        ),
        contentPadding = PaddingValues(),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 0.dp)
        )


     {
        Box(
            modifier = Modifier.size(100.dp,34.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFFEB80),
                            Color(0xFFFF9F0E),
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp) ,
            contentAlignment = Alignment.Center
                )

        {
        Text(
            text = "Login",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }

}
}



