package book.me.bookmespring.model

import org.springframework.data.annotation.Id
import java.util.UUID

data class Studio(
    @Id
    val id: UUID,
    var studioDetails: StudioDetails,
    val booking: Booking? = null,
    var reviews: List<Review>? = null
)