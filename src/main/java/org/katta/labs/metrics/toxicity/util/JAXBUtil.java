package org.katta.labs.metrics.toxicity.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBUtil {

    public static <T> T load(Class<T> rootClass, String filePath) {

        try {
            JAXBContext context = JAXBContext.newInstance(rootClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(filePath));
        } catch (Exception e) {
            System.err.println("Error loading the file : " + filePath);
            e.printStackTrace();
        }

        return null;
    }
}
