# Serenity Mental Health Therapy Center System

A comprehensive digital system developed to manage patient registrations, therapy programs, session scheduling, therapist management, and financial transactions for the Serenity Mental Health Therapy Center in Sri Lanka.

---

## 🏥 About the Center

The **Serenity Mental Health Therapy Center** is a renowned institution that has been offering a range of evidence-based and holistic therapy programs for over a decade. With over 3,000 patients served annually, the center has decided to move away from manual paperwork and transition to a robust digital system to manage operations efficiently.

---

## 🎯 Project Objectives

- Digitize the patient registration workflow.
- Streamline therapy program management.
- Enable efficient therapist scheduling.
- Provide secure, role-based access to system features.
- Improve financial tracking and reporting.
- Ensure secure and scalable data handling.

---

## 👥 User Roles & Access

### 🔐 Admin
- Manage therapists and therapy programs.
- Assign therapists to therapy programs.
- Access performance and session analytics reports.

### 🛎 Receptionist
- Handle patient registrations and session scheduling.
- Process therapy payments and generate invoices.
- View financial and patient therapy history reports (read-only).

---

## 📋 Therapy Programs Offered

| Program ID | Name                             | Duration   | Fee (LKR)   |
|------------|----------------------------------|------------|-------------|
| MT1001     | Cognitive Behavioral Therapy     | 12 weeks   | 80,000.00   |
| MT1002     | Mindfulness-Based Stress Reduction | 8 weeks  | 50,000.00   |
| MT1003     | Dialectical Behavior Therapy     | 16 weeks   | 100,000.00  |
| MT1004     | Group Therapy Sessions           | 6 months   | 120,000.00  |
| MT1005     | Family Counseling                | 3 months   | 40,000.00   |

---

## 🧠 Core System Features

### 1. User Role Management
- Secure login with encrypted password storage.
- Role-based access control (Admin, Receptionist).

### 2. Therapist Management (Admin Only)
- Add/update/remove therapists.
- Assign therapists to therapy programs.
- View therapist availability and scheduling.

### 3. Therapy Program Management (Admin Only)
- Create and manage therapy programs.
- Define name, duration, cost, and descriptions.
- Link therapists to therapy programs.

### 4. Patient Management
- Add/update/delete patient profiles.
- Maintain medical history and session records.
- Search patients by name, therapy type, or history.

### 5. Therapy Session Scheduling
- Book/reschedule/cancel therapy sessions.
- Assign available therapists.
- View session calendar and slot availability.

### 6. Payment & Invoice Management
- Collect upfront payments for registrations.
- Generate and print invoices.
- Track completed and pending payments.

### 7. Reporting & Analytics
- View therapist performance and session data (Admin).
- Generate financial reports and patient statistics (Receptionist).
- Read-only access to patient therapy history.

### 8. Secure Data Management
- Password encryption for login.
- Hibernate ORM for database operations.
- Role-based access for data privacy and integrity.

---

## 🧰 Technologies Used

- Java
- JavaFX (for UI)
- MySQL (Database)
- Hibernate ORM
- Spring/Spring Boot (Optional)
- Maven/Gradle (for project management)

---

## 🗂 Database Design (Key Relationships)

- **One-to-Many**: Therapist ↔ Therapy Session
- **Many-to-Many**: Patient ↔ Therapy Program (via Registration)
- **One-to-One**: Registration ↔ Payment

---

## 🚀 Getting Started

1. Clone this repository.
2. Import project into your preferred IDE.
3. Set up MySQL database and configure credentials.
4. Run database migration script (if provided).
5. Launch the application.

---




