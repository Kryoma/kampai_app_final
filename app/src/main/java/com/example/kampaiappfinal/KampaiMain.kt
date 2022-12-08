package com.example.kampaiappfinal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KampaiMain(
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // 変数宣言
        // 国旗
        var nationalFragImage: Painter = painterResource(id = R.drawable.win_20221207_23_24_17_pro)
        // 国名
        var nationalFlagName: String = ""
        // 乾杯の挨拶
        var kampaiLine: String = ""
        // 読み方
        var howRead: String = ""
        // コンテンツの表示有無
        var isShowContents: Boolean by remember { mutableStateOf(false) }

        if (isShowContents) {
            var num: Int = getRandomNumber()
            when (num) {
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
            KampaiContents(
                nationalFlagName,
                nationalFragImage,
                kampaiLine,
                howRead
            )
        } else KampaiContents(
            nationalFlagName = "",
            nationalFragImage = painterResource(id = R.drawable.hatenamark),
            kampaiLine = "",
            howRead = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        isShowContents = DrinkButton()
    }

}

@Composable
fun KampaiContents(
    nationalFlagName: String,
    nationalFragImage: Painter,
    kampaiLine: String,
    howRead: String
) {

    Text(
        text = nationalFlagName,
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold
    )
    Spacer(modifier = Modifier.height(56.dp))
    Image(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(250.dp, 160.dp)
            .border(BorderStroke(3.dp, Color.LightGray)),
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
}

@Composable
fun DrinkButton(): Boolean {
    var isShowContentsFlg by remember { mutableStateOf(false) }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .size(250.dp, 115.dp)
            .clip(RoundedCornerShape(10.dp)),

        onClick = { isShowContentsFlg = !isShowContentsFlg },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        if (isShowContentsFlg) {
            Text(
                text = "Try Again!",
                fontSize = 26.sp
            )
        } else {
            Text(
                text = "Push, bro!",
                fontSize = 26.sp
            )
        }
    }

    return isShowContentsFlg
}
