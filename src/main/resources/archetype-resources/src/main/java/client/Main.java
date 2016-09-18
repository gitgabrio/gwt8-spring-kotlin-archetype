package archetype

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
public class Main implements EntryPoint, archetype.CustomerLoginEvent.CustomerLoginHandler, archetype.CustomerLogoutEvent.CustomerLogoutHandler {


    /**
     * The <code>RootPanelPopulator</code> rootPanelPopulator.
     */
    private archetype.RootPanelPopulator rootPanelPopulator =  new archetype.RootPanelPopulator();

    /**
     * The <code>ThrowableConsumer</code> throwableConsumer.
     */
    private archetype.ThrowableConsumer throwableConsumer = new archetype.ThrowableConsumer();


    /**
     * On module load.
     */
    @Override
    public void onModuleLoad() {
        GWT.setUncaughtExceptionHandler(e -> throwableConsumer.accept(e));
        archetype.HandlerConsumer handlerConsumer = new archetype.HandlerConsumer();
        SimpleEventBus simpleEventBus = archetype.EventBusFactory.simpleEventBusSupplier().get();
        handlerConsumer.accept(simpleEventBus, archetype.CustomerLoginEvent.TYPE, this);
        handlerConsumer.accept(simpleEventBus, archetype.CustomerLogoutEvent.TYPE, this);
        showLoginScreen();
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(archetype.CustomerLoginEvent event) {
        showCustomerView(event.getCustomer());
    }

    /**
     * Manage event.
     *
     * @param event the event
     */
    @Override
    public void manageEvent(archetype.CustomerLogoutEvent event) {
        logout();
    }

    /**
     * Logout.
     */
    private void logout() {
        rootPanelPopulator.accept(new archetype.LoginScreen());
    }

    /**
     * Show login screen.
     */
    private void showLoginScreen() {
        rootPanelPopulator.accept(new archetype.LoginScreen());
    }

    /**
     * Show customer view.
     *
     * @param customer the customer
     */
    private void showCustomerView(archetype.CustomerProxy customer) {
        rootPanelPopulator.accept(new archetype.CustomerView(customer));
    }

}
