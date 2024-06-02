package com.realform.macropaytestpokemon.presentation.ui.utils

/**
 * This method is incharge of guarantee the usage of a valid email
 * */
fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return email.matches(emailRegex.toRegex())
}

/**
 * This method is incharge of guarantee the usage of a strong Password
 * */
fun isStrongPassword(password: String): Boolean {
    val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$"
    val newRegex= "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[\$#%&/+])(?=.*[A-Z])(?=.*[a-z]).+\$"
    return password.matches(newRegex.toRegex())
}


fun fieldIsNotEmpty(){

}

//TODO
/*
* 1 letra minúscula ((?=.*[a-z]))
  1 letra mayúscula ((?=.*[A-Z]))
  1 número ((?=.*\\d))
  1 caracter especial entre @, $, !, %, *, ? o & ((?=.*[@\$!%*?&]))
  La longitud total de la contraseña debe ser al menos 8 caracteres ({8,})
 * */