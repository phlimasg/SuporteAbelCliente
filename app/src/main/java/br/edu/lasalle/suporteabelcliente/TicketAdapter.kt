package br.edu.lasalle.suporteabelcliente

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.lasalle.suporteabelcliente.model.Ticket

class TicketAdapter(
    private val context: Context,
    private val dataset: List<Ticket>) : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>()
{
    class TicketViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val status: TextView = view.findViewById(R.id.txt_status)
        val ticket_id: TextView = view.findViewById(R.id.txt_ticket_id)
        val problema: TextView = view.findViewById(R.id.txt_problema)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_feed, parent, false)
        return TicketViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val item = dataset[position]
        //holder.status.text = context.resources.getString(item.stringResourceId)
        holder.ticket_id.text = context.resources.getString(item.getId())
        //holder.problema.text = context.resources.getString(item.stringResourceId)
    }

    override fun getItemCount() = dataset.size
}