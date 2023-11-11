package book.me.bookmespring.resolver

import book.me.bookmespring.model.Studio
import book.me.bookmespring.model.StudioDetails
import book.me.bookmespring.repository.StudioRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class StudioMutationResolver(private val studioRepository: StudioRepository) : GraphQLMutationResolver {
    fun newStudio(studioDetails: StudioDetails): Studio {
        val studioId = UUID.randomUUID()
        val studio = Studio(studioId, studioDetails)
        studioRepository.save(studio)
        return studio
    }

    fun deleteStudio(id: UUID): Boolean {
        studioRepository.deleteById(id.toString())
        return true
    }

    fun updateStudio(id: UUID, studioDetails: StudioDetails): Studio {
        val studio = studioRepository.findById(id.toString())
        studio.ifPresent {
            it.studioDetails = studioDetails
            studioRepository.save(it)
        }
        return studio.get()
    }
}