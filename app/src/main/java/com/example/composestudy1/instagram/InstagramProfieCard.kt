package com.example.composestudy1.instagram

import android.util.Log
import android.view.View.OnClickListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composestudy1.R


@Composable
@Preview
fun PreviewCard(){
}

@Composable
fun InstagramProfileCard(
    model: InstagramModel,
    onFollowedButtonClickListener: (InstagramModel) -> Unit
) {


    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_foreground),
                    null,
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Cyan)
                )
                UserStatistics(title = "Post", value = "6950")
                UserStatistics(title = "Followers", value = "222")
                UserStatistics(title = "Following", value = "69450")
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Instagram ${model.id}",
                    fontSize = 32.sp,
                    fontFamily = FontFamily.Cursive
                )
                Text(
                    text = "#YoursToMake${model.title}",
                    fontSize = 14.sp
                )
                Text(
                    text = "www.facebook.com/emotional_health",
                    fontSize = 14.sp
                )

                FollowButton(isFollowed = model.isFollowed) {
                    onFollowedButtonClickListener(model)
                }
            }
        }
    }
}

@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Log.d("RECOMPOSITION", "FollowButton")
    Button(
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) {
                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colorScheme.primary
            }
        )
    ) {
        val text = if (isFollowed) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(text = text)
    }
}


@Composable
private fun UserStatistics(title: String, value: String) {
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = value,
            fontSize = 24.sp
        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}
