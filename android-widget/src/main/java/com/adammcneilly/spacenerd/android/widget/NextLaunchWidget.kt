package com.adammcneilly.spacenerd.android.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextDefaults
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NextLaunchWidget : GlanceAppWidget(), KoinComponent {

    private val localLaunchService: LocalLaunchService by inject()

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        localLaunchService.getLaunches(LaunchListRequest.Upcoming)
            .filter { launches ->
                launches.isNotEmpty()
            }
            .map { launchList ->
                launchList.first()
            }
            .map { launch ->
                LaunchDisplayModel(launch)
            }.collect { launch ->
                provideContent {
                    WidgetContent(launch)
                }
            }
    }
}

@Composable
private fun WidgetContent(
    launch: LaunchDisplayModel,
) {
    GlanceTheme {
        Scaffold {
            Row {
                // Image

                LaunchInfo(launch)
            }
        }
    }
}

@Composable
private fun LaunchInfo(
    launch: LaunchDisplayModel,
) {
    Column {
        Text(
            text = launch.name,
            style = TextDefaults.defaultTextStyle.copy(
                color = GlanceTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            ),
        )

        Text(
            text = launch.subtitle,
            style = TextDefaults.defaultTextStyle.copy(
                color = GlanceTheme.colors.primary,
                fontSize = 12.sp,
            ),
            modifier = GlanceModifier
                .padding(top = 4.dp),
        )
    }
}
