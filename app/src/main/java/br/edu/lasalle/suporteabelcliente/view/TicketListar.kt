package br.edu.lasalle.suporteabelcliente.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.edu.lasalle.suporteabelcliente.R
import br.edu.lasalle.suporteabelcliente.TicketAdapter
import br.edu.lasalle.suporteabelcliente.model.Ticket
import br.edu.lasalle.suporteabelcliente.viewmodel.TicketListarViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

class TicketListar : Fragment() {

    private lateinit var mAuth : FirebaseAuth

    companion object {
        fun newInstance() = TicketListar()
    }

    private lateinit var viewModel: TicketListarViewModel
    private var TAG = "LISTAR TICKETS"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ticket_listar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TicketListarViewModel::class.java)


        
        mAuth =  FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        val database = FirebaseDatabase.getInstance()
        var tickets = ArrayList<Ticket>()
        if(user?.uid != null){
            val fb = database.getReference("/tickets").child(user.uid).get().addOnSuccessListener {
                for (data in it.children){
                    val id = data.child("stringResourceId").getValue().toString().toInt()
                    val email = data.child("email").getValue().toString()
                    val problema = data.child("problema").getValue().toString()
                    val latitude = data.child("latitude").getValue().toString()
                    val longitude = data.child("longitude").getValue().toString()
                    val status = data.child("status").getValue().toString()
                    var fbTicket: Ticket = Ticket(id,email, problema,latitude,longitude,status)
                    tickets.add(fbTicket)
                    Log.i("firebase", "Got value ${fbTicket}")
                    //Log.i("firebase", "Got value ${data.child("stringResourceId").getValue()}")
                }

                val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler)
                recyclerView?.adapter = activity?.let { it1 -> TicketAdapter(it1,tickets) }
                recyclerView?.setHasFixedSize(true)
                //recyclerView.setHasFixedSize(true)
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }

            //configRecyclerView(user)


        }else{
            Log.w(TAG,"User.email is null")
        }

        val button = view?.findViewById<Button>(R.id.btn_next)
        button?.setOnClickListener {
            findNavController().navigate(R.id.ticketCriar, null)
        }


    }

    /*private fun configRecyclerView(user: FirebaseUser) {
        var ticket1 : Ticket = Ticket(user.email, "problema", "-111111","+111111","Aberto")
        var ticket2 : Ticket = Ticket(user.email, "problema", "-111111","+111111","Aberto")
        var ticket3 : Ticket = Ticket(user.email, "problema", "-111111","+111111","Aberto")
        var ticket4 : Ticket = Ticket(user.email, "problema", "-111111","+111111","Aberto")

        var tickets: List<Ticket> = ArrayList<Ticket>()

    }

     */

}