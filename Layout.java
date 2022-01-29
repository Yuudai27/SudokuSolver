import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 * The Board class is a JFrame layout, which provides the GUI for the user
 * and some functions to read and write data.
 *
 */
public class Layout extends JFrame implements KeyListener{

    @Serial
    private static final long serialVersionUID = 1L;
    private final ArrayList<JTextField> textFieldArray = new ArrayList<>();
    private final JLabel timeLabel = new JLabel("Solved in: ");
    JLabel validateLabel = new JLabel("Not validated!");
    private boolean solveButton = false;
    private boolean clearButton = false;


    /**
     * Creates the layout with its contentPanels, buttons and text fields.
     */
    public Layout() {
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 577, 526);
        JPanel contentPane = new JPanel();
        contentPane.setToolTipText("Sudoku Solver");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(45, 60, 40, 40);
        contentPane.add(textField);
        textField.setColumns(10);
        textFieldArray.add(textField);

        JTextField textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setColumns(10);
        textField_1.setBounds(45, 100, 40, 40);
        contentPane.add(textField_1);
        textFieldArray.add(textField_1);

        JTextField textField_2 = new JTextField();
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setColumns(10);
        textField_2.setBounds(45, 140, 40, 40);
        contentPane.add(textField_2);
        textFieldArray.add(textField_2);

        JTextField textField_3 = new JTextField();
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setColumns(10);
        textField_3.setBounds(85, 60, 40, 40);
        contentPane.add(textField_3);
        textFieldArray.add(textField_3);

        JTextField textField_4 = new JTextField();
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setColumns(10);
        textField_4.setBounds(85, 100, 40, 40);
        contentPane.add(textField_4);
        textFieldArray.add(textField_4);

        JTextField textField_5 = new JTextField();
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setColumns(10);
        textField_5.setBounds(85, 140, 40, 40);
        contentPane.add(textField_5);
        textFieldArray.add(textField_5);

        JTextField textField_6 = new JTextField();
        textField_6.setHorizontalAlignment(SwingConstants.CENTER);
        textField_6.setColumns(10);
        textField_6.setBounds(125, 60, 40, 40);
        contentPane.add(textField_6);
        textFieldArray.add(textField_6);

        JTextField textField_7 = new JTextField();
        textField_7.setHorizontalAlignment(SwingConstants.CENTER);
        textField_7.setColumns(10);
        textField_7.setBounds(125, 100, 40, 40);
        contentPane.add(textField_7);
        textFieldArray.add(textField_7);

        JTextField textField_8 = new JTextField();
        textField_8.setHorizontalAlignment(SwingConstants.CENTER);
        textField_8.setColumns(10);
        textField_8.setBounds(125, 140, 40, 40);
        contentPane.add(textField_8);
        textFieldArray.add(textField_8);

        JTextField textField_9 = new JTextField();
        textField_9.setHorizontalAlignment(SwingConstants.CENTER);
        textField_9.setColumns(10);
        textField_9.setBounds(45, 185, 40, 40);
        contentPane.add(textField_9);
        textFieldArray.add(textField_9);

        JTextField textField_10 = new JTextField();
        textField_10.setHorizontalAlignment(SwingConstants.CENTER);
        textField_10.setColumns(10);
        textField_10.setBounds(45, 225, 40, 40);
        contentPane.add(textField_10);
        textFieldArray.add(textField_10);

        JTextField textField_11 = new JTextField();
        textField_11.setHorizontalAlignment(SwingConstants.CENTER);
        textField_11.setColumns(10);
        textField_11.setBounds(45, 265, 40, 40);
        contentPane.add(textField_11);
        textFieldArray.add(textField_11);

        JTextField textField_12 = new JTextField();
        textField_12.setHorizontalAlignment(SwingConstants.CENTER);
        textField_12.setColumns(10);
        textField_12.setBounds(85, 185, 40, 40);
        contentPane.add(textField_12);
        textFieldArray.add(textField_12);

        JTextField textField_13 = new JTextField();
        textField_13.setHorizontalAlignment(SwingConstants.CENTER);
        textField_13.setColumns(10);
        textField_13.setBounds(85, 225, 40, 40);
        contentPane.add(textField_13);
        textFieldArray.add(textField_13);

