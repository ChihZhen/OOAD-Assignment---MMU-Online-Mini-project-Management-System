package com.example.ooad.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// import javax.swing.ScrollPaneLayout;
import com.example.ooad.entity.Comment;

import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;
import com.example.ooad.model.CommentModel;
import com.example.ooad.model.IModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;
import com.example.ooad.entity.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.util.List;

@Component
public class AdminProjectDetailView extends JDialog implements Observer<IModel> {

  private JTextField titleInput;
  private JTextField specializationInput;
  private JTextField statusInput;
  private JTextField lecturerInput;
  private JTextField studentInput;
  private JTextArea descriptionInput;
  private JTextField idInput;
  private ProjectModel projectModel;
  JTextField message;
  JLabel name;
  JTextField time;

  JLabel l = new JLabel("No comments yet.");

  public AdminProjectDetailView(ProjectModel projectModel) {
    this.projectModel = projectModel;
    this.projectModel.registerObserver(this);
    // this.setModal(true);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setSize(432, 600);
    this.setResizable(false);
    this.setTitle("View Project Detail");
    comp();
    this.addWindowListener(new WindowAdapter() {

      public void windowClosed(WindowEvent e) {
        // removeScroll();
        System.out.println("message------------->" + message.getText());
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
        comp();
      }
    });

  }

  public void comp() {
    // ===== Id Label
    JLabel idLabel = new JLabel("Project ID");
    GridBagAdder gridCtr_0 = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();

    this.add(idLabel, gridCtr_0.getConstraint());

    // // ===== ID Input
    idInput = new JTextField("ID");
    idInput.setPreferredSize(new Dimension(200, 22));
    idInput.setMinimumSize(new Dimension(200, 22));
    idInput.setEditable(false);
    GridBagAdder gridCtr_0_0 = new GridBagAdder.GridBagAdderBuilder().setX(1).marginB(20).build();
    this.add(idInput, gridCtr_0_0.getConstraint());

    // ===== Title Label
    JLabel titleLabel = new JLabel("Title");
    GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(1)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();

    this.add(titleLabel, gridCtr.getConstraint());

    // ===== Title Input
    titleInput = new JTextField("Title");
    titleInput.setPreferredSize(new Dimension(200, 22));
    titleInput.setMinimumSize(new Dimension(200, 22));
    titleInput.setEditable(false);
    GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1)
        .build();
    this.add(titleInput, gridCtr_2.getConstraint());

    // ===== Specialization Title
    JLabel specializationTitle = new JLabel("Specialization");
    GridBagAdder gridCtr_3 = new GridBagAdder.GridBagAdderBuilder().setY(2).marginT(20).marginB(20).marginR(20)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(specializationTitle, gridCtr_3.getConstraint());

    // ===== Specialization Input
    specializationInput = new JTextField("Software Engineer");
    specializationInput.setPreferredSize(new Dimension(200, 22));
    specializationInput.setMinimumSize(new Dimension(200, 22));
    specializationInput.setEditable(false);
    GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginT(20).marginB(20)
        .build();
    this.add(specializationInput, gridCtr_4.getConstraint());

