package fr.upjv.monprojetkotlin.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.upjv.monprojetkotlin.data.dao.AndroidVersionDao
import fr.upjv.monprojetkotlin.data.dao.ChuckNorrisDao
import fr.upjv.monprojetkotlin.data.model.AndroidVersionEntity
import fr.upjv.monprojetkotlin.data.model.ChuckNorrisEntity

@Database(
    entities = [
        AndroidVersionEntity::class,
        ChuckNorrisEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun mAndroidVersionDao(): AndroidVersionDao

    abstract fun ChuckNorrisDao(): ChuckNorrisDao
}

