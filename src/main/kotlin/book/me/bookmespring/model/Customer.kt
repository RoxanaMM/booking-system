package book.me.bookmespring.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID


@Document(collection = "customer")
data class Customer(
    @Id
    val id: UUID,
    // will probably have a profile picture
    var customerDetails: CustomerDetails,
    val booking: Booking? = null,
    // the exact same thing Uber has, so the customer can also get some review
    var reviews: List<Review>? = null
)