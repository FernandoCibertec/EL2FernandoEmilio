package com.example.el2fernandoemilio

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.el2fernandoemilio.Adaptador.AdaptadorPaciente
import com.example.el2fernandoemilio.Beans.Paciente
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.*
import kotlin.Unit as Unit1

class MainActivity : AppCompatActivity() {

    lateinit var oListaPaciente:ArrayList<Paciente>
    lateinit var oAdaptadorPaciente:AdaptadorPaciente
    lateinit var oNuevoPaciente: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oListaPaciente = ArrayList<Paciente>()
        oListaPaciente.add(
            Paciente("Santiago", "41414454", "Fiebre",
            "Federico", 40.0, "03/05/2015")
        )
        oListaPaciente.add(Paciente("Paula", "41418789 ", "Jaqueca",
            "Paula", 60.0, "03/05/2015"))

        oAdaptadorPaciente = AdaptadorPaciente(oListaPaciente, this)

        var llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvListadoPaciente.setLayoutManager(llm)
        rvListadoPaciente.setHasFixedSize(true)

        rvListadoPaciente.setAdapter(oAdaptadorPaciente)
    }



    public fun btnRegistro_OnClick(v: View)
    {
        oNuevoPaciente = Dialog(this)
        oNuevoPaciente.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoPaciente.setCancelable(false)
        oNuevoPaciente.setContentView(R.layout.activity_registro_paciente)
        var obtnGrabar = oNuevoPaciente.findViewById(R.id.btnGrabar) as Button
        var obtnCerrar = oNuevoPaciente.findViewById(R.id.btnCerrar) as Button

        obtnGrabar.setOnClickListener(){
            GrabarNuevoPaciente()
            oNuevoPaciente.dismiss()
        }
        obtnCerrar.setOnClickListener(){
            oNuevoPaciente.dismiss()
        }
        oNuevoPaciente.show()
    }

    public fun GrabarNuevoPaciente()
    {
        var dni:EditText =oNuevoPaciente.findViewById(R.id.rtxtDNI)
        var nombre:EditText =oNuevoPaciente.findViewById(R.id.rtxtNom)
        var cita:EditText =oNuevoPaciente.findViewById(R.id.rtxtMotivo)
        var doctor:EditText =oNuevoPaciente.findViewById(R.id.rtxtDoctor)
        var costo:EditText =oNuevoPaciente.findViewById(R.id.rtxtCosto)
        var fecha:EditText =oNuevoPaciente.findViewById(R.id.rtxtFecha)

        oListaPaciente.add(Paciente(nombre.text.toString(),dni.text.toString()
            ,cita.text.toString(),doctor.text.toString(),costo.text.toString().toDouble(),
            fecha.text.toString()))

        oAdaptadorPaciente = AdaptadorPaciente(oListaPaciente.toList(),this)
        rvListadoPaciente.setAdapter(oAdaptadorPaciente)

    }
    public fun btnBuscar_OnClick(v:View){
        var text:EditText = this.findViewById(R.id.dtxtPaciente)
        oAdaptadorPaciente.getFilter().filter(text.toString())
    }
    public fun btnCerrar_OnClick(v:View){
        finish()
    }
}
