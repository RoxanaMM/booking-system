package book.me.bookmespring.model

import java.time.LocalDate
import java.time.LocalTime

class BookingDetails(
    val rating: Int,
    val amount: String,
    val bookingTime: LocalTime,
    val bookingDate: LocalDate,
    val contact: Contact? = null
)
