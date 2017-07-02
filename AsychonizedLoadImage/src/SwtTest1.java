import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SwtTest1 {

	public static void main(String[] args) {
		Display display = new Display();
		
		Shell shell = new Shell(display, SWT.DIALOG_TRIM);
		shell.setLayout(new GridLayout(1,false));
		PageByComposite comp = new PageByComposite(shell, SWT.NONE);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(display.readAndDispatch()) {
			  display.sleep();
			}
		}
		display.dispose();
	}

}
