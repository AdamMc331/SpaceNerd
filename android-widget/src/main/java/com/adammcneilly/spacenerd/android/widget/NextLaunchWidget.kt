package com.adammcneilly.spacenerd.android.widget

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column
import androidx.glance.layout.ContentScale
import androidx.glance.layout.Row
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextDefaults
import coil3.imageLoader
import coil3.request.ImageRequest
import coil3.toBitmap
import com.adammcneilly.spacenerd.core.designsystem.models.ImageModel
import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NextLaunchWidget : GlanceAppWidget(), KoinComponent {

    private val localLaunchService: LocalLaunchService by inject()

    override val sizeMode: SizeMode = SizeMode.Exact

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        // Observe entire launch
        val launchFlow = localLaunchService.getLaunches(LaunchListRequest.Upcoming)
            .filter { launches ->
                launches.isNotEmpty()
            }
            .map { launchList ->
                launchList.first()
            }
            .map { launch ->
                LaunchDisplayModel(launch)
            }

        // Observe and download image
        val bitmapFlow = launchFlow
            .map { launch ->
                launch.image
            }
            .distinctUntilChanged()
            .map { imageModel ->
                if (imageModel is ImageModel.Remote) {
                    val request = ImageRequest.Builder(context)
                        .data(imageModel.url)
                        .build()

                    context.imageLoader.execute(request).image?.toBitmap()
                } else {
                    null
                }
            }

        launchFlow.combine(bitmapFlow) { launch, bitmap ->
            (launch to bitmap)
        }.collect { (launch, bitmap) ->
            provideContent {
                WidgetContent(launch, bitmap)
            }
        }
    }
}

@Composable
private fun WidgetContent(
    launch: LaunchDisplayModel,
    launchImage: Bitmap?,
) {
    GlanceTheme {
        Scaffold(
            horizontalPadding = 0.dp,
        ) {
            Row {
                LaunchImage(launchImage)

                LaunchInfo(launch)
            }
        }
    }
}

@Composable
private fun LaunchImage(
    launchImage: Bitmap?
) {
    if (launchImage != null) {
        val height = LocalSize.current.height

        Image(
            provider = ImageProvider(launchImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = GlanceModifier
                .size(height)
        )
    }
}

@Composable
private fun LaunchInfo(
    launch: LaunchDisplayModel,
) {
    Column(
        modifier = GlanceModifier
            .padding(12.dp),
    ) {
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
