package book.me.bookmespring.resolver

import book.me.bookmespring.model.Customer
import book.me.bookmespring.model.CustomerDetails
import book.me.bookmespring.repository.CustomerRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class CustomerMutationResolver(private val customerRepository: CustomerRepository) : GraphQLMutationResolver {
    fun newCustomer(customerDetails: CustomerDetails): Customer {
        val customerId = UUID.randomUUID()
        val customer = Customer(customerId, customerDetails)
        customerRepository.save(customer)
        return customer
    }

    fun deleteCustomer(id: UUID): Boolean {
        customerRepository.deleteById(id.toString())
        return true
    }

    fun updateCustomer(id: UUID, customerDetails: CustomerDetails): Customer {
        val customer = customerRepository.findById(id.toString())
        customer.ifPresent {
            it.customerDetails = customerDetails
            customerRepository.save(it)
        }
        return customer.get()
    }
}