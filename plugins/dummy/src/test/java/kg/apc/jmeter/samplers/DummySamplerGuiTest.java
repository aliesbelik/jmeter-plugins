package kg.apc.jmeter.samplers;

import kg.apc.emulators.TestJMeterUtils;
import org.apache.jmeter.gui.AbstractJMeterGuiComponent;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.JMeterUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class DummySamplerGuiTest {
    @BeforeClass
    public static void setUpClass() {
        TestJMeterUtils.createJmeterEnv();
    }

    @Test
    public void displayGUI() throws InterruptedException {
        if (!GraphicsEnvironment.isHeadless()) {
            JMeterUtils.setProperty("search_paths", System.getProperty("user.home") + "/.m2/repository/org/apache/jmeter/ApacheJMeter_core/2.13");

            DummySamplerGui obj = new DummySamplerGui();
            DummySampler te = (DummySampler) obj.createTestElement();
            obj.configure(te);
            obj.clearGui();
            obj.modifyTestElement(te);

            JFrame frame = new JFrame(obj.getStaticLabel());

            frame.setPreferredSize(new Dimension(1024, 768));
            frame.getContentPane().add(obj, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);

            while (frame.isVisible()) {
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void testGetStaticLabel() {
        System.out.println("getStaticLabel");
        DummySamplerGui instance = new DummySamplerGui();
        String result = instance.getStaticLabel();
        Assert.assertTrue(result.length() > 0);
    }

    @Test
    public void testConfigure() {
        System.out.println("configure");
        TestElement element = new DummySampler();
        DummySamplerGui instance = new DummySamplerGui();
        instance.configure(element);
    }

    @Test
    public void testCreateTestElement() {
        System.out.println("createTestElement");
        DummySamplerGui instance = new DummySamplerGui();
        TestElement result = instance.createTestElement();
        Assert.assertNotNull(result);
    }

    @Test
    public void testModifyTestElement() {
        System.out.println("modifyTestElement");
        TestElement sampler = new DummySampler();
        DummySamplerGui instance = new DummySamplerGui();
        instance.modifyTestElement(sampler);
    }

    @Test
    public void testClearGui() {
        System.out.println("clearGui");
        DummySamplerGui instance = new DummySamplerGui();
        instance.clearGui();
    }

    @Test
    public void testGetLabelResource() {
        System.out.println("getLabelResource");
        DummySamplerGui instance = new DummySamplerGui();
        String expResult = "DummySamplerGui";
        String result = instance.getLabelResource();
        Assert.assertEquals(expResult, result);
    }
}
