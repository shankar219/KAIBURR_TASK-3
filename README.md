# Kaiburr Task 3: Task Management Frontend

## Overview
This project is part of the Kaiburr Assessment Task 3, developed by Suram. It implements a React-based frontend application to interact with the Task 1 REST API (Java Spring Boot with MongoDB backend) for managing and executing tasks. The frontend provides a user interface to create, view, execute, and delete tasks, leveraging the API endpoints hosted at `http://localhost:8081/api/tasks`.

## Project Details
- **Developer**: Suram
- **Date**: October 20, 2025
- **Time**: 06:27 PM IST
- **Repository**: https://github.com/shankar219/KAIBURR_TASK-3
- **Backend Dependency**: Task 1 API[](https://github.com/shankar219/KAIBURR_TASK-1)

## Technologies Used
- **Frontend**: React.js, Tailwind CSS
- **Build Tool**: Vite
- **API**: RESTful API (Spring Boot, MongoDB) from Task 1

## Prerequisites
- **Node.js**: Version 18.x or later (download from [nodejs.org](https://nodejs.org/))
- **Task 1 Backend**: Ensure the Task 1 Spring Boot application is running at `http://localhost:8081` with MongoDB (`mongod --dbpath "C:\data\db"`) active.
- **Git**: Installed and configured (verify with `git --version`).

## Installation
1. Clone the repository:git clone https://github.com/shankar219/KAIBURR_TASK-3.git
2. Install dependencies:npm install
3. Start the development server:npm run dev
- Open `http://localhost:5173` in your browser to view the app.

## Usage
- **Create Task**: Enter task details (ID, Name, Owner, Command) in the form and click "Create".
- **View Tasks**: The table displays all tasks fetched from the API.
- **Execute Task**: Click "Execute" on a task row to run its command (output logged in the UI).
- **Delete Task**: Click "Delete" to remove a task.

## API Endpoints Used
- `PUT /api/tasks`: Create a new task.
- `GET /api/tasks`: Retrieve all tasks.
- `PUT /api/taskExecutions?id={id}`: Execute a task by ID.
- `DELETE /api/tasks/{id}`: Delete a task by ID.

## Screenshots
- **Compilation**: <image-card alt="Compilation" src="screenshots/compilation.png" ></image-card>
- **App Running**: <image-card alt="App Running" src="screenshots/app_running.png" ></image-card>
- **Backend Running**: <image-card alt="Backend Running" src="screenshots/backend_running.png" ></image-card>
## Project Structure
KAIBURR_TASK-3/

├── public/           # Static assets

├── src/              # React components and logic

│   ├── App.jsx      # Main app component

│   ├── TaskList.jsx # Task table component

│   ├── TaskForm.jsx # Task creation form

│   └── index.css    # Tailwind CSS styles

├── index.html        # Entry point

├── package.json      # Dependencies and scripts

└── vite.config.js    # Vite configuration


## Notes
- The frontend assumes the Task 1 backend is operational. Ensure MongoDB and the Spring Boot app are running before starting the frontend.
- Task execution output is captured via the API and displayed in the UI.
- This project does not include backend logic; it relies on the Task 1 repository.

## Future Improvements
- Add error handling for API failures.
- Implement real-time updates with WebSockets.
- Enhance UI with animations or additional features.

## Submission
- Uploaded to GitHub: https://github.com/shankar219/KAIBURR_TASK-3
- Screenshots and source code included in the repository.
