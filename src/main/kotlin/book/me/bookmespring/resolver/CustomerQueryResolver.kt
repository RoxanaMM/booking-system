package book.me.bookmespring.resolver

import book.me.bookmespring.model.Customer
import book.me.bookmespring.model.Review
import book.me.bookmespring.repository.CustomerRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class CustomerQueryResolver(
    val customerRepository: CustomerRepository,
    private val mongoOperations: MongoOperations
) : GraphQLQueryResolver {
    fun customers(): List<Customer> {
        val list = customerRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(customerId = item.id.toString())
        }
        return list
    }

    private fun getReviews(customerId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(customerId))
        return mongoOperations.find(query, Review::class.java)
    }
}