package book.me.bookmespring.model

import java.util.UUID

data class ReviewDetails(
    val studioId: UUID,
    val rating: Int,
    val text: String
)
