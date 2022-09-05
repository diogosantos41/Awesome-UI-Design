package com.dscoding.awesomeuidesign.feature_social_media

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme
import com.dscoding.awesomeuidesign.ui.theme.Green
import com.dscoding.awesomeuidesign.ui.theme.GreyDark
import com.dscoding.awesomeuidesign.ui.theme.GreyLight

@Composable
fun SocialMediaScreen() {
    Box(
        Modifier
            .fillMaxHeight()
            .background(GreyLight)
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            AppBar()
            Content()
        }
    }
}

@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(16.dp)
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
fun Content() {
    Column() {
        UsersRecentStoriesList()
    }
}

@Composable
fun UsersRecentStoriesList() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(getSocialMediaUserRecentStories()) { story ->
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
                            Green
                        } else Color.Transparent,
                        shape = CircleShape
                    )
                    .clickable {
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        SocialMediaScreen()
    }
}