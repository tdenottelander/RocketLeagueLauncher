package test.java.launcher.configmodifier;

import main.java.launcher.configmodifier.ConfigModifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigModifierTest
{

    private static ConfigModifier configModifier;

    @BeforeAll
    public static void init(){
        configModifier = new ConfigModifier("src/test/resources/DummyInput.ini");
    }

    /**
     * Tests whether the file is loaded correctly.
     */
    @Test
    public void loadFileTest(){
        File file = new File("src/test/resources/TASystemSettings.ini");
        ConfigModifier cm = new ConfigModifier("src/test/resources/TASystemSettings.ini");
        assertEquals(file, cm.getFile());
    }

    /**
     * Tests whether the changing of the content happens properly
     */
    @Test
    public void changeContentTest(){
        File file = new File("src/test/resources/DummyInput.ini");
        String result = "[SystemSettings]\n" +
            "PreShadowFadeResolution=16\n" +
            "ResX=1920\n" +
            "ResY=1080\n" +
            "Borderless=True";
        //configModifier.changeContent("src/test/resources/DummyInput.ini", "src/test/resources/DummyOutput.ini");

        //assert

        //clean up
    }
}
