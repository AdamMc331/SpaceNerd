package com.adammcneilly.spacenerd.data.launch.impl.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(
        launches: List<RoomLaunchDTO>,
    )

    @Query(
        """
        SELECT * FROM launches
        WHERE (:before IS NULL OR launchTimeUtc < :before)
        AND (:after IS NULL OR launchTimeUtc > :after)
        ORDER BY launchTimeUtc
        """,
    )
    fun getLaunches(
        before: String?,
        after: String?,
    ): Flow<List<RoomLaunchDTO>>
}
