import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;

public class PageByComposite extends Composite {

  private Button btnNewButton;
  private Button btnNewButton_1;
  private Button btnNewButton_2;
  private ExecutorService executor = Executors.newFixedThreadPool(3);

  public PageByComposite(Composite parent, int style) {
    super(parent, style);
    setLayout(new GridLayout(4, false));
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    Image image = new Image(Display.getCurrent(), "unavailable.png");
    btnNewButton = new Button(this, SWT.NONE);
    btnNewButton.setText("New Button");
    btnNewButton.setImage(image);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    
    btnNewButton_1 = new Button(this, SWT.NONE);
    btnNewButton_1.setText("New Button");
    btnNewButton_1.setImage(image);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    
    btnNewButton_2 = new Button(this, SWT.NONE);
    btnNewButton_2.setText("New Button");
    btnNewButton_2.setImage(image);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    new Label(this, SWT.NONE);
    Button previousBtn = new Button(this, SWT.NONE);
    previousBtn.setText("<");
    previousBtn.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        executor.shutdownNow();
      }
      
    });
    new Label(this, SWT.NONE);
    
    Button nextBtn = new Button(this, SWT.NONE);
    nextBtn.setText(">");
    nextBtn.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        executor = Executors.newFixedThreadPool(3);
        createAsychronezThreads();
      }
      
    });

    createAsychronezThreads();
  }

  private void createAsychronezThreads() {
    Image backgroundImage = new Image(Display.getDefault(), "d.jpg");
    Runnable worker1 = new AsychoronizedLoadImageTask(btnNewButton, backgroundImage , 3);
    executor.execute(worker1);
    Image backgroundImage2 = new Image(Display.getDefault(), "e.jpg");
    Runnable worker2 = new AsychoronizedLoadImageTask(btnNewButton_1, backgroundImage2 , 5);
    executor.execute(worker2);
    Image backgroundImage3 = new Image(Display.getDefault(), "f.jpg");
    Runnable worker3 = new AsychoronizedLoadImageTask(btnNewButton_2, backgroundImage3 , 8);
    executor.execute(worker3);
  }

  class AsychoronizedLoadImageTask implements Runnable {

    private final Button btn;
    private final Image image;
    private int timeUnit;
    
    public AsychoronizedLoadImageTask(Button btn, Image image, int timeUnit) {
      this.btn = btn;
      this.image = image;
      this.timeUnit = timeUnit;
    }
    

    @Override
    public void run() {
      // loading data
      try {
        TimeUnit.SECONDS.sleep(3);
        Display.getDefault().asyncExec(() -> {
          btn.setImage(image);
        });
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
  }
  
}
