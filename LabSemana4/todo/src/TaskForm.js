import React, {useState} from 'react';
import '.TaskForm.css';
import {RiAddLine} from 'react-icons/ri';

function TaskForm({addTask}){
    const [task,  setTask] = useState('');
    const [priority, setPriority] = useState('low');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (task.trim()=== '') return;
        addTask({task, priority});
        setTask('');
        setPriority('low');
    };
    return (
        <from className = "task-form" onSubmit = {handleSubmit}>
            <input
            type = "text"
            placeholder="Nome da Tarefa"
            value={task}
            onChange={(e) => setTask(e.target.value)}
            />
                <select
                value={priority}
                onChange = {(e) => setPriority(e.target.value)}
                >
                    <option value= "low">Baixa Prioridade</option>
                    <option value = "medium">Média Priridade</option>
                    <option value = "high">Alta Prioridade</option>
                </select>
                <button type = "submit">
                    <RiAddLine className = "button-icon"/> Adicionar Taarefa
                </button>
            </from>
    );
}

export default TaskForm;