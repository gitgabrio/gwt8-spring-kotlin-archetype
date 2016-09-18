#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerBean")
package ${package}.server.dto

/**
 * Created by Gabriele Cardosi - gcardosi@cardosi.net on 29/08/16.
 */
class CustomerBean {

    /**
     * The First name.
     */
    /**
     * Gets first name.

     * @return the first name
     */
    /**
     * Sets first name.

     * @param firstName the first name
     */
    var firstName: String? = null
    /**
     * The Last name.
     */
    /**
     * Gets last name.

     * @return the last name
     */
    /**
     * Sets last name.

     * @param lastName the last name
     */
    var lastName: String? = null

    /**
     * The `String` connectionId.
     */
    /**
     * Gets connectionId.

     * @return the connectionId
     */
    /**
     * Sets connectionId.

     * @param connectionId the connectionId
     */
    var connectionId: String? = null
}
