package com.example.ooad.view;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Project;
import com.example.ooad.model.IModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;

@Component
public class LecturerEditProjectView extends LecturerAddProjectView implements Observer<IModel> {

    public LecturerEditProjectView(ProjectModel projectModel) {
        super(projectModel);
        this.setTitle("Edit Project");
        projectModel.registerObserver(this);
    }

    public void update(Observable<IModel> _observable, IModel model) {
        Project project = projectModel.getCurrent();
        if (project != null) {
            System.out.println("-------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            titleInput.setText(project.getTitle());
            descriptionInput.setText(project.getDescription());
            specializationInput.setSelectedItem(project.getSpecialization());
            statusInput.setSelectedItem(project.getStatus());
        }
    }
}
