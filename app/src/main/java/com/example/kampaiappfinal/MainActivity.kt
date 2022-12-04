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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    // 変数宣言
    // 国旗
    var nationalFragImage: Painter
    // 国名
    var nationalFlagName: String
    // 乾杯の挨拶
    var kampaiLine: String
    // 読み方
    var howRead: String

    val num: Int = RandomActivity()
    when(num){
        // 日本
        1 -> {
            nationalFragImage = painterResource(id = R.drawable.japan)
            nationalFlagName = stringResource(id = R.string.national_flag_name_japan)
            kampaiLine = stringResource(id = R.string.kampai_line_japan)
            howRead = stringResource(id = R.string.how_read_japan)
        }
        // 韓国
        2 -> {
            nationalFragImage = painterResource(id = R.drawable.korea)
            nationalFlagName = stringResource(id = R.string.national_flag_name_korea)
            kampaiLine = stringResource(id = R.string.kampai_line_korea)
            howRead = stringResource(id = R.string.how_read_korea)
        }
        // アメリカ
        3 -> {
            nationalFragImage = painterResource(id = R.drawable.usa)
            nationalFlagName = stringResource(id = R.string.national_flag_name_america)
            kampaiLine = stringResource(id = R.string.kampai_line_america)
            howRead = stringResource(id = R.string.how_read_america)
        }
        //タイ
        4 -> {
            nationalFragImage = painterResource(id = R.drawable.thai)
            nationalFlagName = stringResource(id = R.string.national_flag_name_thai)
            kampaiLine = stringResource(id = R.string.kampai_line_thai)
            howRead = stringResource(id = R.string.how_read_thai)

        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = nationalFlagName,
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
            painter = nationalFragImage,
            contentDescription = "National Frag"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = kampaiLine,
            fontSize = 50.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = howRead,
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
