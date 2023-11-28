package br.com.yuki.makoto.line.screen.sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.yuki.makoto.line.databinding.SheetHelpBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetHelp : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return SheetHelpBinding.inflate(layoutInflater, container, false).root
    }
}