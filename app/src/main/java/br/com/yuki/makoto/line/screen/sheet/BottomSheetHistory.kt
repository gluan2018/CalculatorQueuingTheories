package br.com.yuki.makoto.line.screen.sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import br.com.yuki.makoto.line.databinding.SheetHistoryBinding
import br.com.yuki.makoto.line.screen.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch

class BottomSheetHistory(
    private val viewModel: HomeViewModel
) : BottomSheetDialogFragment() {
    private lateinit var binding: SheetHistoryBinding

    private val adapter: HistoryAdapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SheetHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.adapter = adapter
        binding.deleteButton.setOnClickListener {
            viewModel.clear()
        }

        lifecycleScope.launch {
            viewModel.list()
                .collect { items ->
                    adapter.items.clear()
                    adapter.items.addAll(items)
                    adapter.notifyDataSetChanged()
                }
        }
    }
}