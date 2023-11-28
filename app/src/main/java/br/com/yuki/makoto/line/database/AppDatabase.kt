package br.com.yuki.makoto.line.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.yuki.makoto.line.database.dao.HistoryRepository
import br.com.yuki.makoto.line.database.model.LineHistory

@Database(
    entities = [
        LineHistory::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun history(): HistoryRepository

    companion object {
        private const val DATABASE_NAME = "LineDatabase"

        fun make(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}