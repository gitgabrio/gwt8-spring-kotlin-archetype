#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.consumers;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event;

/**
 * Created by Gabriele Cardosi - gcardosi@cardosi.net on 18/09/16.
 *
 * @param <E> the type parameter
 * @param <T> the type parameter
 * @param <U> the type parameter
 */
public class HandlerConsumer<E extends EventBus, T extends GwtEvent.Type<?>, U> {


    /**
     * Accept.
     *
     * @param e the e
     * @param t the t
     * @param u the u
     */
    public void accept(E e, T t, U u) {
        e.addHandler((Event.Type<U>) t, u);
    }
}
