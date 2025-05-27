package com.adammcneilly.spacenerd.data.thespacedevs

import com.adammcneilly.spacenerd.core.models.Launch
import com.adammcneilly.spacenerd.data.DataResult
import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
import com.adammcneilly.spacenerd.data.thespacedevs.dto.TSDLaunchDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TSDLaunchRepository @Inject constructor(
    private val api: TSDRetrofitAPI,
) : LaunchRepository {
    @Suppress("TooGenericExceptionCaught")
    override fun getLaunches(
        request: LaunchListRequest,
    ): Flow<DataResult<List<Launch>>> {
        return flow {
            emit(DataResult.Loading)

            try {
                val launches = api
                    .getLaunches(
                        slug = request.slug,
                        before = request.before?.toString(),
                        after = request.after?.toString(),
                    )
                    .results
                    ?.map(TSDLaunchDTO::toLaunch)
                    .orEmpty()

                emit(DataResult.Success(launches))
            } catch (e: Exception) {
                emit(DataResult.Error(e))
            }
        }
    }
}