        JTextField textField_14 = new JTextField();
        textField_14.setHorizontalAlignment(SwingConstants.CENTER);
        textField_14.setColumns(10);
        textField_14.setBounds(85, 265, 40, 40);
        contentPane.add(textField_14);
        textFieldArray.add(textField_14);

        JTextField textField_15 = new JTextField();
        textField_15.setHorizontalAlignment(SwingConstants.CENTER);
        textField_15.setColumns(10);
        textField_15.setBounds(125, 185, 40, 40);
        contentPane.add(textField_15);
        textFieldArray.add(textField_15);

        JTextField textField_16 = new JTextField();
        textField_16.setHorizontalAlignment(SwingConstants.CENTER);
        textField_16.setColumns(10);
        textField_16.setBounds(125, 225, 40, 40);
        contentPane.add(textField_16);
        textFieldArray.add(textField_16);

        JTextField textField_17 = new JTextField();
        textField_17.setHorizontalAlignment(SwingConstants.CENTER);
        textField_17.setColumns(10);
        textField_17.setBounds(125, 265, 40, 40);
        contentPane.add(textField_17);
        textFieldArray.add(textField_17);

        JTextField textField_18 = new JTextField();
        textField_18.setHorizontalAlignment(SwingConstants.CENTER);
        textField_18.setColumns(10);
        textField_18.setBounds(45, 310, 40, 40);
        contentPane.add(textField_18);
        textFieldArray.add(textField_18);

        JTextField textField_19 = new JTextField();
        textField_19.setHorizontalAlignment(SwingConstants.CENTER);
        textField_19.setColumns(10);
        textField_19.setBounds(45, 350, 40, 40);
        contentPane.add(textField_19);
        textFieldArray.add(textField_19);

        JTextField textField_20 = new JTextField();
        textField_20.setHorizontalAlignment(SwingConstants.CENTER);
        textField_20.setColumns(10);
        textField_20.setBounds(45, 390, 40, 40);
        contentPane.add(textField_20);
        textFieldArray.add(textField_20);

        JTextField textField_21 = new JTextField();
        textField_21.setHorizontalAlignment(SwingConstants.CENTER);
        textField_21.setColumns(10);
        textField_21.setBounds(85, 310, 40, 40);
        contentPane.add(textField_21);
        textFieldArray.add(textField_21);

        JTextField textField_22 = new JTextField();
        textField_22.setHorizontalAlignment(SwingConstants.CENTER);
        textField_22.setColumns(10);
        textField_22.setBounds(85, 350, 40, 40);
        contentPane.add(textField_22);
        textFieldArray.add(textField_22);

        JTextField textField_23 = new JTextField();
        textField_23.setHorizontalAlignment(SwingConstants.CENTER);
        textField_23.setColumns(10);
        textField_23.setBounds(85, 390, 40, 40);
        contentPane.add(textField_23);
        textFieldArray.add(textField_23);

        JTextField textField_24 = new JTextField();
        textField_24.setHorizontalAlignment(SwingConstants.CENTER);
        textField_24.setColumns(10);
        textField_24.setBounds(125, 310, 40, 40);
        contentPane.add(textField_24);
        textFieldArray.add(textField_24);

        JTextField textField_25 = new JTextField();
        textField_25.setHorizontalAlignment(SwingConstants.CENTER);
        textField_25.setColumns(10);
        textField_25.setBounds(125, 350, 40, 40);
        contentPane.add(textField_25);
        textFieldArray.add(textField_25);

        JTextField textField_26 = new JTextField();
        textField_26.setHorizontalAlignment(SwingConstants.CENTER);
        textField_26.setColumns(10);
        textField_26.setBounds(125, 390, 40, 40);
        contentPane.add(textField_26);
        textFieldArray.add(textField_26);

        JTextField textField_27 = new JTextField();
        textField_27.setHorizontalAlignment(SwingConstants.CENTER);
        textField_27.setColumns(10);
        textField_27.setBounds(170, 60, 40, 40);
        contentPane.add(textField_27);
        textFieldArray.add(textField_27);

        JTextField textField_28 = new JTextField();
        textField_28.setHorizontalAlignment(SwingConstants.CENTER);
        textField_28.setColumns(10);
        textField_28.setBounds(170, 100, 40, 40);
        contentPane.add(textField_28);
        textFieldArray.add(textField_28);