    // ===== Status Title
    JLabel statusTitle = new JLabel("Status");
    GridBagAdder gridCtr_5 = new GridBagAdder.GridBagAdderBuilder().setY(3)
        .anchor(GridBagConstraints.BASELINE_LEADING)
        .build();
    this.add(statusTitle, gridCtr_5.getConstraint());
    // ===== Status Input
    statusInput = new JTextField("Active");
    statusInput.setEditable(false);
    statusInput.setPreferredSize(new Dimension(200, 22));
    statusInput.setMinimumSize(new Dimension(200, 22));
    GridBagAdder gridCtr_6 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).marginB(20)
        .build();
    this.add(statusInput, gridCtr_6.getConstraint());

    // ===== Description Title
    JLabel descriptionTitle = new JLabel("Description");
    GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setY(4)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(descriptionTitle, gridCtr_7.getConstraint());

    descriptionInput = new JTextArea("Description");
    descriptionInput.setPreferredSize(new Dimension(200, 84));
    descriptionInput.setEditable(false);
    descriptionInput.setMinimumSize(new Dimension(200, 84));
    GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).marginB(20)
        .build();
    this.add(descriptionInput, gridCtr_8.getConstraint());

    // ===== Lecturer Title
    JLabel lecturerTitle = new JLabel("Lecturer");
    GridBagAdder gridCtr_10 = new GridBagAdder.GridBagAdderBuilder().setY(5)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(lecturerTitle, gridCtr_10.getConstraint());

    lecturerInput = new JTextField();
    lecturerInput.setPreferredSize(new Dimension(200, 22));
    lecturerInput.setMinimumSize(new Dimension(200, 22));
    lecturerInput.setEditable(false);
    GridBagAdder gridCtr_11 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(5).marginB(20)
        .build();
    this.add(lecturerInput, gridCtr_11.getConstraint());

    // ===== Student Title
    JLabel studentTitle = new JLabel("Student");
    GridBagAdder gridCtr_12 = new GridBagAdder.GridBagAdderBuilder().setY(6)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(studentTitle, gridCtr_12.getConstraint());

    studentInput = new JTextField();
    studentInput.setPreferredSize(new Dimension(200, 22));
    studentInput.setEditable(false);
    studentInput.setMinimumSize(new Dimension(200, 22));
    GridBagAdder gridCtr_13 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(6).marginB(20)
        .build();
    this.add(studentInput, gridCtr_13.getConstraint());

    JLabel commentLabel = new JLabel("Comments");
    GridBagAdder gridCtr_9 = new GridBagAdder.GridBagAdderBuilder().setY(7).marginB(15)
        .anchor(GridBagConstraints.BASELINE_LEADING)
        .build();
    this.add(commentLabel, gridCtr_9.getConstraint());
    JPanel commentSection = new JPanel();
    commentSection.setLayout(new GridBagLayout());
  }

  public void update(Observable<IModel> _observable, IModel model) {
    // if (model instanceof ProjectModel) {
    Project project = projectModel.getCurrent();
    idInput.setText(project.getId().toString());
    titleInput.setText(project.getTitle());
    descriptionInput.setText(project.getDescription());
    specializationInput.setText(project.getSpecialization());
    statusInput.setText(project.getStatus());
    // }

    List<Comment> comments = projectModel.getCurrent().getComments();
    studentInput.setText(
        project.getStudent() != null ? project.getStudent().getFullName() : "No assignee yet");
    lecturerInput.setText(project.getLecturer().getFullName());

    JPanel j = new JPanel(new GridBagLayout());
    JPanel p = new JPanel(new GridBagLayout());
    p.setPreferredSize(new Dimension(200, 100));

    if (comments.size() != 0) {
      int inc = 9;
      for (Comment comment : comments) {

        message = new JTextField(comment.getMessage());
        name = new JLabel(comment.getAdmin().getFullName());
        time = new JTextField(comment.getDate());
        time.setPreferredSize(new Dimension(200, 22));
        time.setEditable(false);
        time.setMinimumSize(new Dimension(200, 22));
        time.setEditable(false);

        message.setEditable(false);
        message.setPreferredSize(new Dimension(200, 22));
        message.setMinimumSize(new Dimension(200, 22));
        message.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        time.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Font newTextFieldFont = new Font(time.getFont().getName(), time.getFont().getStyle(), 10);
        time.setFont(newTextFieldFont);
        GridBagAdder gridCtr_com_2 = new GridBagAdder.GridBagAdderBuilder().marginT(2).marginL(3).setY((inc))
            .anchor(GridBagConstraints.BASELINE_LEADING).build();
        inc++;

        GridBagAdder gridCtr_com_3 = new GridBagAdder.GridBagAdderBuilder().setY(inc).marginB(4).marginL(3)
            .build();
        inc++;

        GridBagAdder gridCtr_com = new GridBagAdder.GridBagAdderBuilder().setY(inc).marginB(12).marginL(3)
            .build();

        j.add(name, gridCtr_com_2.getConstraint());
        j.add(message, gridCtr_com.getConstraint());
        j.add(time, gridCtr_com_3.getConstraint());
        inc++;
      }
      GridBagAdder panelGrid = new GridBagAdder.GridBagAdderBuilder().setY(8).build();

      JScrollPane scrollPane = new JScrollPane(j, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setPreferredSize(new Dimension(200, 100));
      p.add(scrollPane);

      this.add(p, panelGrid.getConstraint());
      return;
    }

    GridBagAdder grid_no_comment = new GridBagAdder.GridBagAdderBuilder().setY((8))
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(l, grid_no_comment.getConstraint());
    return;
  }

}
