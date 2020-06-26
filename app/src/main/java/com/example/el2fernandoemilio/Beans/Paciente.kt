package com.example.el2fernandoemilio.Beans

class Paciente {
    var Nombre: String = "";
    var Dni: String = "";
    var MotivoCita: String = "";
    var Doctor: String = "";
    var CostoAtencion: Double = 0.0;
    var Fecha: String = "";

    public constructor(pNombre: String, pDni: String, pMotivoCita: String, pDoctor: String, pCostoAtencion: Double, pFecha: String){

        this.Nombre = pNombre
        this.Dni = pDni
        this.MotivoCita = pMotivoCita
        this.Doctor = pDoctor
        this.CostoAtencion = pCostoAtencion
        this.Fecha = pFecha
    }
    public constructor(){
        this.Limpieza()
    }
    fun Limpieza(){
        this.Nombre=""
        this.Dni=""
        this.MotivoCita=""
        this.Doctor=""
        this.CostoAtencion=0.0
        this.Fecha=""
    }
}