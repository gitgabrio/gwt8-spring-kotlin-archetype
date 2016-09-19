#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.consumers;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.function.Consumer;

/**
 * The type <code>RootPanelPopulator</code>.
 */
public class RootPanelPopulator implements Consumer<Composite> {

    /**
     * Accept.
     *
     * @param composite the composite
     */
    @Override
        public void accept(Composite composite) {
            RootPanel content = RootPanel.get("content");
            content.clear();
            content.add(composite);
        }
    }