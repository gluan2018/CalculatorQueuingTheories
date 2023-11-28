package br.com.yuki.makoto.line.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.yuki.makoto.line.database.AppDatabase
import br.com.yuki.makoto.line.database.dao.HistoryRepository
import br.com.yuki.makoto.line.database.model.LineHistory
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val repository: HistoryRepository

    init {
        repository = AppDatabase.make(application).history()
    }

    fun add(history: LineHistory) {
        viewModelScope.launch {
            runCatching {
                repository.add(history)
            }
        }
    }

    fun clear() {
        viewModelScope.launch {
            runCatching {
                repository.clear()
            }
        }
    }

    fun list() = repository.all()
}