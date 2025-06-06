package com.project.serenity_mental_center.controllers;

import com.project.serenity_mental_center.bo.BOFactory;
import com.project.serenity_mental_center.bo.custom.impl.PatientBOImpl;
import com.project.serenity_mental_center.dto.PatientDto;
import com.project.serenity_mental_center.dto.tm.PatientTM;
import com.project.serenity_mental_center.util.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Label addressError;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label emailError;

    @FXML
    private Label historyError;

    @FXML
    private Label idError;

    @FXML
    private Label nameError;

    @FXML
    private Label phoneError;

    @FXML
    private TableView<PatientTM> tablePatient;

    @FXML
    private TableColumn<PatientTM, String> colAddress;

    @FXML
    private TableColumn<PatientTM, String> colEmail;

    @FXML
    private TableColumn<PatientTM, String> colHistory;

    @FXML
    private TableColumn<PatientTM, String> colName;

    @FXML
    private TableColumn<PatientTM, String> colPatientID;

    @FXML
    private TableColumn<PatientTM, String> colPhone;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextArea txtHistory;

    @FXML
    private TextField txtPatientId;

    @FXML
    private TextField txtPatientName;

    @FXML
    private TextField txtPhone;

    @FXML
    private Pane userPane;

    private PatientBOImpl patientBO = (PatientBOImpl) BOFactory.getInstance().getBO(BOFactory.BOType.PATIENT);

    @FXML
    void addPatient(ActionEvent event) {
        String patientId = txtPatientId.getText();
        String patientName = txtPatientName.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText().trim();
        System.out.println(email.isEmpty() +"|"+email);
        String history = txtHistory.getText();

        boolean isCorrectEmail = Validation.isValid(email,"gmail");
        boolean isCorrectPhone = Validation.isValid(phone,"phone");
        if (!isCorrectEmail){
            txtEmail.setStyle("-fx-border-color: red");
        }else {
            txtEmail.setStyle("-fx-border-color: black");
        }

        if (!isCorrectPhone){
            txtPhone.setStyle("-fx-border-color: red");
        }else {
            txtPhone.setStyle("-fx-border-color: black");
        }

        if (isCorrectEmail && isCorrectPhone && !patientId.isEmpty() && !patientName.isEmpty() && !address.isEmpty() && !history.isEmpty()) {
            boolean isSaved = patientBO.savePatient(new PatientDto(patientId, patientName, address, phone, email, history));
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Patient saved successfully").show();
                txtPatientId.setText("");
                txtPatientName.setText("");
                txtAddress.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtHistory.setText("");
                refreshPage();
            } else {
                new Alert(Alert.AlertType.WARNING, "Patient saved not successfully").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Invalid input or Null input").show();
        }
    }

    @FXML
    void deletePatient(ActionEvent event) {
        String patientId = txtPatientId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this patient?", ButtonType.YES);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES){
            boolean isDelete = patientBO.deletePatient(patientId);
            if(isDelete){
                new Alert(Alert.AlertType.INFORMATION,"Patient Deleted successfully").show();
                refreshPage();
            }else{
                new Alert(Alert.AlertType.WARNING,"Patient is not Delete").show();
            }
        }
    }

    @FXML
    void resetPage(ActionEvent event) {
        refreshPage();
    }

    @FXML
    void tableClick(MouseEvent event) {
        PatientTM selectedPatient = tablePatient.getSelectionModel().getSelectedItem();
        if (selectedPatient != null){
            txtPatientId.setText(selectedPatient.getId());
            txtPatientName.setText(selectedPatient.getName());
            txtAddress.setText(selectedPatient.getAddress());
            txtEmail.setText(selectedPatient.getEmail());
            txtPhone.setText(selectedPatient.getPhone());
            txtHistory.setText(selectedPatient.getHistory());

            btnAdd.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            btnReset.setDisable(false);
        }
    }

    @FXML
    void updatePatient(ActionEvent event) {
        String patientId = txtPatientId.getText();
        String patientName = txtPatientName.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String history = txtHistory.getText();
        System.out.println(email);
        boolean isCorrectEmail = Validation.isValid(email,"gmail");
        boolean isCorrectPhone = Validation.isValid(phone,"phone");
        if (!isCorrectEmail){
            txtEmail.setStyle("-fx-border-color: red");
        }else {
            txtEmail.setStyle("-fx-border-color: black");
        }

        if (!isCorrectPhone){
            txtPhone.setStyle("-fx-border-color: red");
        }else {
            txtPhone.setStyle("-fx-border-color: black");
        }

        if (isCorrectEmail && isCorrectPhone && patientId != null && patientName != null && address != null && history != null) {
            boolean isUpdate = patientBO.updatePatient(new PatientDto(patientId, patientName, address, phone, email, history));
            if (isUpdate) {
                new Alert(Alert.AlertType.INFORMATION, "Patient update successfully").show();
                refreshPage();
            } else {
                new Alert(Alert.AlertType.WARNING, "Patient update not successfully").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Invalid input or Null input").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colPatientID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colHistory.setCellValueFactory(new PropertyValueFactory<>("history"));
        try {
            refreshPage();
        }catch (Exception e) {
            throw e;
        }
    }

    public void refreshPage(){
        refreshTable();
        txtPatientId.setText(patientBO.getNextId());
        txtPatientName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtHistory.setText("");

        btnAdd.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnReset.setDisable(false);
    }

    public void refreshTable(){
        ArrayList<PatientDto> patientDtos = patientBO.getAllPatient();
        ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();
        for(PatientDto patientDto : patientDtos){
            PatientTM patient = new PatientTM(
                    patientDto.getId(),
                    patientDto.getName(),
                    patientDto.getAddress(),
                    patientDto.getPhone(),
                    patientDto.getEmail(),
                    patientDto.getHistory()
            );
            patientTMS.add(patient);
        }
        tablePatient.setItems(patientTMS);
    }
}
