package book.me.bookmespring.repository

import book.me.bookmespring.model.Studio
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StudioRepository : MongoRepository<Studio, String>