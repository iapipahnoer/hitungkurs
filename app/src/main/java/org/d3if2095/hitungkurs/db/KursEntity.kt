package org.d3if2095.hitungkurs.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kurs")
data class KursEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var jumlah: Float,
    var kurs: Float
)