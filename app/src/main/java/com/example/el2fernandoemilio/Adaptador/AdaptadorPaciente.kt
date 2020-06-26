package com.example.el2fernandoemilio.Adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.el2fernandoemilio.Beans.Paciente
import com.example.el2fernandoemilio.R
import kotlinx.android.synthetic.main.paciente.view.*
import java.util.*
import java.util.Locale.filter
import kotlin.collections.ArrayList

class AdaptadorPaciente(var lista: List<Paciente>, con: Context):
    RecyclerView.Adapter<AdaptadorPaciente.PacienteHolder>() {
    public class PacienteHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(oPaciente:Paciente){
            val odni=itemView.findViewById(R.id.PacienteDni) as TextView
            val ofecha=itemView.findViewById(R.id.PacienteFecha) as TextView
            val onombre=itemView.findViewById(R.id.PacienteDni) as TextView
            odni.text= oPaciente.Dni
            ofecha.text = oPaciente.Fecha
            onombre.text = oPaciente.Nombre

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteHolder {
        val v:View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.paciente, parent, false)
        return AdaptadorPaciente.PacienteHolder(v)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: PacienteHolder, position: Int) {
        holder?.itemView.PacienteDni?.text = lista.get(position).Dni
        holder?.itemView.PacienteFecha?.text = lista.get(position).Fecha
        holder?.itemView.PacienteNombre?.text = lista.get(position).Nombre
    }

    var nuevalista = ArrayList<Paciente>()

    init {
        nuevalista = lista as ArrayList<Paciente>
    }

    fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    nuevalista = lista as ArrayList<Paciente>
                } else {
                    val resultList = ArrayList<Paciente>()
                    for (row in nuevalista) {
                        if (row.toString().toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    nuevalista = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = nuevalista
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                nuevalista = results?.values as ArrayList<Paciente>
                notifyDataSetChanged()
            }

        }
    }
}