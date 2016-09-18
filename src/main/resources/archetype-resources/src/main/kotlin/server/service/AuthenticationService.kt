#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("AuthenticationService")
package ${package}.server.service

import ${package}.server.dto.CustomerBean
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

import java.util.Date

/**
 * The type Authentication service.
 */
@Service
class AuthenticationService {

    /**
     * The `Logger` logger.
     */
    protected var logger = LoggerFactory.getLogger(AuthenticationService::class.java)


    /**
     * Gets customer.

     * @param userName the user name
     * *
     * @param password the password
     * *
     * @return the customer
     */
    fun getCustomer(userName: String?, password: String?): CustomerBean? {
        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            return null
        }
        val toReturn = CustomerBean()
        toReturn.firstName = "Scrooge"
        toReturn.lastName = "McDuck"
        toReturn.connectionId = Date().toString()
        return toReturn
    }

    /**
     * Logout customer.

     * @param customer the customer
     */
    fun logoutCustomer(customer: CustomerBean) {

    }

}
