package com.adammcneilly.spacenerd.domain.usecases

import com.adammcneilly.spacenerd.core.displaymodels.LaunchDisplayModel
import com.adammcneilly.spacenerd.data.DataResult
import com.adammcneilly.spacenerd.data.models.LaunchListRequest
import com.adammcneilly.spacenerd.data.repositories.LaunchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor(
    private val repository: LaunchRepository,
) {
    fun invoke(
        request: LaunchListRequest,
    ): Flow<DataResult<List<LaunchDisplayModel>>> {
        return repository.getLaunches(request).map { launchesResult ->
            launchesResult.map { launches ->
                launches.map(::LaunchDisplayModel)
            }
        }
    }
}
