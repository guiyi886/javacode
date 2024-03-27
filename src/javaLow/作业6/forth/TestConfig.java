package javaLow.作业6.forth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guiyi
 * @Date 2023/12/29 16:28:38
 * @ClassName javaLow.作业6.forth.TestConfig
 * @function -->
 */
public class TestConfig {
    Config config;

    @BeforeEach
    public void setUp() {
        this.config = new Config();
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindows() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testLinuxAndMac() {
        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
    }
}
