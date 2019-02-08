package application;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	static int[] arr = new int[5];
	@FXML
	private Label lblMas;
	@FXML
	private TextField posEd;
	@FXML
	private TextField elemEd;
	@FXML
	private TextField posDel;

	@FXML
	public void btnCreate() {
		lblMas.setText("");
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10);
		}
		for (int i = 0; i < arr.length; i++) {
			lblMas.setText(lblMas.getText() + arr[i] + " ");
		}
	}

	@FXML
	public void btnAdd() {
		int[] bufArr = new int[arr.length + 1];
		int pos = 0, elem = 0;

		lblMas.setText("");

		pos = Integer.valueOf(posEd.getText());

		elem = Integer.valueOf(elemEd.getText());

		for (int i = 0; i < pos - 1; i++) {
			bufArr[i] = arr[i];
		}
		bufArr[pos - 1] = elem;
		for (int i = pos; i < bufArr.length; i++) {
			bufArr[i] = arr[i - 1];
		}

		for (int i = 0; i < bufArr.length; i++) {
			lblMas.setText(lblMas.getText() + bufArr[i] + " ");
		}

	}

	@FXML
	public void btnDelete() {
		int[] bufArr = new int[arr.length - 1];
		int pos = 0;

		lblMas.setText("");

		pos = Integer.valueOf(posDel.getText());

		for (int i = 0; i < pos - 1; i++) {
			bufArr[i] = arr[i];
		}

		for (int i = pos; i < bufArr.length + 1; i++) {
			bufArr[i - 1] = arr[i];
		}

		for (int i = 0; i < bufArr.length; i++) {
			lblMas.setText(lblMas.getText() + bufArr[i] + " ");
		}
	}
}
