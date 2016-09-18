package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.suppliers;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import ${package}.client.event.CustomerLoginEvent;
import ${package}.client.event.CustomerLogoutEvent;
import ${package}.client.model.CustomerProxy;

import java.util.function.Supplier;

import static ${package}.client.eventbus.EventBusFactory.simpleEventBusSupplier;
import static ${package}.client.suppliers.WidgetSuppliers.loginPopupPanelSupplier;

/**
 * The type <code>ReceiverSuppliers</code>.
 */
public class ReceiverSuppliers {

    /**
     * Logout receiver supplier supplier.
     *
     * @return the supplier
     */
    public static Supplier<Receiver<Void>> logoutReceiverSupplier() {
        return () -> {
            Receiver<Void> toReturn = new Receiver<Void>() {
                @Override
                public void onSuccess(Void response) {
                    fireLogout();
                }

                @Override
                public void onFailure(ServerFailure error) {
                    fireLogout();
                }

                private void fireLogout() {
                    simpleEventBusSupplier().get().fireEvent(new archetype.CustomerLogoutEvent());
                }
            };
            return toReturn;
        };
    }

    /**
     * Receiver supplier supplier.
     *
     * @return the supplier
     */
    public static Supplier<Receiver<archetype.CustomerProxy>> receiverSupplier() {
        return () -> {
            Receiver<archetype.CustomerProxy> toReturn = new Receiver<archetype.CustomerProxy>() {
                @Override
                public void onSuccess(archetype.CustomerProxy response) {
                    if (response == null) {
                        onFailure(new ServerFailure("Failed to login customer"));
                    } else {
                        loginPopupPanelSupplier(response.getConnectionId()).get().center();
                        archetype.CustomerLoginEvent loginEvent = new archetype.CustomerLoginEvent(response);
                        simpleEventBusSupplier().get().fireEvent(loginEvent);
                    }
                }
            };
            return toReturn;
        };
    }


}
