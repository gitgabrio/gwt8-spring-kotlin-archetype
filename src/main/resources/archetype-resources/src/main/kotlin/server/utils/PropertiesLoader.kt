#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("PropertiesLoader")
package ${package}.server.utils

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.util.Properties

/**
 * The type `PropertiesLoader`.
 */
class PropertiesLoader {

    /**
     * Load properties.

     * @param fileName the file name
     * *
     * @return the properties
     */
    fun load(fileName: String): Properties {
        val prop = Properties()
        var im: InputStream? = null
        try {
            im = findFile(fileName)
            prop.load(im)
        } catch (ignore: IOException) {
        } finally {
            if (im != null) {
                try {
                    im.close()
                } catch (ignore: IOException) {
                }

            }
        }
        return prop
    }

    /**
     * Find file input stream.

     * @param fileName the file name
     * *
     * @return the input stream
     * *
     * @throws `FileNotFoundException` the file not found exception
     */
    @Throws(FileNotFoundException::class)
    private fun findFile(fileName: String): InputStream {
        var im = findInWorkingDirectory(fileName)
        if (im == null) im = findInClasspath(fileName)
        if (im == null) im = findInSourceDirectory(fileName)
        if (im == null) throw FileNotFoundException(String.format("File %s not found", fileName))
        return im
    }

    /**
     * Find in source directory input stream.

     * @param fileName the file name
     * *
     * @return the input stream
     * *
     * @throws `FileNotFoundException` the file not found exception
     */
    @Throws(FileNotFoundException::class)
    private fun findInSourceDirectory(fileName: String): InputStream {
        return FileInputStream("src/main/resources/" + fileName)
    }

    /**
     * Find in classpath input stream.

     * @param fileName the file name
     * *
     * @return the input stream
     */
    private fun findInClasspath(fileName: String): InputStream {
        return Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)
    }

    /**
     * Find in working directory input stream.

     * @param fileName the file name
     * *
     * @return the input stream
     */
    private fun findInWorkingDirectory(fileName: String): InputStream? {
        try {
            return FileInputStream(System.getProperty("user.dir") + fileName)
        } catch (e: FileNotFoundException) {
            return null
        }

    }

}