package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import http.*;

public class MainController {
	@FXML
	private TextField tfUrl;
	@FXML
	private TextArea taResult;
	@FXML
	private Button rbScan;

	@FXML
	private RadioButton rbQuick;
	@FXML
	private RadioButton rbPing;

	@FXML
	private RadioButton rbGet;
	@FXML
	private RadioButton rbHead;

	public void runHttpScan(ActionEvent event) {
		if (rbGet.isSelected()) {
			long time = HttpGet.useHttpGet(tfUrl.getText());
			taResult.setText("Time (ms) : " + time);
		}

		if (rbHead.isSelected()) {
			long time = HttpHead.useHttpHead(tfUrl.getText());
			taResult.setText("Time (ms) : " + time);
		}

		if (rbQuick.isSelected()) {
			long time = HttpQuick.useHttpQuick(tfUrl.getText());
			taResult.setText("Time (ms) : " + time);
		}

		if (rbPing.isSelected()) {
			long time = HttpPing.httpRuntime(tfUrl.getText());
			taResult.setText("Time (ms) : " + time);
		}
	}
}
