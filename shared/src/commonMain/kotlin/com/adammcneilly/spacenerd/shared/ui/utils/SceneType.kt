package com.adammcneilly.spacenerd.shared.ui.utils

import androidx.compose.runtime.compositionLocalOf

val LocalSceneType = compositionLocalOf {
    SceneType.Single
}

enum class SceneType {
    Single,
    TwoPane,
}
