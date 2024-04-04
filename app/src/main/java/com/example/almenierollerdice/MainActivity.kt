package com.example.almenierollerdice

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.almenierollerdice.ui.theme.AlmenieRollerDiceTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlmenieRollerDiceTheme {
               DiceRollerApp()


        }
    }
}



@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
  DiceWithButtonAndImage(modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  )
}
    @Composable
    fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
        var result by remember{ mutableStateOf(1) }
        val imageResource = when (result) {
            1 -> R.drawable.rollerdice1
            2 -> R.drawable.rollerdice2
            3 -> R.drawable.rollerdice3
            4 -> R.drawable.rollerdice4
            5 -> R.drawable.rollerdice5
            else -> R.drawable.rollerdice6
        }

     Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString()

            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { result = (1..6).random() }){
                Text(stringResource(R.string.roll))
            }
        }
    }




}