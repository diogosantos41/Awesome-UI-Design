package com.dscoding.awesomeuidesign.feature_social_media

import com.dscoding.awesomeuidesign.R

data class UserRecentStories(
    var username: String,
    var avatar: Int,
    var hasUpdates: Boolean
)


fun getSocialMediaUserRecentStories(): List<UserRecentStories> {
    val stories = mutableListOf<UserRecentStories>()
    stories.add(UserRecentStories("Jane", R.drawable.ic_user, true))
    stories.add(UserRecentStories("John", R.drawable.ic_user, true))
    stories.add(UserRecentStories("George", R.drawable.ic_user, false))
    stories.add(UserRecentStories("Matt", R.drawable.ic_user, false))
    stories.add(UserRecentStories("James", R.drawable.ic_user, false))
    stories.add(UserRecentStories("Lily", R.drawable.ic_user, false))
    stories.add(UserRecentStories("Harry", R.drawable.ic_user, false))
    return stories
}