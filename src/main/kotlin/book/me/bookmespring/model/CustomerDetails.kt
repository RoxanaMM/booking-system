package book.me.bookmespring.model

import org.springframework.data.annotation.Id
import java.util.UUID

data class CustomerDetails(
    @Id
    val id: UUID,
    val username: String,
    val email: String,
    val password: String
)