import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainJFrame extends JFrame {
    private Container cp;
    private   String tmp = "";
    private JButton jbtns[] = new JButton[9];
    private JTextField jtf = new JTextField();
    private JPanel jan = new JPanel(new GridLayout(3,3,3,3));

    public LoginJFrame lgjf = new LoginJFrame();
    public MainJFrame(LoginJFrame lgjf1){
        lgjf=lgjf1;
        initComp();
    }
    public void initComp(){
        setBounds(50,50,400,500);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        jtf.setEditable(false);
        for(int i=0;i<9;i++){
            jbtns[i]=new JButton(Integer.toString(i));

            String x =Integer.toString(i);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tmp=tmp+x;
                    jtf.setText(tmp);
                }
            });
        }
        Random ran = new Random();
        int x;
        int data[]=new int[10];
        for(int i=0;i<9;i++){
            x=ran.nextInt(9);
            data[i]=x;
            jan.add(jbtns[x]);
            for(int j=0;j<i;j++){
                if(data[j]==data[i]){
                    i--;
                }
            }
        }
        cp.add(jtf,BorderLayout.NORTH);
        cp.add(jan,BorderLayout.CENTER);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lgjf.setVisible(true);
            }
        });
    }
}
