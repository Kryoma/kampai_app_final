package com.example.kampaiappfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kampaiappfinal.ui.theme.KampaiAppFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KampaiAppFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "日本",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(56.dp))
        Image(
            modifier = Modifier
                .size(250.dp, 160.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    BorderStroke(1.dp, Color.Black)
                ),
            painter = painterResource(R.drawable._00px_flag_of_japan_jpg),
            contentDescription = "国旗"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "乾杯",
            fontSize = 50.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "kampai",
            fontSize = 16.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp, 115.dp)
                .clip(RoundedCornerShape(10.dp)),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            )
        )
        {
            Text(
                text = "飲む",
                fontSize = 26.sp
            )
        }
    }
}
