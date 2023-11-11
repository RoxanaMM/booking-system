package book.me.bookmespring.resolver

import book.me.bookmespring.model.Review
import book.me.bookmespring.model.Studio
import book.me.bookmespring.repository.StudioRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class StudioQueryResolver(
    val studioRepository: StudioRepository,
    private val mongoOperations: MongoOperations
) : GraphQLQueryResolver {
    fun studios(): List<Studio> {
        val list = studioRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(studioId = item.id.toString())
        }
        return list
    }

    private fun getReviews(studioId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(studioId))
        return mongoOperations.find(query, Review::class.java)
    }
}