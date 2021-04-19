package br.edu.lasalle.suporteabelcliente.model

data class Ticket(val stringResourceId: Int, var email: String, var problema: String, var latitude: String, var longitude: String, var status: String) {

}