package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.requestfactory;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;

import java.util.function.Supplier;

/**
 * The type <code>FactoryFactory</code>.
 */
public class FactoryFactory {

    /**
     * The constant <code>AuthenticationFactory</code> authenticationFactory.
     */
    private static archetype.AuthenticationFactory authenticationFactory;

    /**
     * Authentication factory supplier supplier.
     *
     * @return the supplier
     */
    public static Supplier<archetype.AuthenticationFactory> authenticationFactorySupplier() {
        return () -> {
            if (authenticationFactory == null) {
                authenticationFactory = GWT.create(archetype.AuthenticationFactory.class);
                authenticationFactory.initialize(new SimpleEventBus());
            }
            return authenticationFactory;
        };
    }

}
