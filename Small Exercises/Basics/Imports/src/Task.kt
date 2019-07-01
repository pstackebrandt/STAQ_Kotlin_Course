import domain.internal.Customer
import domain.external.Customer as ExternalCustomer

open class CustomerMapper {
    fun mapToInternalCustomer(customer: ExternalCustomer): Customer =
            Customer(customer.name, customer.id)
}

fun main(args: Array<String>) {

}