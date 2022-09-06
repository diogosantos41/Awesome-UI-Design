package com.dscoding.awesomeuidesign.feature_social_media

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscoding.awesomeuidesign.R
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme
import com.dscoding.awesomeuidesign.ui.theme.Coral
import com.dscoding.awesomeuidesign.ui.theme.GreyDark
import com.dscoding.awesomeuidesign.ui.theme.GreyLight

@Composable
fun SocialMediaScreen() {
    Column(
        Modifier
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Column(
            Modifier
                .background(GreyLight)
                .padding(bottom = 15.dp)
        ) {
            AppBar()
            UsersRecentStoriesList()
        }
        Feed()
    }
}

@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(
                start = 16.dp,
                top = 16.dp,
                bottom = 16.dp,
                end = 8.dp
            )
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search Users, Posts, etc.", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = GreyDark
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.Phone,
                contentDescription = "",
                tint = GreyDark
            )
        }
    }
}

@Composable
fun UsersRecentStoriesList() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row {
                Spacer(modifier = Modifier.width(16.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Coral),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = Color.Gray,
                                shape = CircleShape
                            )
                            .clickable {
                            }
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "New", fontSize = 13.sp)
                }
            }
        }
        items(getSocialMediaUserRecentStories()) { story ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = story.avatar),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .shadow(
                            10.dp,
                            CircleShape
                        )
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = if (story.hasUpdates) {
                                Coral
                            } else Color.Gray,
                            shape = CircleShape
                        )
                        .clickable {
                        }
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = story.username, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun Feed() {
    LazyColumn(modifier = Modifier.padding(horizontal = 15.dp)) {
        item {
            FeedPost()
        }
        item {
            FeedPost()
        }
        item {
            FeedPost()
        }
    }
}

@Composable
fun FeedPost() {
    Column(modifier = Modifier.padding(vertical = 15.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .shadow(
                        10.dp,
                        CircleShape
                    )
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = "Jane", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(0.dp))
                Text(text = "A single image")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Follow")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        SocialMediaScreen()
    }
}