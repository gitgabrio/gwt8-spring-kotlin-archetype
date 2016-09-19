#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.eventbus;

import com.google.gwt.event.shared.SimpleEventBus;

import java.util.function.Supplier;

/**
 * The type <code>EventBusFactory</code>.
 */
public class EventBusFactory {

    /**
     * The constant <code>SimpleEventBus</code> eventBus.
     */
    private static SimpleEventBus eventBus;

    /**
     * Simple event bus supplier supplier.
     *
     * @return the supplier
     */
    public static Supplier<SimpleEventBus> simpleEventBusSupplier() {
        return () -> {
            if (eventBus == null) {
                eventBus = new SimpleEventBus();
            }
            return eventBus;
        };
    }
}