        JTextField textField_29 = new JTextField();
        textField_29.setHorizontalAlignment(SwingConstants.CENTER);
        textField_29.setColumns(10);
        textField_29.setBounds(170, 140, 40, 40);
        contentPane.add(textField_29);
        textFieldArray.add(textField_29);

        JTextField textField_30 = new JTextField();
        textField_30.setHorizontalAlignment(SwingConstants.CENTER);
        textField_30.setColumns(10);
        textField_30.setBounds(210, 60, 40, 40);
        contentPane.add(textField_30);
        textFieldArray.add(textField_30);

        JTextField textField_31 = new JTextField();
        textField_31.setHorizontalAlignment(SwingConstants.CENTER);
        textField_31.setColumns(10);
        textField_31.setBounds(210, 100, 40, 40);
        contentPane.add(textField_31);
        textFieldArray.add(textField_31);

        JTextField textField_32 = new JTextField();
        textField_32.setHorizontalAlignment(SwingConstants.CENTER);
        textField_32.setColumns(10);
        textField_32.setBounds(210, 140, 40, 40);
        contentPane.add(textField_32);
        textFieldArray.add(textField_32);

        JTextField textField_33 = new JTextField();
        textField_33.setHorizontalAlignment(SwingConstants.CENTER);
        textField_33.setColumns(10);
        textField_33.setBounds(250, 60, 40, 40);
        contentPane.add(textField_33);
        textFieldArray.add(textField_33);

        JTextField textField_34 = new JTextField();
        textField_34.setHorizontalAlignment(SwingConstants.CENTER);
        textField_34.setColumns(10);
        textField_34.setBounds(250, 100, 40, 40);
        contentPane.add(textField_34);
        textFieldArray.add(textField_34);

        JTextField textField_35 = new JTextField();
        textField_35.setHorizontalAlignment(SwingConstants.CENTER);
        textField_35.setColumns(10);
        textField_35.setBounds(250, 140, 40, 40);
        contentPane.add(textField_35);
        textFieldArray.add(textField_35);

        JTextField textField_36 = new JTextField();
        textField_36.setHorizontalAlignment(SwingConstants.CENTER);
        textField_36.setColumns(10);
        textField_36.setBounds(170, 185, 40, 40);
        contentPane.add(textField_36);
        textFieldArray.add(textField_36);

        JTextField textField_37 = new JTextField();
        textField_37.setHorizontalAlignment(SwingConstants.CENTER);
        textField_37.setColumns(10);
        textField_37.setBounds(170, 225, 40, 40);
        contentPane.add(textField_37);
        textFieldArray.add(textField_37);

        JTextField textField_38 = new JTextField();
        textField_38.setHorizontalAlignment(SwingConstants.CENTER);
        textField_38.setColumns(10);
        textField_38.setBounds(170, 265, 40, 40);
        contentPane.add(textField_38);
        textFieldArray.add(textField_38);

        JTextField textField_39 = new JTextField();
        textField_39.setHorizontalAlignment(SwingConstants.CENTER);
        textField_39.setColumns(10);
        textField_39.setBounds(210, 185, 40, 40);
        contentPane.add(textField_39);
        textFieldArray.add(textField_39);

        JTextField textField_40 = new JTextField();
        textField_40.setHorizontalAlignment(SwingConstants.CENTER);
        textField_40.setColumns(10);
        textField_40.setBounds(210, 225, 40, 40);
        contentPane.add(textField_40);
        textFieldArray.add(textField_40);

        JTextField textField_41 = new JTextField();
        textField_41.setHorizontalAlignment(SwingConstants.CENTER);
        textField_41.setColumns(10);
        textField_41.setBounds(210, 265, 40, 40);
        contentPane.add(textField_41);
        textFieldArray.add(textField_41);

        JTextField textField_42 = new JTextField();
        textField_42.setHorizontalAlignment(SwingConstants.CENTER);
        textField_42.setColumns(10);
        textField_42.setBounds(250, 185, 40, 40);
        contentPane.add(textField_42);
        textFieldArray.add(textField_42);

        JTextField textField_43 = new JTextField();
        textField_43.setHorizontalAlignment(SwingConstants.CENTER);
        textField_43.setColumns(10);
        textField_43.setBounds(250, 225, 40, 40);
        contentPane.add(textField_43);
        textFieldArray.add(textField_43);

