package com.project.serenity_mental_center.controllers;

import com.project.serenity_mental_center.bo.BOFactory;
import com.project.serenity_mental_center.bo.custom.impl.TherapistBOImpl;
import com.project.serenity_mental_center.bo.custom.impl.TherapyProgramBOImpl;
import com.project.serenity_mental_center.bo.custom.impl.TherapySessionBOImpl;
import com.project.serenity_mental_center.dto.CustomDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminHomePageController implements Initializable {

        @FXML
        private BarChart<String, Long> barTherapistPerformance;

        @FXML
        private BarChart<String, Long> barTherapySession;

        @FXML
        private Pane bodyPane;

        @FXML
        private ComboBox<String> cmbTherapistId;

        @FXML
        private ComboBox<String> cmbTherapySessionId;

        @FXML
        private Button btnAssignToProgram;

        @FXML
        private Button btnPatientManage;

        @FXML
        private Button btnPayments;

        @FXML
        private Button btnRegisterProgram;

        @FXML
        private Button btnReports;

        @FXML
        private Button btnTherapyProgran;

        @FXML
        private Button btnTherapySession;

        @FXML
        private Button btnTherpist;

        @FXML
        private Button btnUserManage;

        TherapistBOImpl therapistBO = (TherapistBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPIST);
        TherapySessionBOImpl therapySessionBO = (TherapySessionBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_SESSION);
        TherapyProgramBOImpl therapyProgramBO = (TherapyProgramBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_PROGRAM);

        @FXML
        void navigateToAssignProgram(ActionEvent event) {
                navigateTo("/view/AssignToPrograms.fxml");
        }

        @FXML
        void navigateToPatient(ActionEvent event) {
                navigateTo("/view/PatientManagement.fxml");
        }

        @FXML
        void navigateToPayment(ActionEvent event) {
                navigateTo("/view/PaymentManagement.fxml");
        }

        @FXML
        void navigateToHomePage(MouseEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminHomePage.fxml"));
                Pane newContent = loader.load();

                AnchorPane parent = (AnchorPane) bodyPane.getParent();
                parent.getChildren().remove(bodyPane);
                parent.getChildren().add(newContent);
        }

        @FXML
        void navigateToTherapist(ActionEvent event)  {
                navigateTo("/view/TherapistManage.fxml");
        }

        @FXML
        void navigateToTherapyProgram(ActionEvent event) {
                navigateTo("/view/TherapyProgram.fxml");
        }

        @FXML
        void navigateToTherapySession(ActionEvent event) {
                navigateTo("/view/TherapySessionManagement.fxml");
        }

        @FXML
        void navigateToUserManagePage(ActionEvent event) {
                navigateTo("/view/UserManagement.fxml");
        }

        @FXML
        void navigateToReports(ActionEvent event) {
                navigateTo("/view/Reports.fxml");
        }

        @FXML
        void navigateToSettingPage(MouseEvent event) {
                navigateTo("/view/SettingFile.fxml");
        }

        @FXML
        void navigateRegisterPage(ActionEvent event) {
                navigateTo("/view/RegisterToProgram.fxml");
        }


        public void navigateTo(String path) {
                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                        Pane newContent = loader.load();

                        bodyPane.getChildren().clear();  // Clear the old content
                        bodyPane.getChildren().add(newContent);  // Add the new content
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }


}


