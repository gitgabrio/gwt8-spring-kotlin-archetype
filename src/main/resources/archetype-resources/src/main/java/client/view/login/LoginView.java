package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;

import static ${package}.client.suppliers.ReceiverSuppliers.receiverSupplier;
import static ${package}.client.suppliers.RequestSuppliers.customerRequestSupplier;


/**
 * The type <code>LoginView</code>.
 */
public class LoginView extends AbstractLoginView {
    /**
     * The interface <code>LoginUiBinder</code>.
     */
    interface LoginUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    /**
     * The constant <code>LoginUiBinder</code> ourUiBinder.
     */
    private static LoginUiBinder ourUiBinder = GWT.create(LoginUiBinder.class);

    /**
     * The <code>Input</code> userInput.
     */
    @UiField
    Input userInput;
    /**
     * The <code>Input</code> passwordInput.
     */
    @UiField
    Input passwordInput;
    /**
     * The <code>Button</code> loginButton.
     */
    @UiField
    Button loginButton;

    /**
     * Instantiates a new <code>LoginView</code>.
     */
    public LoginView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    /**
     * Login.
     *
     * @param event the event
     */
    @UiHandler("loginButton")
    public void login(ClickEvent event) {
        customerRequestSupplier(userInput.getText(), passwordInput.getText()).get().fire(receiverSupplier().get());
    }

}