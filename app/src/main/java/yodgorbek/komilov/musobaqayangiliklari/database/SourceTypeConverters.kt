package yodgorbek.komilov.musobaqayangiliklari.database

import android.util.Log
import androidx.room.TypeConverter
import org.json.JSONObject
import yodgorbek.komilov.musobaqayangiliklari.model.Source

class SourceTypeConverters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return JSONObject().apply {
            put("id", source.id)
            put("name", source.name)
        }.toString()
    }

    @TypeConverter
    fun toSource(source: String): Source {
        val json = JSONObject(source)
        Log.e("test", source)

        return Source(json.get("id"),

            json.getString("name"))
    }
}