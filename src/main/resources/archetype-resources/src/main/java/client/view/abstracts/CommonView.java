#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.abstracts;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import ${package}.client.model.CustomerProxy;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.TextBox;

import static ${package}.client.suppliers.ReceiverSuppliers.logoutReceiverSupplier;
import static ${package}.client.suppliers.RequestSuppliers.logoutRequestSupplier;

/**
 * The type <code>CommonView</code>.
 */
public abstract class CommonView extends Composite {


    /**
     * The interface <code>CommonViewUiBinder</code>.
     */
    interface CommonViewUiBinder extends UiBinder<HTMLPanel, CommonView> {
    }

    /**
     * The constant <code>CommonViewUiBinder</code> ourUiBinder.
     */
    private static CommonViewUiBinder ourUiBinder = GWT.create(CommonViewUiBinder.class);

    /**
     * The <code>TextBox</code> firstName.
     */
    @UiField
    protected TextBox firstName;
    /**
     * The <code>TextBox</code> lastName.
     */
    @UiField
    protected TextBox lastName;

    /**
     * The <code>Button</code> logout.
     */
    @UiField
    protected Button logout;

    /**
     * The <code>CustomerProxy</code> customerProxy.
     */
    protected CustomerProxy customerProxy;

    /**
     * Instantiates a new <code>CommonView</code>.
     *
     * @param customerProxy the <code>customerProxy</code> customer proxy
     */
    public CommonView(CustomerProxy customerProxy) {
        this.customerProxy = customerProxy;
        initWidget(ourUiBinder.createAndBindUi(this));
        firstName.setText(customerProxy.getFirstName());
        lastName.setText(customerProxy.getLastName());
    }


    /**
     * Logout.
     *
     * @param event the event
     */
    @UiHandler("logout")
    public void logout(ClickEvent event) {
        logoutRequestSupplier(customerProxy).get().fire(logoutReceiverSupplier().get());
    }


}
