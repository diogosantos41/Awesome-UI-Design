package com.dscoding.awesomeuidesign.feature_social_media

import androidx.compose.animation.core.*
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.dscoding.awesomeuidesign.R
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme
import com.dscoding.awesomeuidesign.ui.theme.Coral
import com.dscoding.awesomeuidesign.ui.theme.GreyDark
import com.dscoding.awesomeuidesign.ui.theme.GreyLight
import kotlinx.coroutines.launch

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
            UsersRecentUpdatesList()
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
                painter = painterResource(id = R.drawable.ic_camera),
                modifier = Modifier.size(24.dp),
                contentDescription = "",
                tint = GreyDark
            )
        }
    }
}

@Composable
fun UsersRecentUpdatesList() {
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
                                width = 1.dp,
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
        items(getSocialMediaUsers()) { user ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = user.avatar),
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
                            width = if (user.hasUpdates) {
                                2.dp
                            } else 1.dp,
                            color = if (user.hasUpdates) {
                                Coral
                            } else Color.White,
                            shape = CircleShape
                        )
                        .clickable {
                        }
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = user.username, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun Feed() {
    LazyColumn(modifier = Modifier.padding(horizontal = 15.dp)) {
        items(getSocialMediaFeedPosts()) { post ->
            FeedPost(post)
        }

    }
}

@Composable
fun FeedPost(post: Post) {
    Column(modifier = Modifier
        .padding(vertical = 15.dp)
        .clickable {}) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = post.user.avatar),
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
                Text(text = post.user.username, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(0.dp))
                Text(text = post.title)
            }
            Spacer(modifier = Modifier.weight(1f))
            FollowButton()
        }
        Spacer(modifier = Modifier.height(10.dp))
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(post.image)
                .crossfade(true)
                .build(),
            loading = {
                ShimmerLoadingEffect()
            },
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Composable
fun FollowButton() {
    var scale = remember { Animatable(initialValue = 1f) }
    var isSelected by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isSelected) {
        if (isSelected) {
            launch {
                scale.animateTo(
                    targetValue = 0.4f,
                    animationSpec = tween(durationMillis = 60)
                )
                scale.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    ),
                )
            }
        }
    }

    var color =
        if (isSelected) Coral
        else Coral.copy(alpha = 0.25f)

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .height(35.dp)
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(size = 25.dp)
            )
            .clickable {
                isSelected = !isSelected
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = "Follow",
                style = TextStyle(
                    color = color,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                modifier = Modifier.size(15.dp).scale(scale = scale.value),
                onClick = { isSelected = !isSelected }) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "",
                    tint = color
                )
            }
        }
    }
}

@Composable
fun ShimmerLoadingEffect() {

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(size = 15.dp))
            .fillMaxWidth()
            .height(200.dp)
            .background(brush)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AwesomeUIDesignTheme {
        SocialMediaScreen()
    }
}