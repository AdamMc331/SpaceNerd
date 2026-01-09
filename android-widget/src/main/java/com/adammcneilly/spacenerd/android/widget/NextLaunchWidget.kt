package com.adammcneilly.spacenerd.android.widget

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalSize
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.PreviewSizeMode
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.action.actionStartActivity
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
import com.adammcneilly.spacenerd.core.displaymodels.StatusDisplayModel
import com.adammcneilly.spacenerd.core.models.LaunchStatus
import com.adammcneilly.spacenerd.data.launch.api.LaunchListRequest
import com.adammcneilly.spacenerd.data.launch.api.local.LocalLaunchService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.datetime.TimeZone
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NextLaunchWidget :
    GlanceAppWidget(),
    KoinComponent {
    private val localLaunchService: LocalLaunchService by inject()

    override val sizeMode: SizeMode = SizeMode.Exact
    override val previewSizeMode: PreviewSizeMode = SizeMode.Responsive(
        sizes = setOf(
            DpSize(250.dp, 100.dp),
        ),
    )

    private fun observeLaunch(
        context: Context,
    ): Flow<Pair<LaunchDisplayModel, Bitmap?>> {
        // Observe entire launch
        val launchFlow = localLaunchService.getLaunches(LaunchListRequest.Upcoming)
            .filter { launches ->
                launches.isNotEmpty()
            }
            .map { launchList ->
                launchList.first()
            }
            .map { launch ->
                LaunchDisplayModel(
                    launch = launch,
                    timeZone = TimeZone.currentSystemDefault(),
                )
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

        return launchFlow.combine(bitmapFlow) { launch, bitmap ->
            (launch to bitmap)
        }
    }

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId,
    ) {
        observeLaunch(context).collect { (launch, bitmap) ->
            provideContent {
                WidgetContent(
                    launch = launch,
                    launchImageProvider = bitmap?.let(::ImageProvider),
                    context = context,
                )
            }
        }
    }

    override suspend fun providePreview(
        context: Context,
        widgetCategory: Int,
    ) {
        val launch = LaunchDisplayModel(
            id = "123",
            name = "Falcon 9 Block 5 | Starlink Group 15-11",
            image = ImageModel.Placeholder,
            status = StatusDisplayModel(LaunchStatus.Go),
            subtitle = "SpaceX • Vandenberg SFB, CA, USA",
            launchTime = "January 08, 2026 - 00:00:00",
            agency = null,
            mission = null,
            rocket = null,
            launchPad = null,
        )

        val imageProvider = ImageProvider(R.drawable.falcon9)

        provideContent {
            WidgetContent(
                launch = launch,
                launchImageProvider = imageProvider,
                context = context,
            )
        }
    }
}

@Composable
private fun WidgetContent(
    launch: LaunchDisplayModel,
    launchImageProvider: ImageProvider?,
    context: Context,
) {
    val className = "com.adammcneilly.spacenerd.MainActivity"
    val extras = bundleOf(
        "launchId" to launch.id,
    )

    val intent = Intent(context, Class.forName(className)).apply {
        putExtras(extras)
    }

    GlanceTheme {
        Scaffold(
            horizontalPadding = 0.dp,
            modifier = GlanceModifier
                .clickable(
                    onClick = actionStartActivity(intent),
                ),
        ) {
            Row {
                LaunchImage(launchImageProvider)

                LaunchInfo(launch)
            }
        }
    }
}

@Composable
private fun LaunchImage(
    launchImageProvider: ImageProvider?,
) {
    if (launchImageProvider != null) {
        val height = LocalSize.current.height

        Image(
            provider = launchImageProvider,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = GlanceModifier
                .size(height),
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
