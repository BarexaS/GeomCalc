package calc.services.versions;

import java.io.IOException;

/**
 * Services version control
 */
public interface VersionService {
    String getVersion() throws IOException;
}
