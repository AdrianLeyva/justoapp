package com.justo.justoapp.adapters

import com.justo.justoapp.model.Location

/**
 * @author adrianleyvasanchez
 * @since 7/25/21
 */
sealed class RandomUserClick {
    data class Map(val location: Location) : RandomUserClick()
    data class Email(val email: String) : RandomUserClick()
    data class Phone(val phone: String) : RandomUserClick()
}
