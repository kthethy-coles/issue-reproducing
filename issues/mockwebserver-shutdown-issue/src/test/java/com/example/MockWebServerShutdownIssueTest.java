package com.example;

import okhttp3.mockwebserver.MockWebServer;
import java.io.IOException;

public class MockWebServerShutdownIssueTest {

    public void testServerClose() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        
        mockWebServer.start();

        // Perform tests...
        
        // ISSUE: When migrating to mockwebserver3.MockWebServer using OpenRewrite,
        // this call to shutdown() fails to rewrite to close().
        // mockwebserver3.MockWebServer implements Closeable and uses close().
        mockWebServer.shutdown();
    }
}
