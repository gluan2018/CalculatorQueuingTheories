package br.com.yuki.makoto.line.screen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.yuki.makoto.line.R
import br.com.yuki.makoto.line.database.model.LineHistory
import br.com.yuki.makoto.line.databinding.ActivityHomeBinding
import br.com.yuki.makoto.line.screen.sheet.BottomSheetHelp
import br.com.yuki.makoto.line.screen.sheet.BottomSheetHistory
import com.google.android.material.textfield.TextInputLayout

class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configureListener()
    }

    private fun configureListener() {
        binding.valuesInfo.text = getString(
            R.string.infoValues, "", "", "", "", "", ""
        )
        binding.aboutButton.setOnClickListener {
            BottomSheetHelp()
                .show(supportFragmentManager, null)
        }
        binding.historyButton.setOnClickListener {
            BottomSheetHistory(viewModel)
                .show(supportFragmentManager, null)
        }

        binding.calculateButton.setOnClickListener {
            val lambda = binding.lambdaField.textFloat ?: return@setOnClickListener
            val micro = binding.microField.textFloat ?: return@setOnClickListener

            showAndSaveValues(lambda, micro)
        }
    }

    private fun showAndSaveValues(lambda: Float, micro: Float) {
        val history = LineHistory.make(lambda, micro)
        binding.valuesInfo.text = getString(
            R.string.infoValues, history.p, history.l, history.lq, history.w, history.wq, history.t
        )

        viewModel.add(history)
    }

    private val TextInputLayout.textFloat: Float?
        get() = editText?.text?.toString()?.toFloatOrNull()
}