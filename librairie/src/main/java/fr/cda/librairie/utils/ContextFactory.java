/**
 * 
 */
package fr.cda.librairie.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Permet le chargement du fichier de configuration de Spring
 * 
 * @author 
 * 
 */
public class ContextFactory {

    private static ApplicationContext applicationContext      = null;

    private static final String       PATH                    = "C:\\Java\\...\\";
    private static final String       APPLICATION_CONTEXT_XML = "spring/beans-configuration.xml";

    /**
     * Permet de charger le contexte selon le type fourni
     * 
     * @param typeConfig : le type de configuration initialiser
     * @return ApplicationContext initialise
     */
    public static ApplicationContext getContext(final fr.cda.librairie.utils.ContextConfigurationType typeConfig) {
        synchronized (fr.cda.librairie.utils.ContextFactory.class) {
            if (applicationContext == null) {
                if (fr.cda.librairie.utils.ContextConfigurationType.CLASSPATH.equals(typeConfig)) {
                    applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
                } else if (fr.cda.librairie.utils.ContextConfigurationType.FILE_SYSTEM.equals(typeConfig)) {
                    applicationContext = new FileSystemXmlApplicationContext(PATH + APPLICATION_CONTEXT_XML);
                } else {
                    System.err.println("Localisation non definie");
                }
            }
        }
        return applicationContext;
    }

}
