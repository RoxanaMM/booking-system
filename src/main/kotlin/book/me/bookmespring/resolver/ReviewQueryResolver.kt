package book.me.bookmespring.resolver

import book.me.bookmespring.model.Customer
import book.me.bookmespring.model.Review
import book.me.bookmespring.model.Studio
import book.me.bookmespring.repository.CustomerRepository
import book.me.bookmespring.repository.StudioRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ReviewQueryResolver(
    val customerRepository: CustomerRepository,
    val studioRepository: StudioRepository,
    private val mongoOperations: MongoOperations
) : GraphQLQueryResolver {
    fun customerReviewById(customerId: String): List<Customer> {
        val list = customerRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(id = item.id)
        }
        return list
    }

    fun studioReviewById(studioId: String): List<Studio> {
        val list = studioRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(id = item.id)
        }
        return list
    }

    private fun getReviews(id: UUID): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(id))
        return mongoOperations.find(query, Review::class.java)
    }
}