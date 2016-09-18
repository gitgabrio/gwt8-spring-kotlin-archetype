package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.suppliers;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.gwtbootstrap3.client.ui.Button;
import java.util.function.Supplier;

/**
 * The type <code>WidgetSuppliers</code>.
 */
public class WidgetSuppliers {


    /**
     * Login popup panel supplier supplier.
     *
     * @param connectionId the connection id
     * @return the supplier
     */
    public static Supplier<PopupPanel> loginPopupPanelSupplier(String connectionId) {
        return () -> {
            PopupPanel toReturn = new PopupPanel();
            toReturn.setTitle("Successful Login");
            VerticalPanel verticalPanel = new VerticalPanel();
            Label label = new Label("Connection ID : " + connectionId);
            Button button = new Button("Close");
            button.addClickHandler(event -> toReturn.hide());
            verticalPanel.add(label);
            verticalPanel.add(button);
            toReturn.setWidget(verticalPanel);
            return toReturn;
        };
    }
}
