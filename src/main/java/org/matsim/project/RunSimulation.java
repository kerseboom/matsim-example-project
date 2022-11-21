package org.matsim.project;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

class RunSimulation {


    public static void main(String[] args) {
        Helper helper = new HelperDefaultImpl();
        Simulation simulation = new SimulationDefaultImpl(helper);
        simulation.doStep();

        AbstractModule module = new AbstractModule() {
            AbstractModule module = new AbstractModule() {
                @Override
                protected void configure() {
                    bind(Simulation.class).to(SimulationDefaultImpl.class);
                    bind(Helper.class).to(HelperDefaultImpl.class);
                }
            };
            Injector injector = Guice.createInjector(module);
            Simulation instance = injector.getInstance(Simulation.class);
        };
    }
    interface Simulation {
        void doStep();
    }

    static class HelperDefaultImpl implements Helper {
        public void help() {
            System.out.println(this.getClass().getSimpleName() + " is helping");
        }
    }

    static class SimulationDefaultImpl implements Simulation {
        private final Helper helper;
        @Inject
        SimulationDefaultImpl(Helper helper) {
            this.helper = helper;
        }

        public void doStep() {
            System.out.println("entering " + this.getClass().getSimpleName());
            helper.help();
            System.out.println("leaving " + this.getClass().getSimpleName());
        }
    }
}
