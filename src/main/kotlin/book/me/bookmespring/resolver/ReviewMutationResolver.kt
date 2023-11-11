package book.me.bookmespring.resolver

import book.me.bookmespring.model.CustomerDetails
import book.me.bookmespring.model.Review
import book.me.bookmespring.model.ReviewDetails
import book.me.bookmespring.repository.ReviewRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ReviewMutationResolver(
    val reviewRepository: ReviewRepository,
    private val mongoOperations: MongoOperations
) : GraphQLQueryResolver {

    fun newReviewForCustomer(customerId: UUID, reviewDetails: ReviewDetails): Boolean {
        val reviewForCustomer = Review(UUID.randomUUID(), customerId = customerId, reviewDetails = reviewDetails)
        reviewRepository.save(reviewForCustomer)
        return true
    }

    fun deleteReviewForCustomer(reviewId: UUID): Boolean {
        reviewRepository.deleteById(reviewId.toString())
        return true
    }

    fun updateReviewForCustomer(id: UUID, customerDetails: CustomerDetails): Review {
        val review = reviewRepository.findById(id.toString())
        review.ifPresent {
            it.reviewDetails = it.reviewDetails
            reviewRepository.save(it)
        }
        return review.get()
    }


    fun newReviewForStudio(studioId: UUID, reviewDetails: ReviewDetails): Boolean {
        val reviewForStudio = Review(UUID.randomUUID(), studioId = studioId, reviewDetails = reviewDetails)
        reviewRepository.save(reviewForStudio)
        return true
    }

    fun deleteReviewForStudio(reviewId: UUID): Boolean {
        reviewRepository.deleteById(reviewId.toString())
        return true
    }

    fun updateReviewForStudio(id: UUID, customerDetails: CustomerDetails): Review {
        val review = reviewRepository.findById(id.toString())
        review.ifPresent {
            it.reviewDetails = it.reviewDetails
            reviewRepository.save(it)
        }
        return review.get()
    }

}