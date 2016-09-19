#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.suppliers;

import com.google.web.bindery.requestfactory.shared.Request;
import ${package}.client.model.CustomerProxy;

import java.util.function.Supplier;

import static ${package}.client.requestfactory.FactoryFactory.authenticationFactorySupplier;

/**
 * The type <code>RequestSuppliers</code>.
 */
public class RequestSuppliers {


    /**
     * Customer request supplier supplier.
     *
     * @param userName the user name
     * @param password the password
     * @return the supplier
     */
    public static Supplier<Request<CustomerProxy>> customerRequestSupplier(String userName, String password) {
        return () -> authenticationFactorySupplier().get().createAuthenticationRequestCtx().getCustomer(userName, password);
    }

    /**
     * Logout request supplier supplier.
     *
     * @param customerProxy the customer proxy
     * @return the supplier
     */
    public static Supplier<Request<Void>> logoutRequestSupplier(CustomerProxy customerProxy) {
        return () -> authenticationFactorySupplier().get().createAuthenticationRequestCtx().logoutCustomer(customerProxy);
    }


}
