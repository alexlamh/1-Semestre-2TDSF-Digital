package br.com.fiap.ws.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;

import br.com.fiap.ws.service.CorreiosService;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCepOrigem;
	private Text txtCepDestino;
	private Text txtPrazo;
	private Text txtData;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblCepOrigem = new Label(shell, SWT.NONE);
		lblCepOrigem.setBounds(30, 32, 96, 15);
		lblCepOrigem.setText("CEP Origem");
		
		txtCepOrigem = new Text(shell, SWT.BORDER);
		txtCepOrigem.setBounds(30, 52, 76, 21);
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setBounds(163, 32, 76, 15);
		lblCepDestino.setText("CEP Destino");
		
		txtCepDestino = new Text(shell, SWT.BORDER);
		txtCepDestino.setBounds(163, 52, 76, 21);
		
		Button btnCalcularPrazo = new Button(shell, SWT.NONE);
		btnCalcularPrazo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					CorreiosService service = new CorreiosService();
					String cepOrigem = txtCepOrigem.getText();
					String cepDestino = txtCepDestino.getText();
					CServico c = service.calcularPrazo(cepOrigem, cepDestino);
					txtData.setText(c.getDataMaxEntrega());
					txtPrazo.setText(String.valueOf(c.getPrazoEntrega()));
				}catch(Exception e1) {
					txtData.setText(e1.getMessage());
				}
			}
		});
		btnCalcularPrazo.setBounds(267, 50, 96, 25);
		btnCalcularPrazo.setText("Calcular Prazo");
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setBounds(30, 128, 55, 15);
		lblPrazo.setText("Prazo");
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setEnabled(false);
		txtPrazo.setBounds(112, 125, 76, 21);
		
		Label lblDataPrevista = new Label(shell, SWT.NONE);
		lblDataPrevista.setBounds(30, 170, 76, 15);
		lblDataPrevista.setText("Data Prevista");
		
		txtData = new Text(shell, SWT.BORDER);
		txtData.setEnabled(false);
		txtData.setBounds(112, 167, 76, 21);

	}
}
