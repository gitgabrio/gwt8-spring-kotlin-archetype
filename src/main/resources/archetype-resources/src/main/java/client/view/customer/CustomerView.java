package archetype

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.view.customer;

import ${package}.client.model.CustomerProxy;
import ${package}.client.view.abstracts.CommonView;

/**
 * The type <code>CustomerView</code>.
 */
public class CustomerView extends archetype.CommonView {

    /**
     * Instantiates a new <code>CustomerView</code>.
     *
     * @param customer the <code>customer</code> customer
     */
    public CustomerView(archetype.CustomerProxy customer) {
        super(customer);
    }


}