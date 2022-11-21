package org.matsim.project;
import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Node;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.*;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.vehicles.Vehicle;

public class Run14Nov {
    public static void main(String[] args) {
        Config config  = ConfigUtils.loadConfig("scenarios/equil/config.xml");


        config.controler().setLastIteration(2);
        config.controler().setOverwriteFileSetting( OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists);

        Scenario scenario = ScenarioUtils.loadScenario(config);

        var nf = scenario.getNetwork().getFactory();
        {
            Id<Node> id = null;
            Coord coord = null;
            nf.createNode(id, coord);
        }
        {
            Id <Link> id = null;
            Node fromNode = null;
            Node toNode = null;
            nf.createLink(id, fromNode, toNode);

        }


        Controler controler = new Controler(scenario);

        controler.run();
    }
}
