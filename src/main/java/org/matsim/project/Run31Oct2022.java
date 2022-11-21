package org.matsim.project;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.AbstractModule;
import org.matsim.core.controler.ControlerI;
import org.matsim.core.controler.Injector;

public class Run31Oct2022 {

        public static void main(String[] args) {
            Config config;

//            injector = injector.createInjector ( filename: "scenarios/equil/config.xml" );

            config = ConfigUtils.loadConfig("scenarios/equil/config.xml");

            AbstractModule module = new AbstractModule(){
                @Override public void install (){
                    bind(Abc.class).to(AbcImpl2.class);
                    bind(Helper.class).to(HelperImpl.class);
                }
            };

            com.google.inject.Injector injector = Injector.createInjector(config, module);

            Abc abc = injector.getInstance(Abc.class);

            abc.doSomething();

            ControlerI controlerI = injector.getInstance(ControlerI.class);
            controlerI.run();


        }
interface Abc {
    void doSomething();
}

interface Helper {
            void help();

}

private static class AbcImpl2 implements Abc{

    @Override
    public void doSomething() {
        System.out.println("whatever");
    }
}
private static class HelperImpl implements Helper{
    @Override
    public void help(){
                System.out.println("heeelp1!1!1!!");
            };
}
}
