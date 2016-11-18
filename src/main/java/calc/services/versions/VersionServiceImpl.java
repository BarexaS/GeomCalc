package calc.services.versions;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class VersionServiceImpl implements VersionService {

    @Override
    public String getVersion() throws IOException {
        String key = "proj.version";
        String resourceName = "config.properties";

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);
        }
        return (String) props.get(key);
    }
}
