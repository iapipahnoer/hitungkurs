package org.d3if2095.hitungkurs.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [KursEntity::class], version = 1, exportSchema = false)
abstract class KursDb : RoomDatabase() {
    abstract val dao: KursDao
    companion object {
        @Volatile
        private var INSTANCE: KursDb? = null
        fun getInstance(context: Context): KursDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KursDb::class.java,
                        "kurs.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}