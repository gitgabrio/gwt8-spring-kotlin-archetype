package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event;
import ${package}.client.model.CustomerProxy;

/**
 * The type <code>CustomerLoginEvent</code>.
 */
public class CustomerLoginEvent extends Event<CustomerLoginEvent.CustomerLoginHandler> {

    /**
     * The interface <code>CustomerLoginHandler</code>.
     */
    public interface CustomerLoginHandler {
        /**
         * Manage event.
         *
         * @param event the event
         */
        void manageEvent(CustomerLoginEvent event);
    }

    /**
     * The constant <code>Type<CustomerLoginHandler></code> TYPE.
     */
    public static final GwtEvent.Type<CustomerLoginHandler> TYPE = new GwtEvent.Type<>();


    /**
     * The <code>CustomerProxy</code> customer.
     */
    private archetype.CustomerProxy customer;

    /**
     * Instantiates a new <code>CustomerLoginEvent</code>.
     *
     * @param customer the <code>customer</code> customer
     */
    public CustomerLoginEvent(archetype.CustomerProxy customer) {
        this.customer = customer;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public archetype.CustomerProxy getCustomer() {
        return customer;
    }

    /**
     * Gets associated type.
     *
     * @return the associated type
     */
    @Override
    public Type<CustomerLoginHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * Dispatch.
     *
     * @param handler the handler
     */
    @Override
    protected void dispatch(CustomerLoginHandler handler) {
        handler.manageEvent(this);
    }
}