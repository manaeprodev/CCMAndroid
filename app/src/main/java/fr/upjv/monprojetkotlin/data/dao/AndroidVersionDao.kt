package fr.upjv.monprojetkotlin.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.monprojetkotlin.data.model.AndroidVersionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AndroidVersionDao {

    @Query("SELECT * FROM android_version_object_table ORDER BY name ASC")
    fun selectAll(): Flow<List<AndroidVersionEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: AndroidVersionEntity)


    @Query("DELETE FROM android_version_object_table")
    fun deleteAll()
}
