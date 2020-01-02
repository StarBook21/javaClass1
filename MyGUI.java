import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
public class MyGUI {
   public static void main(String[] args) {
     BannerMaker gui = new BannerMaker();
	   gui.setVisible(true);
  }
}
class BannerMaker extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    private Container contentPane;
    private JTextField theText;
    private JTextField textSize;
    public BannerMaker(){
      super();
      setSize(WIDTH, HEIGHT);
      setTitle("Banner Maker");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());

      JPanel textSizePanel = new JPanel();
      textSize = new JTextField(2);
      JButton size = new JButton("Size");
      textSizePanel.add(textSize);
      textSizeListener sizeButton = new textSizeListener(this);
      size.addActionListener(sizeButton);
      textSizePanel.add(size);
      contentPane.add(textSizePanel, BorderLayout.NORTH);


      JPanel textPanel = new JPanel();
      textPanel.setBackground(Color.GRAY);
      theText = new JTextField(40);
      textPanel.add(theText);
      contentPane.add(textPanel, BorderLayout.CENTER);

      JPanel colorButtonPanel = new JPanel();
      JButton red = new JButton("Red");
      ColorButtonListener redButton = new ColorButtonListener(this);
      red.setBackground(Color.RED);
      red.addActionListener(redButton);
      colorButtonPanel.add(red);

      JButton orange = new JButton("Orange");
      ColorButtonListener orangeButton = new ColorButtonListener(this);
      orange.setBackground(Color.ORANGE);
      orange.addActionListener(orangeButton);
      colorButtonPanel.add(orange);

      JButton yellow = new JButton("Yellow");
      ColorButtonListener yellowButton = new ColorButtonListener(this);
      yellow.setBackground(Color.YELLOW);
      yellow.addActionListener(yellowButton);
      colorButtonPanel.add(yellow);

      JButton green = new JButton("Green");
      ColorButtonListener greenButton = new ColorButtonListener(this);
      green.setBackground(Color.GREEN);
      green.addActionListener(greenButton);
      colorButtonPanel.add(green);

      JButton blue = new JButton("Blue");
      ColorButtonListener blueButton = new ColorButtonListener(this);
      blue.setBackground(Color.BLUE);
      blue.addActionListener(blueButton);
      colorButtonPanel.add(blue);

      JButton magenta = new JButton("Magenta");
      ColorButtonListener magentaButton = new ColorButtonListener(this);
      magenta.setBackground(Color.MAGENTA);
      magenta.addActionListener(magentaButton);
      colorButtonPanel.add(magenta);

      colorButtonPanel.setLayout(new GridLayout(1,6));
      contentPane.add(colorButtonPanel, BorderLayout.SOUTH);

      JPanel fontButtonPanel = new JPanel();

      JButton serif = new JButton("Serif");
      FontButtonListener serifButton = new FontButtonListener(this);
      serif.addActionListener(serifButton);
      fontButtonPanel.add(serif);

      JButton sansSerif = new JButton("Sans Serif");
      FontButtonListener sansSerifButton = new FontButtonListener(this);
      sansSerif.addActionListener(sansSerifButton);
      fontButtonPanel.add(sansSerif);

      fontButtonPanel.setLayout(new GridLayout(2,1));
      contentPane.add(fontButtonPanel, BorderLayout.WEST);

      JPanel styleButtonPanel = new JPanel();

      JButton bold = new JButton("Bold");
      StyleButtonListener boldButton = new StyleButtonListener(this);
      bold.addActionListener(boldButton);
      styleButtonPanel.add(bold);

      JButton italic = new JButton("Italic");
      StyleButtonListener italicButton = new StyleButtonListener(this);
      italic.addActionListener(italicButton);
      styleButtonPanel.add(italic);

      JButton plain = new JButton("Plain");
      StyleButtonListener plainButton = new StyleButtonListener(this);
      plain.addActionListener(plainButton);
      styleButtonPanel.add(plain);

      styleButtonPanel.setLayout(new GridLayout(3,1));
      contentPane.add(styleButtonPanel, BorderLayout.EAST);
  }
  public JTextField getTextField(){
    return theText;
  }
  public int getTextSize() {
	  String convert =  textSize.getText();
	  int size = Integer.parseInt(convert);
	  return size;
  }
}
class ColorButtonListener implements ActionListener{
  private BannerMaker gui;
  public ColorButtonListener(BannerMaker g){
      gui = g;
  }
  @Override
	public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if(command.equals("Red"))gui.getTextField().setBackground(Color.RED);
    if(command.equals("Orange"))gui.getTextField().setBackground(Color.ORANGE);
    if(command.equals("Yellow"))gui.getTextField().setBackground(Color.YELLOW);
    if(command.equals("Green"))gui.getTextField().setBackground(Color.GREEN);
    if(command.equals("Blue"))gui.getTextField().setBackground(Color.BLUE);
    if(command.equals("Magenta"))gui.getTextField().setBackground(Color.MAGENTA);
  }
}
class StyleButtonListener implements ActionListener{
  private BannerMaker gui;
  public StyleButtonListener(BannerMaker g){
      gui = g;
  }
  @Override
	public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    Font p = new Font(gui.getTextField().getFont().getName(), Font.PLAIN, gui.getTextField().getFont().getSize());
    Font b = new Font(gui.getTextField().getFont().getName(), Font.BOLD, gui.getTextField().getFont().getSize());
    Font i = new Font(gui.getTextField().getFont().getName(), Font.ITALIC, gui.getTextField().getFont().getSize());
    if(command.equals("Plain"))gui.getTextField().setFont(p);
    if(command.equals("Bold"))gui.getTextField().setFont(b);
    if(command.equals("Italic"))gui.getTextField().setFont(i);
  }
}
class FontButtonListener implements ActionListener{
  private BannerMaker gui;
  public FontButtonListener(BannerMaker g){
      gui = g;
  }
  @Override
	public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    Font s = new Font(Font.SERIF, gui.getTextField().getFont().getStyle(), gui.getTextField().getFont().getSize());
    Font ss = new Font(Font.SANS_SERIF, gui.getTextField().getFont().getStyle(), gui.getTextField().getFont().getSize());
    if(command.equals("Serif"))gui.getTextField().setFont(s);
    if(command.equals("Sans Serif"))gui.getTextField().setFont(ss);
  }
}
  class textSizeListener implements ActionListener{
	  private BannerMaker gui;
	  public textSizeListener(BannerMaker g) {
		  gui = g;
	  }
	  @Override
		public void actionPerformed(ActionEvent e) {
		  String command = e.getActionCommand();
		  Font resize = new Font(gui.getTextField().getFont().getName(), gui.getTextField().getFont().getStyle(), gui.getTextSize());
		  if(command.equals("Size")) {
			  gui.getTextField().setFont(resize);
		  }
	  }
}
