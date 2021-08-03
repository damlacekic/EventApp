package com.damla.tecktileproject.api.model

import android.provider.ContactsContract
import android.text.Editable
import android.util.Patterns
import java.util.regex.Pattern


data class user(
    var email: String,
    var password: String,
    var fullName: String,
    var username: String


)
