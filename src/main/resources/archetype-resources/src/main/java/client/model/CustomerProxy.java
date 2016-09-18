package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.model;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import ${package}.server.dto.CustomerBean;

/**
 * The interface <code>CustomerProxy</code>.
 */
@ProxyFor(CustomerBean.class)
public interface CustomerProxy extends ValueProxy {

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName();

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName();

    /**
     * Gets connection id.
     *
     * @return the connection id
     */
    public String getConnectionId();


}