        JTextField textField_44 = new JTextField();
        textField_44.setHorizontalAlignment(SwingConstants.CENTER);
        textField_44.setColumns(10);
        textField_44.setBounds(250, 265, 40, 40);
        contentPane.add(textField_44);
        textFieldArray.add(textField_44);

        JTextField textField_45 = new JTextField();
        textField_45.setHorizontalAlignment(SwingConstants.CENTER);
        textField_45.setColumns(10);
        textField_45.setBounds(170, 310, 40, 40);
        contentPane.add(textField_45);
        textFieldArray.add(textField_45);

        JTextField textField_46 = new JTextField();
        textField_46.setHorizontalAlignment(SwingConstants.CENTER);
        textField_46.setColumns(10);
        textField_46.setBounds(170, 350, 40, 40);
        contentPane.add(textField_46);
        textFieldArray.add(textField_46);

        JTextField textField_47 = new JTextField();
        textField_47.setHorizontalAlignment(SwingConstants.CENTER);
        textField_47.setColumns(10);
        textField_47.setBounds(170, 390, 40, 40);
        contentPane.add(textField_47);
        textFieldArray.add(textField_47);

        JTextField textField_48 = new JTextField();
        textField_48.setHorizontalAlignment(SwingConstants.CENTER);
        textField_48.setColumns(10);
        textField_48.setBounds(210, 310, 40, 40);
        contentPane.add(textField_48);
        textFieldArray.add(textField_48);

        JTextField textField_49 = new JTextField();
        textField_49.setHorizontalAlignment(SwingConstants.CENTER);
        textField_49.setColumns(10);
        textField_49.setBounds(210, 350, 40, 40);
        contentPane.add(textField_49);
        textFieldArray.add(textField_49);

        JTextField textField_50 = new JTextField();
        textField_50.setHorizontalAlignment(SwingConstants.CENTER);
        textField_50.setColumns(10);
        textField_50.setBounds(210, 390, 40, 40);
        contentPane.add(textField_50);
        textFieldArray.add(textField_50);

        JTextField textField_51 = new JTextField();
        textField_51.setHorizontalAlignment(SwingConstants.CENTER);
        textField_51.setColumns(10);
        textField_51.setBounds(250, 310, 40, 40);
        contentPane.add(textField_51);
        textFieldArray.add(textField_51);

        JTextField textField_52 = new JTextField();
        textField_52.setHorizontalAlignment(SwingConstants.CENTER);
        textField_52.setColumns(10);
        textField_52.setBounds(250, 350, 40, 40);
        contentPane.add(textField_52);
        textFieldArray.add(textField_52);

        JTextField textField_53 = new JTextField();
        textField_53.setHorizontalAlignment(SwingConstants.CENTER);
        textField_53.setColumns(10);
        textField_53.setBounds(250, 390, 40, 40);
        contentPane.add(textField_53);
        textFieldArray.add(textField_53);

        JTextField textField_54 = new JTextField();
        textField_54.setHorizontalAlignment(SwingConstants.CENTER);
        textField_54.setColumns(10);
        textField_54.setBounds(295, 60, 40, 40);
        contentPane.add(textField_54);
        textFieldArray.add(textField_54);

        JTextField textField_55 = new JTextField();
        textField_55.setHorizontalAlignment(SwingConstants.CENTER);
        textField_55.setColumns(10);
        textField_55.setBounds(295, 100, 40, 40);
        contentPane.add(textField_55);
        textFieldArray.add(textField_55);

        JTextField textField_56 = new JTextField();
        textField_56.setHorizontalAlignment(SwingConstants.CENTER);
        textField_56.setColumns(10);
        textField_56.setBounds(295, 140, 40, 40);
        contentPane.add(textField_56);
        textFieldArray.add(textField_56);

        JTextField textField_57 = new JTextField();
        textField_57.setHorizontalAlignment(SwingConstants.CENTER);
        textField_57.setColumns(10);
        textField_57.setBounds(335, 60, 40, 40);
        contentPane.add(textField_57);
        textFieldArray.add(textField_57);

        JTextField textField_58 = new JTextField();
        textField_58.setHorizontalAlignment(SwingConstants.CENTER);
        textField_58.setColumns(10);
        textField_58.setBounds(335, 100, 40, 40);
        contentPane.add(textField_58);
        textFieldArray.add(textField_58);

