package com.adammcneilly.spacenerd.shared.data.launch

import kotlinx.datetime.Instant

data class LaunchListRequest(
    val before: Instant?,
    val after: Instant?,
)
