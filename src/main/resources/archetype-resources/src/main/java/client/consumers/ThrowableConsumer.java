package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.consumers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.UmbrellaException;

import java.util.function.Consumer;

/**
 * The type <code>ThrowableConsumer</code>.
 */
public class ThrowableConsumer implements Consumer<Throwable> {
    /**
     * Accept.
     *
     * @param throwable the throwable
     */
    @Override
    public void accept(Throwable throwable) {
        if (throwable == null) {
            return;
        }
        if (throwable instanceof UmbrellaException) {
            ((UmbrellaException) throwable).getCauses().forEach(this::accept);
        } else {
            GWT.log(throwable.toString(), throwable);
        }
    }

}