        JTextField textField_59 = new JTextField();
        textField_59.setHorizontalAlignment(SwingConstants.CENTER);
        textField_59.setColumns(10);
        textField_59.setBounds(335, 140, 40, 40);
        contentPane.add(textField_59);
        textFieldArray.add(textField_59);

        JTextField textField_60 = new JTextField();
        textField_60.setHorizontalAlignment(SwingConstants.CENTER);
        textField_60.setColumns(10);
        textField_60.setBounds(375, 60, 40, 40);
        contentPane.add(textField_60);
        textFieldArray.add(textField_60);

        JTextField textField_61 = new JTextField();
        textField_61.setHorizontalAlignment(SwingConstants.CENTER);
        textField_61.setColumns(10);
        textField_61.setBounds(375, 100, 40, 40);
        contentPane.add(textField_61);
        textFieldArray.add(textField_61);

        JTextField textField_62 = new JTextField();
        textField_62.setHorizontalAlignment(SwingConstants.CENTER);
        textField_62.setColumns(10);
        textField_62.setBounds(375, 140, 40, 40);
        contentPane.add(textField_62);
        textFieldArray.add(textField_62);

        JTextField textField_63 = new JTextField();
        textField_63.setHorizontalAlignment(SwingConstants.CENTER);
        textField_63.setColumns(10);
        textField_63.setBounds(295, 185, 40, 40);
        contentPane.add(textField_63);
        textFieldArray.add(textField_63);

        JTextField textField_64 = new JTextField();
        textField_64.setHorizontalAlignment(SwingConstants.CENTER);
        textField_64.setColumns(10);
        textField_64.setBounds(295, 225, 40, 40);
        contentPane.add(textField_64);
        textFieldArray.add(textField_64);

        JTextField textField_65 = new JTextField();
        textField_65.setHorizontalAlignment(SwingConstants.CENTER);
        textField_65.setColumns(10);
        textField_65.setBounds(295, 265, 40, 40);
        contentPane.add(textField_65);
        textFieldArray.add(textField_65);

        JTextField textField_66 = new JTextField();
        textField_66.setHorizontalAlignment(SwingConstants.CENTER);
        textField_66.setColumns(10);
        textField_66.setBounds(335, 185, 40, 40);
        contentPane.add(textField_66);
        textFieldArray.add(textField_66);

        JTextField textField_67 = new JTextField();
        textField_67.setHorizontalAlignment(SwingConstants.CENTER);
        textField_67.setColumns(10);
        textField_67.setBounds(335, 225, 40, 40);
        contentPane.add(textField_67);
        textFieldArray.add(textField_67);

        JTextField textField_68 = new JTextField();
        textField_68.setHorizontalAlignment(SwingConstants.CENTER);
        textField_68.setColumns(10);
        textField_68.setBounds(335, 265, 40, 40);
        contentPane.add(textField_68);
        textFieldArray.add(textField_68);

        JTextField textField_69 = new JTextField();
        textField_69.setHorizontalAlignment(SwingConstants.CENTER);
        textField_69.setColumns(10);
        textField_69.setBounds(375, 185, 40, 40);
        contentPane.add(textField_69);
        textFieldArray.add(textField_69);

        JTextField textField_70 = new JTextField();
        textField_70.setHorizontalAlignment(SwingConstants.CENTER);
        textField_70.setColumns(10);
        textField_70.setBounds(375, 225, 40, 40);
        contentPane.add(textField_70);
        textFieldArray.add(textField_70);

        JTextField textField_71 = new JTextField();
        textField_71.setHorizontalAlignment(SwingConstants.CENTER);
        textField_71.setColumns(10);
        textField_71.setBounds(375, 265, 40, 40);
        contentPane.add(textField_71);
        textFieldArray.add(textField_71);

        JTextField textField_72 = new JTextField();
        textField_72.setHorizontalAlignment(SwingConstants.CENTER);
        textField_72.setColumns(10);
        textField_72.setBounds(295, 310, 40, 40);
        contentPane.add(textField_72);
        textFieldArray.add(textField_72);

        JTextField textField_73 = new JTextField();
        textField_73.setHorizontalAlignment(SwingConstants.CENTER);
        textField_73.setColumns(10);
        textField_73.setBounds(295, 350, 40, 40);
        contentPane.add(textField_73);
        textFieldArray.add(textField_73);

