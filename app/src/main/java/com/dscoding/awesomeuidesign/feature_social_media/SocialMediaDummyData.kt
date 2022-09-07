package com.dscoding.awesomeuidesign.feature_social_media

import com.dscoding.awesomeuidesign.R

data class SocialMediaUser(
    var username: String,
    var avatar: Int,
    var hasUpdates: Boolean
)


fun getSocialMediaUsers(): List<SocialMediaUser> {
    val users = mutableListOf<SocialMediaUser>()
    users.add(SocialMediaUser("Jane", R.drawable.ic_user_1, true))
    users.add(SocialMediaUser("John", R.drawable.ic_user_2, true))
    users.add(SocialMediaUser("George", R.drawable.ic_user_3, false))
    users.add(SocialMediaUser("Matt", R.drawable.ic_user_4, false))
    users.add(SocialMediaUser("James", R.drawable.ic_user_5, false))
    users.add(SocialMediaUser("Lily", R.drawable.ic_user_6, false))
    users.add(SocialMediaUser("Harry", R.drawable.ic_user_1, false))
    return users
}

data class Post(
    var title: String,
    var user: SocialMediaUser,
    var image: String
)


fun getSocialMediaFeedPosts(): List<Post> {
    val posts = mutableListOf<Post>()
    posts.add(
        Post(
            title = "By the lake!",
            user = getSocialMediaUsers()[0],
            image = "https://images.unsplash.com/photo-1558637845-c8b7ead71a3e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80"
        )
    )
    posts.add(
        Post(
            title = "Amazing landscape",
            user = getSocialMediaUsers()[1],
            image = "https://images.unsplash.com/photo-1633494973781-1933ea22db0f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
        )
    )
    posts.add(
        Post(
            title = "Road to heaven",
            user = getSocialMediaUsers()[2],
            image = "https://images.unsplash.com/photo-1594568284297-7c64464062b1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
        )
    )
    posts.add(
        Post(
            title = "City",
            user = getSocialMediaUsers()[3],
            image = "https://images.unsplash.com/photo-1599454100789-b211e369bd04?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1306&q=80"
        )
    )
    return posts
}