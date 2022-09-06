package com.dscoding.awesomeuidesign.feature_social_media

import com.dscoding.awesomeuidesign.R

data class UserRecentStory(
    var username: String,
    var avatar: Int,
    var hasUpdates: Boolean
)


fun getSocialMediaUserRecentStories(): List<UserRecentStory> {
    val stories = mutableListOf<UserRecentStory>()
    stories.add(UserRecentStory("Jane", R.drawable.ic_user, true))
    stories.add(UserRecentStory("John", R.drawable.ic_user, true))
    stories.add(UserRecentStory("George", R.drawable.ic_user, false))
    stories.add(UserRecentStory("Matt", R.drawable.ic_user, false))
    stories.add(UserRecentStory("James", R.drawable.ic_user, false))
    stories.add(UserRecentStory("Lily", R.drawable.ic_user, false))
    stories.add(UserRecentStory("Harry", R.drawable.ic_user, false))
    return stories
}