package book.me.bookmespring.model

import org.springframework.data.annotation.Id
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

data class Booking(
    @Id
    val id: UUID,
    val bookingDetails: BookingDetails
)