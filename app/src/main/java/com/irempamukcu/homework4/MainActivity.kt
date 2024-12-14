package com.irempamukcu.homework4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.irempamukcu.homework4.ui.theme.Homework4Theme
import com.irempamukcu.homework4.ui.theme.MainColor2
import com.irempamukcu.homework4.ui.theme.MainColor3
import com.irempamukcu.homework4.ui.theme.MainColorDark2
import com.irempamukcu.homework4.ui.theme.TextColor1
import com.irempamukcu.homework4.ui.theme.TextColor1Dark
import com.irempamukcu.homework4.ui.theme.TextColor2
import com.irempamukcu.homework4.ui.theme.TextColor2Dark
import com.irempamukcu.homework4.ui.theme.delius
import com.irempamukcu.homework4.ui.theme.indie

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homework4Theme {
                MainPage()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(darkTheme: Boolean = isSystemInDarkTheme()){

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(stringResource(R.string.app_name),
                    fontFamily = indie,
                    fontWeight = FontWeight.Bold,
                    fontSize = (screenWidth/12).sp)
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = if(darkTheme) MainColorDark2 else MainColor2,
                titleContentColor = if(darkTheme) TextColor1Dark else TextColor1,
            )
        )
    }){paddingValues->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start) {

            Text(stringResource(R.string.daily_meditation),
                color = if(darkTheme) TextColor1Dark else TextColor1,
                fontFamily = delius,
                fontSize = (screenWidth/13).sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
                )

            Image(painter = painterResource(R.drawable.daily),
                contentDescription = stringResource(R.string.daily_meditation_picture),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp)),


                )

            Text(stringResource(R.string.explore_moods),
                color = if(darkTheme) TextColor1Dark else TextColor1,
                fontFamily = delius,
                fontSize = (screenWidth/13).sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
            )


            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Moods(stringResource(R.string.suggestion))
                Moods(stringResource(R.string.calm))
                Moods(stringResource(R.string.sleepy))
                Moods(stringResource(R.string.nature))

            }

            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                ReusableImageBox(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(25.dp)),
                    imageResource = R.drawable.excited,
                    contentDescription = "Excited Meditation Picture",
                    text = stringResource(R.string.areYouExcited)
                )
                ReusableImageBox(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(25.dp)),
                    imageResource = R.drawable.stressful,
                    contentDescription = "Stress Meditation Picture",
                    text = stringResource(R.string.stressfulRight)
                )

            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(darkTheme) TextColor2Dark else MainColor3,
                    contentColor =  TextColor2
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 16.dp)
            ) {
                Text(
                    stringResource(R.string.explore),
                    fontSize = (screenWidth/15).sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = delius
                )
            }



        }

    }
}

@Composable
fun ReusableImageBox(
    modifier: Modifier = Modifier,
    imageResource: Int,
    contentDescription: String,
    text: String
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()


        )
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 12.dp),
            color = TextColor2,
            fontWeight = FontWeight.Bold,
            fontSize = (screenWidth/17).sp,
            fontFamily = delius
        )
    }
}


@Composable
fun Moods(text: String, darkTheme: Boolean = isSystemInDarkTheme()){

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp


    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if(darkTheme) TextColor2Dark else MainColor2,
            contentColor = if(darkTheme) TextColor1Dark else TextColor1
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)

    ) {
        Text(text,
            fontSize = (screenWidth/25).sp,
            fontWeight = FontWeight.Bold,
            fontFamily = delius
        )
    }
}


@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    MainPage()
}