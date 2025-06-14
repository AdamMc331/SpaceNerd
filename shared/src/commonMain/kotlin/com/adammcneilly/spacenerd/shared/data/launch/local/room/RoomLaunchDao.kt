package com.adammcneilly.spacenerd.shared.data.launch.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.adammcneilly.spacenerd.shared.core.models.Launch
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchDTO
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchDetailDTO
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchPadDTO
import com.adammcneilly.spacenerd.shared.data.launch.local.room.dto.RoomLaunchServiceProviderDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomLaunchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(
        launches: List<RoomLaunchDTO>,
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchServiceProvider(
        launchServiceProvider: RoomLaunchServiceProviderDTO,
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchPad(
        launchPad: RoomLaunchPadDTO,
    )

    suspend fun insertLaunches(
        launches: List<Launch>,
    ) {
        launches.forEach { launch ->
            val padDto = launch.pad?.let(::RoomLaunchPadDTO)
            if (padDto != null) {
                insertLaunchPad(padDto)
            }

            val serviceProviderDto = launch.provider?.let(::RoomLaunchServiceProviderDTO)
            if (serviceProviderDto != null) {
                insertLaunchServiceProvider(serviceProviderDto)
            }

            val launchDto = RoomLaunchDTO(launch)
            insertLaunches(listOf(launchDto))
        }
    }

    @Transaction
    @Query(
        """
        SELECT * 
        FROM launches 
        WHERE 
            (:before IS NULL OR launchTime <= :before) 
            AND (:after IS NULL OR launchTime >= :after)  
        """,
    )
    fun getLaunches(
        before: String?,
        after: String?,
    ): Flow<List<RoomLaunchDetailDTO>>
}
