package framesystem;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import lib.Calculation_lib;
import lib.MM1_lib;
import lib.MMS_lib;

public class FrameSystemView extends Frame implements ActionListener, WindowListener{
	
	private TextField text1 = new TextField("",10);
	private TextField text2 = new TextField("",10);
	private TextField text3 = new TextField("",10);
	private Button button1 = new Button("足し算");  //フィールド
	private Label  label=new Label("答え");
	
	//MM1用
	private TextField m1 = new TextField("",5);
	private TextField m2 = new TextField("",5);
	private TextField ms = new TextField("",5);             //ms:窓口数用のテキストフィールド
	private TextField m3 = new TextField("",5);
	private Button bm = new Button("M/M/s");

	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		setTitle("FrameSystem");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(text1);
		add(text2);
		add(button1);   //コンポーネントを（コンストラクタに？）登録
		add(label);
		add(text3);
		button1.addActionListener(this);   //ボタンを押すとactionPerformed関数が呼び出される
		//MM1用
		add(new Label("λ"));
		add (m1);
		add(new Label("μ"));
		add (m2);
		add(new Label("窓口数"));           //入力項目：λ、μ、窓口数
		add (ms);
		add(bm);
		add(new Label("平均系内人数"));      //出力項目：平均系内人数
		add (m3);
		bm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1){
			int val1=Integer.parseInt(text1.getText());   //text1というインスタンスにはgetText()というメソッドがある
			int val2=Integer.parseInt(text2.getText());   //テキストフォーム（テキストフィールド）に入力された値はテキストとして扱われるので、数値に変換してval1,val2に格納
			//text3.setText(String.valueOf(val1+val2));   //◆text3というフィールドにsetText()メソッドで答えを書きこむ/text3というインスタンスにはsetText()というメソッドがある
			                                              //→text3はフィールドであり、インスタンスでもある　　　◆さらに、val1+val2の値を文字列として渡している
			Calculation_lib clib = new Calculation_lib(val1,val2);
			text3.setText(String.valueOf(clib.getPlus()));
		}
		else if(e.getSource()==bm){
			double lambda=Double.parseDouble(m1.getText());  
			double mu=Double.parseDouble(m2.getText());
			int s=Integer.parseInt(ms.getText());           //テキストフィールドmsに文字列として入力された数値を整数型に変換して整数型の変数sに格納
			MMS_lib mms=new MMS_lib(lambda,mu,s);          //double型、int型にそれぞれ変換された入力項目λ（lambda)、μ(mu)、窓口数(s)を引数としてインスタンスmmsのコンストラクタに渡す
			m3.setText(String.valueOf(mms.getW()));
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
