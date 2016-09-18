#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("AuthenticationServiceLocator")

package ${package}.server.servicelocator

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet
import com.google.web.bindery.requestfactory.shared.ServiceLocator
import ${package}.server.service.AuthenticationService
import org.springframework.web.context.support.WebApplicationContextUtils


/**
 * The type Authentication service locator.
 */
class AuthenticationServiceLocator : ServiceLocator {

    /**
     * Gets instance.

     * @param clazz the clazz
     * *
     * @return the instance
     */
    override fun getInstance(clazz: Class<*>): Any {
        return getServiceInstance()
    }

    companion object {
        /**
         * The constant serviceInstance.
         */
        private var instance: AuthenticationService? = null

        /**
         * Gets service instance.

         * @return the service instance
         */
        fun getServiceInstance(): AuthenticationService {
            if (instance == null) {
                val request = RequestFactoryServlet.getThreadLocalRequest()
                val servletCtx = request.session.servletContext
                val springCtx = WebApplicationContextUtils.getWebApplicationContext(servletCtx)
                instance = springCtx.getBean(AuthenticationService::class.java)
            }
            return instance!!
        }
    }
}
