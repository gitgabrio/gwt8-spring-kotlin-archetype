#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import ${package}.client.consumers.HandlerConsumer;
import ${package}.client.consumers.RootPanelPopulator;
import ${package}.client.consumers.ThrowableConsumer;
import ${package}.client.event.CustomerLoginEvent;
import ${package}.client.event.CustomerLogoutEvent;
import ${package}.client.eventbus.EventBusFactory;
import ${package}.client.model.CustomerProxy;
import ${package}.client.view.customer.CustomerView;
import ${package}.client.view.login.LoginScreen;


/**
 * The type <code>Main</code>.
 */
public class Main implements EntryPoint, CustomerLoginEvent.CustomerLoginHandler, CustomerLogoutEvent.CustomerLogoutHandler {


    /**
     * The <code>RootPanelPopulator</code> rootPanelPopulator.
     */
    private RootPanelPopulator rootPanelPopulator =  new RootPanelPopulator();

    /**
     * The <code>ThrowableConsumer</code> throwableConsumer.
     */
    private ThrowableConsumer throwableConsumer = new ThrowableConsumer();


    /**
     * On module load.
     */
    @Override
    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(e -> throwableConsumer.accept(e));
        HandlerConsumer handlerConsumer = new HandlerConsumer();
        SimpleEventBus simpleEventBus = EventBusFactory.simpleEventBusSupplier().get();
        handlerConsumer.accept(simpleEventBus, CustomerLoginEvent.TYPE, this);
        handlerConsumer.accept(simpleEventBus, CustomerLogoutEvent.TYPE, this);
        showLoginScreen();
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(CustomerLoginEvent event) {
        showCustomerView(event.getCustomer());
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(CustomerLogoutEvent event) {
        logout();
    }

    /**
     * Logout.
     */
    private void logout() {
        rootPanelPopulator.accept(new LoginScreen());
    }

    /**
     * Show login screen.
     */
    private void showLoginScreen() {
        rootPanelPopulator.accept(new LoginScreen());
    }

    /**
     * Show customer view.
     *
     * @param customer the customer
     */
    private void showCustomerView(CustomerProxy customer) {
        rootPanelPopulator.accept(new CustomerView(customer));
    }

}
