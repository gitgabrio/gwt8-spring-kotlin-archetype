#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("Config")
package ${package}.server.spring


import org.springframework.context.annotation.*
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.web.servlet.HandlerMapping
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping


/**
 * The type Config.
 */
@EnableWebMvc
@Configuration
@ComponentScan("${package}")
@PropertySource("classpath:application.properties")
open class Config {


    /**
     * This is needed for @Value configuration to work properly
     *
     * @return property sources placeholder configurer
     */
    companion object {
        @Bean
        @JvmStatic open fun propertyPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
            return PropertySourcesPlaceholderConfigurer()
        }
    }

    /**
     * Handler mapping handler mapping.
     *
     * @return the handler mapping
     */
    @Bean
    open fun handlerMapping(): HandlerMapping {
        val toReturn : RequestMappingHandlerMapping = RequestMappingHandlerMapping()
        toReturn.setAlwaysUseFullPath(true)
        toReturn.setUseRegisteredSuffixPatternMatch(true)
        return toReturn
    }
}
