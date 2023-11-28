package br.com.yuki.makoto.line.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.yuki.makoto.line.database.model.LineHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryRepository {
    @Query("select * from LINE_HISTORY order by id desc")
    fun all(): Flow<List<LineHistory>>

    @Insert
    suspend fun add(insert: LineHistory)

    @Query("delete from line_history")
    suspend fun clear()
}