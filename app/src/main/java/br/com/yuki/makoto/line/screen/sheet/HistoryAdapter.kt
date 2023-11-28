package br.com.yuki.makoto.line.screen.sheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.yuki.makoto.line.R
import br.com.yuki.makoto.line.database.model.LineHistory
import br.com.yuki.makoto.line.databinding.CardHistoryBinding

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.Holder>() {
    val items: MutableList<LineHistory> = mutableListOf()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            binding = CardHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val history = items[position]
        holder.binding.info.text = "λ = ${history.lambdaFormatted}, μ = ${history.microFormatted}\n\n" + holder.itemView.context.getString(
            R.string.infoValues, history.p, history.l, history.lq, history.w, history.wq, history.t
        )
    }

    class Holder(
        val binding: CardHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root)
}