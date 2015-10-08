package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;
import eu.opends.tools.PanelCenter;

public class Toggle_record_data {
	public static void action(boolean value){
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value)
		{
			if (sim.getMyDataWriter() == null) {
				sim.initializeDataWriter(-1);
			}

			if (sim.getMyDataWriter().isDataWriterEnabled() == false) {
				System.out.println("Start storing Drive-Data");
				sim.getMyDataWriter().setDataWriterEnabled(true);
				PanelCenter.getStoreText().setText("S");
			} else {
				System.out.println("Stop storing Drive-Data");
				sim.getMyDataWriter().setDataWriterEnabled(false);
				PanelCenter.getStoreText().setText(" ");
			}
		}
	}
}
