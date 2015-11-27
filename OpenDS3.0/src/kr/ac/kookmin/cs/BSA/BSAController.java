package kr.ac.kookmin.cs.BSA;

import kr.ac.kookmin.cs.hud.event.ActionEvent;
import eu.opends.main.Simulator;

public class BSAController{
	private BSAView bsaView;
	private BSAModel bsaModel;

	public BSAController(Simulator sim)
	{
		bsaModel = new BSAModel();
		bsaView = new BSAView(sim, bsaModel);
	}

	public void eventHandler(ActionEvent event)
	{
		BSAActionEvent ev = (BSAActionEvent)event;
		switch(ev.getActionName()) {
		case "alertType":
			bsaModel.setAlertType(ev.getAlertType());
			break;
		}

		bsaView.update();
	}

	public BSAView getBSAView() { return bsaView; }
}
