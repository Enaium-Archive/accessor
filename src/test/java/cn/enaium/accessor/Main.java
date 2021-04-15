package cn.enaium.accessor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Enaium
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Accessor.addConfiguration("accessor.config.json");

        File Test = new File("build/classes/java/test/cn/enaium/accessor/Test.class").getAbsoluteFile();
        Files.write(Test.toPath(), Accessor.transform(Files.readAllBytes(Test.toPath())));
        Test test = new Test();
        ((ITest) test).setName("Name");
        System.out.println(((ITest) test).getName());
        ((ITest) test).InvokeRender("render");
    }
}
