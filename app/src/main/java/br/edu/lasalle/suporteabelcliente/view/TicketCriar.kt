package br.edu.lasalle.suporteabelcliente.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import br.edu.lasalle.suporteabelcliente.R
import br.edu.lasalle.suporteabelcliente.model.Ticket
import br.edu.lasalle.suporteabelcliente.viewmodel.TicketCriarViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class TicketCriar : Fragment() {

    private lateinit var mAuth : FirebaseAuth
    var fusedLocationClient: FusedLocationProviderClient? = null
    private lateinit var viewModel: TicketCriarViewModel

    companion object {
        fun newInstance() = TicketCriar()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ticket_criar_fragment, container, false)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TicketCriarViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        val button = view.findViewById<Button>(R.id.btn_add_ticket).setOnClickListener {
            // Write a message to the database
            mAuth =  FirebaseAuth.getInstance()
            val user = mAuth.currentUser
            val database = FirebaseDatabase.getInstance()
            val uuid = UUID.randomUUID()

            if(user?.uid != null){
                val problema = view.findViewById<EditText>(R.id.input_problema).text.toString()
                val ticket : Ticket = Ticket( )
                //val ticket : Ticket = Ticket((Math.random() * 2147483647).toInt(), user.email, problema, "-111111","+111111","Em Aberto")
                val fb = database.getReference("/tickets").child(user.uid).child(uuid.toString())

                fb.setValue(ticket)
            }else{
                Log.w("Erro no user.email","User.email is null")
            }
            Toast.makeText(activity,"Salvo com sucesso",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.ticketListar, null)
        }
    }

}