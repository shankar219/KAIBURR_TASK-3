import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState({ id: '', name: '', owner: '', command: '' });
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/tasks');
      setTasks(response.data);
    } catch (error) {
      setMessage('Error fetching tasks');
    }
  };

  const handleInputChange = (e) => {
    setTask({ ...task, [e.target.name]: e.target.value });
  };

  const createTask = async () => {
    try {
      await axios.put('http://localhost:8080/api/tasks', task);
      fetchTasks();
      setMessage('Task created');
      setTask({ id: '', name: '', owner: '', command: '' });
    } catch (error) {
      setMessage('Error creating task');
    }
  };

  const executeTask = async (id) => {
    try {
      await axios.put(`http://localhost:8080/api/taskExecutions?id=${id}`);
      fetchTasks();
      setMessage('Task executed');
    } catch (error) {
      setMessage('Error executing task');
    }
  };

  const deleteTask = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/tasks/${id}`);
      fetchTasks();
      setMessage('Task deleted');
    } catch (error) {
      setMessage('Error deleting task');
    }
  };

  return (
    <div className="App">
      <h1>Task Manager</h1>
      <div>
        <input name="id" value={task.id} onChange={handleInputChange} placeholder="ID" />
        <input name="name" value={task.name} onChange={handleInputChange} placeholder="Name" />
        <input name="owner" value={task.owner} onChange={handleInputChange} placeholder="Owner" />
        <input name="command" value={task.command} onChange={handleInputChange} placeholder="Command (e.g., cmd.exe /c echo Hello)" />
        <button onClick={createTask}>Create Task</button>
      </div>
      {message && <p>{message}</p>}
      <ul>
        {tasks.map((t) => (
          <li key={t.id}>
            {t.name} (Owner: {t.owner}) - {t.command}
            <button onClick={() => executeTask(t.id)}>Execute</button>
            <button onClick={() => deleteTask(t.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;