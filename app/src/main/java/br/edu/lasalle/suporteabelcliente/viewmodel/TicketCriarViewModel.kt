package br.edu.lasalle.suporteabelcliente.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.edu.lasalle.suporteabelcliente.model.User

class TicketCriarViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    //private lateinit var mAuth : FirebaseAuth


    //val au = mAuth.currentUser
    //User(au.email,au.uid, au.displayName)
    val user: LiveData<User> = TODO()
}