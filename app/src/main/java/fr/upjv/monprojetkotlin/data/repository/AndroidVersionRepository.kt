package fr.upjv.monprojetkotlin.data.repository

import fr.upjv.monprojetkotlin.architecture.CustomApplication
import fr.upjv.monprojetkotlin.data.model.AndroidObject
import fr.upjv.monprojetkotlin.data.model.toDomain
import fr.upjv.monprojetkotlin.data.model.toRoomObject
import fr.upjv.monprojetkotlin.ui.model.ItemUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AndroidVersionRepository {


    private val androidVersionDao =
        CustomApplication.instance.mApplicationDatabase.mAndroidVersionDao()


    fun selectAllAndroidVersion(): Flow<List<AndroidObject>> {
        return androidVersionDao.selectAll().map {
            it.toDomain()
        }
    }


    fun insertAndroidVersion(androidObject: AndroidObject) {
        androidVersionDao.insert(androidObject.toRoomObject())
    }


    fun deleteAllAndroidVersion() {
        androidVersionDao.deleteAll()
    }
}
