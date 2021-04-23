package br.edu.lasalle.suporteabelcliente.model

class Ticket {
    private var stringResourceId: Int = 0
    private lateinit var email : String
    private lateinit var problema : String
    private lateinit var latitude : String
    private lateinit var longitude : String
    private lateinit var status : String

    public fun Ticket(
            stringResourceId : Int,
            email : String,
            problema : String,
            latitude : String,
            longitude : String,
            status : String
    ){
        this.stringResourceId = stringResourceId
        this.email = email
        this.problema = problema
        this.latitude = latitude
        this.longitude = longitude
        this.status = status
    }
    public fun getId(): Int{
        return this.stringResourceId.toInt()
    }
}