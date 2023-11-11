package book.me.bookmespring.model

import org.springframework.data.annotation.Id
import java.util.UUID

data class Contact(
    @Id
    val id: UUID,
    val phoneNumber: String,
    val email: String?,
    val location: String?
)