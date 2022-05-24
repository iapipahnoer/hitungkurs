package org.d3if2095.hitungkurs.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KursDao {
    @Insert
    fun insert(kurs: KursEntity)
    @Query("SELECT * FROM kurs ORDER BY id DESC LIMIT 1")
    fun getLastKurs(): LiveData<KursEntity?>
}