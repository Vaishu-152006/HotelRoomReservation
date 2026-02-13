The Hotel Room Reservation System is a web-based application developed using Java Servlets, JSP, JDBC, and Oracle Database. The application is designed to manage hotel room reservations efficiently by allowing administrators to add, view, and manage reservation records through a simple user interface.

This project follows the MVC (Model-View-Controller) architecture to ensure proper separation of concerns. The Servlet acts as the controller, JSP pages act as the view layer, and Java Beans represent the model. Database operations are handled using the DAO (Data Access Object) design pattern.

The system allows users to enter reservation details such as Record ID, Guest Name, Room Type, Check-In Date, Check-Out Date, Room Number, and Remarks. The application performs necessary validations including guest name length validation, date range validation, and duplicate reservation checks before storing the data in the Oracle database.

The Administrator service layer handles business logic such as validating input data and coordinating between the servlet and DAO layer. The DAO layer interacts directly with the database using JDBC to insert, fetch, and retrieve reservation records.

<img width="400" height="400" alt="Screenshot 2026-02-13 093025" src="https://github.com/user-attachments/assets/b2687172-74f1-4f08-a229-7c6a59a19f10" />

<img width="400" height="400" alt="Screenshot 2026-02-13 093107" src="https://github.com/user-attachments/assets/00bf5cf4-86bc-43b4-9b9f-4591fafde42a" />

<img width="400" height="400" alt="Screenshot 2026-02-13 093235" src="https://github.com/user-attachments/assets/6b567cde-eed8-48ac-a9e3-25c662f181b1" />

<img width="400" height="400" alt="Screenshot 2026-02-13 093357" src="https://github.com/user-attachments/assets/941b8276-d7ab-4169-94be-b053f8f41387" />

<img width="400" height="400" alt="Screenshot 2026-02-13 093855" src="https://github.com/user-attachments/assets/09f3f667-cbc4-4edc-8435-eb50990e656b" />

<img width="600" height="600" alt="Screenshot 2026-02-13 094043" src="https://github.com/user-attachments/assets/70725b5c-f369-4bb4-b0dc-388e76581a70" />

<img width="400" height="400" alt="Screenshot 2026-02-13 094024" src="https://github.com/user-attachments/assets/68ef7d08-fec5-4d7b-a3d3-438c038b6c76" />

<img width="500" height="443" alt="image" src="https://github.com/user-attachments/assets/ebd55bc5-13dd-471c-b820-f209fc3f4695" />







