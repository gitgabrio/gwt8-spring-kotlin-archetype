#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("${artifactId}Initializer")
package ${package}.server.spring

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet
import ${package}.server.utils.PropertiesLoader
import org.slf4j.LoggerFactory
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext
import javax.servlet.ServletException

/**
 * The type `${artifactId}Initializer`.
 */
open class ${artifactId}Initializer : WebApplicationInitializer {

    /**
     * On startup.

     * @param container the container
     * *
     * @throws `ServletException` the servlet exception
     */
    @Throws(ServletException::class)
    override fun onStartup(container: ServletContext) {
        logger.debug("${artifactId}Initializer")
        val ctx = context
        ctx.register(Config::class.java)
        ctx.servletContext = container
        // Mapping Spring dispatcher
        val springDispatcher = container.addServlet("spring-dispatcher", DispatcherServlet(ctx))
        springDispatcher.setLoadOnStartup(0)
        springDispatcher.addMapping("*.rpc", "/downloader/*")
        // Mapping GWT requestFactory servlet
        val requestFactoryServlet = container.addServlet("requestFactoryServlet", RequestFactoryServlet())
        requestFactoryServlet.setLoadOnStartup(1)
        requestFactoryServlet.addMapping("/gwtRequest")
        requestFactoryServlet.setInitParameter("symbolMapsDirectory", "WEB-INF/deploy/${artifactId}}/symbolMaps")
        container.addListener(ContextLoaderListener(ctx))
    }

    /**
     * Gets context.

     * @return the context
     */
    private val context: AnnotationConfigWebApplicationContext
        get() {
            val toReturn = AnnotationConfigWebApplicationContext()
            toReturn.setConfigLocation("${package}.server.spring")
            val prop = propertiesLoader.load("application.properties")
            toReturn.environment.setActiveProfiles(prop.getProperty("spring.profiles", "dev"))
            return toReturn
        }

    companion object {


        /**
         * The constant `Logger` logger.
         */
        private val logger = LoggerFactory.getLogger(WebApplicationInitializer::class.java)

        /**
         * The constant `PropertiesLoader` propertiesLoader.
         */
        private val propertiesLoader = PropertiesLoader()
    }

}