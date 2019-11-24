package dominando.android.recycler

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter (
    private val mensages: List<Message>,
    private val callback: (Message) -> Unit
) : RecyclerView.Adapter<MessageAdapter.VH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        val vh = VH(v)
        vh.itemView.setOnClickListener {
            val message = mensages[vh.adapterPosition]
            callback(message)
        }
        return vh
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val (title, text) = mensages[position]
        holder.txtTitle.text = title
        holder.txtText.text = text
    }

    override fun getItemCount(): Int = mensages.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.txtTitle
        val txtText: TextView = itemView.txtText
    }
}