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
	private Button button1 = new Button("�����Z");  //�t�B�[���h
	private Label  label=new Label("����");
	
	//MM1�p
	private TextField m1 = new TextField("",5);
	private TextField m2 = new TextField("",5);
	private TextField ms = new TextField("",5);             //ms:�������p�̃e�L�X�g�t�B�[���h
	private TextField m3 = new TextField("",5);
	private Button bm = new Button("M/M/s");

	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		setTitle("FrameSystem");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(text1);
		add(text2);
		add(button1);   //�R���|�[�l���g���i�R���X�g���N�^�ɁH�j�o�^
		add(label);
		add(text3);
		button1.addActionListener(this);   //�{�^����������actionPerformed�֐����Ăяo�����
		//MM1�p
		add(new Label("��"));
		add (m1);
		add(new Label("��"));
		add (m2);
		add(new Label("������"));           //���͍��ځF�ɁA�ʁA������
		add (ms);
		add(bm);
		add(new Label("���όn���l��"));      //�o�͍��ځF���όn���l��
		add (m3);
		bm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1){
			int val1=Integer.parseInt(text1.getText());   //text1�Ƃ����C���X�^���X�ɂ�getText()�Ƃ������\�b�h������
			int val2=Integer.parseInt(text2.getText());   //�e�L�X�g�t�H�[���i�e�L�X�g�t�B�[���h�j�ɓ��͂��ꂽ�l�̓e�L�X�g�Ƃ��Ĉ�����̂ŁA���l�ɕϊ�����val1,val2�Ɋi�[
			//text3.setText(String.valueOf(val1+val2));   //��text3�Ƃ����t�B�[���h��setText()���\�b�h�œ�������������/text3�Ƃ����C���X�^���X�ɂ�setText()�Ƃ������\�b�h������
			                                              //��text3�̓t�B�[���h�ł���A�C���X�^���X�ł�����@�@�@������ɁAval1+val2�̒l�𕶎���Ƃ��ēn���Ă���
			Calculation_lib clib = new Calculation_lib(val1,val2);
			text3.setText(String.valueOf(clib.getPlus()));
		}
		else if(e.getSource()==bm){
			double lambda=Double.parseDouble(m1.getText());  
			double mu=Double.parseDouble(m2.getText());
			int s=Integer.parseInt(ms.getText());           //�e�L�X�g�t�B�[���hms�ɕ�����Ƃ��ē��͂��ꂽ���l�𐮐��^�ɕϊ����Đ����^�̕ϐ�s�Ɋi�[
			MMS_lib mms=new MMS_lib(lambda,mu,s);          //double�^�Aint�^�ɂ��ꂼ��ϊ����ꂽ���͍��ڃɁilambda)�A��(mu)�A������(s)�������Ƃ��ăC���X�^���Xmms�̃R���X�g���N�^�ɓn��
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
