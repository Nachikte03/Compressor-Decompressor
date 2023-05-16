package ui;

import logic.Compress;
import logic.Decompress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {

    //instance variables
    JButton compressBtn,decompressBtn;

    //constructor
    public MainFrame(String str){
        super(str);
        setComponents();
    }
    public void setComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(100,100,600,400);
        this.setVisible(true);
        this.setBackground(Color.gray);

        //compress button
        compressBtn = new JButton("Choose File to Compress");
        compressBtn.setBounds(200,100,200,50);
        compressBtn.setBackground(Color.yellow);
        compressBtn.addActionListener(this);

        //decompress button
        decompressBtn = new JButton("Choose File to Decompress");
        decompressBtn.setBounds(200,200,200,50);
        decompressBtn.setBackground(Color.yellow);
        decompressBtn.addActionListener(this);

        //add buttons
        this.add(compressBtn);
        this.add(decompressBtn);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressBtn){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            if(response==JFileChooser.APPROVE_OPTION){
                try {
                    Compress.method(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }


        if(e.getSource()==decompressBtn){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            if(response==JFileChooser.APPROVE_OPTION){
                try {
                    Decompress.decompressMethod(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
