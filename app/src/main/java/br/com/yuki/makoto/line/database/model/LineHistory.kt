package br.com.yuki.makoto.line.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.math.pow

@Entity(
    tableName = "line_history",
)
data class LineHistory(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Long,
    @ColumnInfo("lambda") val lambda: Float,
    @ColumnInfo("micro") val micro: Float
) {
    val lambdaFormatted: String
        get() = format(lambda)

    val microFormatted: String
        get() = format(micro)

    val pValue: Float
        get() = lambda / micro

    val `p`: String
        get() = format(pValue) + " %"

    val lValue: Float
        get() = pValue / (1f - pValue)

    val `l`: String
        get() = format(lValue)

    val lqValue: Float
        get() = pValue.toDouble().pow(2.0).toFloat() / (1f - pValue)

    val `lq`: String
        get() = format(lqValue)

    val wValue: Float
        get() = 1f / (micro - lambda)

    val `w`: String
        get() = format(wValue)

    val wqValue: Float
        get() = pValue / (micro - lambda)

    val `wq`: String
        get() = format(wqValue)

    val tValue: Float
        get() = 1f / micro

    val `t`: String
        get() = format(tValue)

    companion object {
        fun make(lambda: Float, micro: Float) = LineHistory(0, lambda, micro)
    }
}

private fun format(value: Float): String {
    return String.format("%.2f", value)
}
