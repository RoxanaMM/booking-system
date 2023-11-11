package book.me.bookmespring.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "reviews")
data class Review(
    @Id
    val id: UUID,
    val customerId: UUID? = null,
    val studioId: UUID? = null,
    var reviewDetails: ReviewDetails
)