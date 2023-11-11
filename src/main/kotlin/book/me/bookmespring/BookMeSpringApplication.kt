package book.me.bookmespring

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class BookMeSpringApplication

fun main(args: Array<String>) {
    runApplication<BookMeSpringApplication>(*args)
}
