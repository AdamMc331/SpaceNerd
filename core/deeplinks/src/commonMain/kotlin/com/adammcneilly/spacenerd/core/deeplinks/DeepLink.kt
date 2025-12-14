package com.adammcneilly.spacenerd.core.deeplinks

sealed interface DeepLink {
    data class LaunchDetail(
        val launchId: String,
    ) : DeepLink
}