        JTextField textField_74 = new JTextField();
        textField_74.setHorizontalAlignment(SwingConstants.CENTER);
        textField_74.setColumns(10);
        textField_74.setBounds(295, 390, 40, 40);
        contentPane.add(textField_74);
        textFieldArray.add(textField_74);

        JTextField textField_75 = new JTextField();
        textField_75.setHorizontalAlignment(SwingConstants.CENTER);
        textField_75.setColumns(10);
        textField_75.setBounds(335, 310, 40, 40);
        contentPane.add(textField_75);
        textFieldArray.add(textField_75);

        JTextField textField_76 = new JTextField();
        textField_76.setHorizontalAlignment(SwingConstants.CENTER);
        textField_76.setColumns(10);
        textField_76.setBounds(335, 350, 40, 40);
        contentPane.add(textField_76);
        textFieldArray.add(textField_76);

        JTextField textField_77 = new JTextField();
        textField_77.setHorizontalAlignment(SwingConstants.CENTER);
        textField_77.setColumns(10);
        textField_77.setBounds(335, 390, 40, 40);
        contentPane.add(textField_77);
        textFieldArray.add(textField_77);

        JTextField textField_78 = new JTextField();
        textField_78.setHorizontalAlignment(SwingConstants.CENTER);
        textField_78.setColumns(10);
        textField_78.setBounds(375, 310, 40, 40);
        contentPane.add(textField_78);
        textFieldArray.add(textField_78);

        JTextField textField_79 = new JTextField();
        textField_79.setHorizontalAlignment(SwingConstants.CENTER);
        textField_79.setColumns(10);
        textField_79.setBounds(375, 350, 40, 40);
        contentPane.add(textField_79);
        textFieldArray.add(textField_79);

        JTextField textField_80 = new JTextField();
        textField_80.setHorizontalAlignment(SwingConstants.CENTER);
        textField_80.setColumns(10);
        textField_80.setBounds(375, 390, 40, 40);
        contentPane.add(textField_80);
        textFieldArray.add(textField_80);

        timeLabel.setBounds(431, 445, 120, 14);
        contentPane.add(timeLabel);

