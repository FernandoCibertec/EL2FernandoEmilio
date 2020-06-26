package com.example.el2fernandoemilio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.el2fernandoemilio.Adaptador.AdaptadorPaciente
import com.example.el2fernandoemilio.Beans.Paciente
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registro_paciente.*

class RegistroPaciente : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_paciente)
    }
    public fun btnGrabar_OnClick(v: View){
    }
}
