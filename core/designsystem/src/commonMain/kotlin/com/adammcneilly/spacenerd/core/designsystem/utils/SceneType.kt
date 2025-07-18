package com.adammcneilly.spacenerd.core.designsystem.utils

import androidx.compose.runtime.compositionLocalOf

val LocalSceneType = compositionLocalOf {
    SceneType.Single
}

enum class SceneType {
    Single,
    TwoPane,
}