        JButton btnNewButton = new JButton("Solve it!");
        btnNewButton.addActionListener(arg0 -> solveButton = true);
        btnNewButton.setBounds(180, 441, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.setBounds(55, 441, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Validate");
        btnNewButton_2.addActionListener(arg0 -> validateSudoku());
        btnNewButton_2.setBounds(305, 441, 89, 23);
        contentPane.add(btnNewButton_2);

        validateLabel.setBounds(432, 416, 120, 14);
        contentPane.add(validateLabel);
        btnNewButton_1.addActionListener(arg0 -> clearField());
        for(int x = 0; x < 81; x++) {
            textFieldArray.get(x).addKeyListener(this);
        }
    }
    /**
     * The validateSudoku function checks if in every row, column and field is every number from 1 to 9 exactly one time contained.
     */
    private void validateSudoku() {
        boolean validation = true;
        boolean test = true;
        int[] numberCheck = new int[9];
        //checking all rows if every number is just one time contained
        for(int w = 0; w < 3; w++) {
            for(int x = 0; x < 3; x++) {
                for(int y = 0; y < 3; y++) {
                    for(int z = 0; z < 3; z++) {
                        switch (textFieldArray.get(w * 9 + x + y * 27 + z * 3).getText()) {
                            case "1" -> numberCheck[0]++;
                            case "2" -> numberCheck[1]++;
                            case "3" -> numberCheck[2]++;
                            case "4" -> numberCheck[3]++;
                            case "5" -> numberCheck[4]++;
                            case "6" -> numberCheck[5]++;
                            case "7" -> numberCheck[6]++;
                            case "8" -> numberCheck[7]++;
                            case "9" -> numberCheck[8]++;
                            default -> {
                            }
                        }
                    }
                }
                //check through array if all sums are exactly 1
                for(int t = 0; t < 9; t++) {
                    if(numberCheck[t] != 1) {
                        test = false;
                        break;
                    }
                }
                //reset numberCheck
                for(int t = 0; t < 9; t++) {
                    numberCheck[t] = 0;
                }
                if(!test) {
                    break;
                }
            }
            if(!test) {
                validation = false;
                break;
            }
        }
        //checking all columns if every number is just one time contained
        for(int w = 0; w < 3; w++) {
            for(int x = 0; x < 3; x++) {
                for(int y = 0; y < 3; y++) {
                    for(int z = 0; z < 3; z++) {
                        switch (textFieldArray.get(w * 27 + x * 3 + y * 9 + z).getText()) {
                            case "1" -> numberCheck[0]++;
                            case "2" -> numberCheck[1]++;
                            case "3" -> numberCheck[2]++;
                            case "4" -> numberCheck[3]++;
                            case "5" -> numberCheck[4]++;
                            case "6" -> numberCheck[5]++;
                            case "7" -> numberCheck[6]++;
                            case "8" -> numberCheck[7]++;
                            case "9" -> numberCheck[8]++;
                            default -> {
                            }
                        }
                    }
                }
                //check through array if all sums are exactly 1
                for(int t = 0; t < 9; t++) {
                    if(numberCheck[t] != 1) {
                        test = false;
                        break;
                    }
                }
                //reset numberCheck
                for(int t = 0; t < 9; t++) {
                    numberCheck[t] = 0;
                }
                if(!test) {
                    break;
                }
            }
            if(!test) {
                validation = false;
                break;
            }
        }
        //checking all fields if every number is just one time contained
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                for(int z = 0; z < 3; z++) {
                    switch (textFieldArray.get(x * 9 + y + z * 3).getText()) {
                        case "1" -> numberCheck[0]++;
                        case "2" -> numberCheck[1]++;
                        case "3" -> numberCheck[2]++;
                        case "4" -> numberCheck[3]++;
                        case "5" -> numberCheck[4]++;
                        case "6" -> numberCheck[5]++;
                        case "7" -> numberCheck[6]++;
                        case "8" -> numberCheck[7]++;
                        case "9" -> numberCheck[8]++;
                        default -> {
                        }
                    }
                }
            }
            //check through array if all sums are exactly 1
            for(int t = 0; t < 9; t++) {
                if(numberCheck[t] != 1) {
                    test = false;
                    break;
                }
            }
            //reset numberCheck
            for(int t = 0; t < 9; t++) {
                numberCheck[t] = 0;
            }
            if(!test) {
                validation = false;
                break;
            }
        }
        if(!validation) {
            setValidateText("Invalid!");
        }
        else {
            setValidateText("Valid!");
        }
    }
    /**
     * The setValidateText function sets the text of the validateLabel.
     * @param state Takes a string value and sets it as text for the validateLabel.
     */
    private void setValidateText(String state) {
        validateLabel.setText(state);
    }
    /**
     * The setTime function sets the given time in seconds into the text field.
     * @param milliseconds Takes the number of seconds, which have to be written into the text field.
     */
    protected void setTime(long milliseconds) {
        timeLabel.setText("Solved in: "+ milliseconds +" ms");
    }
    /**
     * The clearField function clears the sudoku board completely.
     * The boolean will be set to false, that the solving process can be started again.
     */
    protected void clearField() {
        for(int x = 0; x < 81; x++) {
            textFieldArray.get(x).setText("");
            textFieldArray.get(x).setForeground(Color.BLACK);
        }
        clearButton = false;
        setTime(0);
        setValidateText("Not validated!");
    }
    /**
     * The clearState function returns the state of the clear button as boolean.
     * @return The value of the boolean clearButton will be returned.
     */
    protected boolean clearState() {
        return clearButton;
    }
    /**
     * The setClearState function sets the clearButton value to true,
     * that the board is waiting after solving until the button gets
     * pressed.
     */
    protected void setClearState() {
        clearButton = true;
    }
    /**
     * The startSolving functions provides the state if the solve-button is pressed or not.
     * @return A boolean gets returned if called and provides true, if the button got pressed.
     */
    protected boolean startSolving() {
        return solveButton;
    }
    /**
     * The resetSolving function sets the solveButton variable to false.
     */
    protected void resetSolving() {
        solveButton = false;
    }
    /**
     * The writeInput functions writes the given number into the given field, with the given row and column.
     * @param field Takes the number of the field, which has to be written in.
     * @param row	Takes the number of the row, which has to be written in.
     * @param column Takes the number of the column, which has to be written in.
     * @param number Takes the number, which is looked for.
     */
    protected void writeInput(int field, int row, int column, int number){
        textFieldArray.get(field*9+row+column*3).setText(Integer.toString(number));
        textFieldArray.get(field*9+row+column*3).setForeground(Color.RED);
    }
    /**
     * The readInput function takes in the written numbers of the sudoku field
     * and holds it in a result array.
     * Empty fields will be saved with a zero.
     * @return A result integer array will be returned holding the field number,
     * the row and the column number.
     */
    protected int[][][] readInput(){
        int[][][] result = new int[9][3][3];
        String checker = "";
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 3; y++) {
                for(int z = 0; z < 3; z++) {
                    if(!textFieldArray.get(x*9+y+z*3).getText().isEmpty()) {
                        checker = textFieldArray.get(x*9+y+z*3).getText();
                        if(checker.equals("1") || checker.equals("2") || checker.equals("3") || checker.equals("4") || checker.equals("5") || checker.equals("6") || checker.equals("7") || checker.equals("8") || checker.equals("9")) {
                            result[x][y][z] = Integer.parseInt(checker);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "You didn't input a number from 1 to 9!", "Input error", JOptionPane.INFORMATION_MESSAGE);
                            result[x][y][z] = 11;
                        }
                    }
                    else {
                        result[x][y][z] = 0;
                    }
                }
            }
        }
        return result;
    }
    /**
     * The calcCoordinates takes the index number and split it into fieldRow, fieldColumn, row and column.
     * @param index Takes the index number.
     * @return Returns an integer array with fieldRow, fieldColumn, row and column.
     */
    private int[] calcCoordinates(int index) {
        int[] result = new int[4];
        result[0] = (index/9)%3;
        result[1] = (index/9)/3;
        int innerIndex = index-result[0]*9-result[1]*27;
        result[2] = innerIndex%3;
        result[3] = innerIndex/3;
        return result;
    }
    /**
     * Overriding the keyPressed function of the KeyListenerInterface.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int[] coordinates = {0, 0, 0, 0};
        if (key == KeyEvent.VK_LEFT) {
            int index = 0;
            for(int x = 0; x < 81; x++) {
                if(textFieldArray.get(x) == this.getFocusOwner()) {
                    index  = x;
                    break;
                }
            }
            coordinates = calcCoordinates(index);
            if(coordinates[3] != 0) {
                coordinates[3]--;
            }
            else if(coordinates[1] != 0) {
                coordinates[1]--;
                coordinates[3] = 2;
            }
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).setRequestFocusEnabled(true);
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).requestFocusInWindow();
        }

        if (key == KeyEvent.VK_RIGHT) {
            int index = 0;
            for(int x = 0; x < 81; x++) {
                if(textFieldArray.get(x) == this.getFocusOwner()) {
                    index  = x;
                    break;
                }
            }
            coordinates = calcCoordinates(index);
            if(coordinates[3] != 2) {
                coordinates[3]++;
            }
            else if(coordinates[1] != 2) {
                coordinates[1]++;
                coordinates[3] = 0;
            }
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).setRequestFocusEnabled(true);
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).requestFocusInWindow();
        }

        if (key == KeyEvent.VK_UP) {
            int index = 0;
            for(int x = 0; x < 81; x++) {
                if(textFieldArray.get(x) == this.getFocusOwner()) {
                    index  = x;
                    break;
                }
            }
            coordinates = calcCoordinates(index);
            if(coordinates[2] != 0) {
                coordinates[2]--;
            }
            else if(coordinates[0] != 0) {
                coordinates[0]--;
                coordinates[2] = 2;
            }
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).setRequestFocusEnabled(true);
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).requestFocusInWindow();
        }

        if (key == KeyEvent.VK_DOWN) {
            int index = 0;
            for(int x = 0; x < 81; x++) {
                if(textFieldArray.get(x) == this.getFocusOwner()) {
                    index  = x;
                    break;
                }
            }
            coordinates = calcCoordinates(index);
            if(coordinates[2] != 2) {
                coordinates[2]++;
            }
            else if(coordinates[0] != 2) {
                coordinates[0]++;
                coordinates[2] = 0;
            }
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).setRequestFocusEnabled(true);
            textFieldArray.get(coordinates[0]*9+coordinates[1]*27+coordinates[2]+coordinates[3]*3).requestFocusInWindow();
        }

    }
    /**
     * Overriding the keyReleased function of the KeyListenerInterface.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
    /**
     * Overriding the keyTyped function of the KeyListenerInterface.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
