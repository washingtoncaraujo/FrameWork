/* eslint-disable no-unused-vars */
import React from 'react';
import './TaskList.css';
import {AiOutlineFileText, AiFillExclamationCircle} from 'react-icons/ai';

function TaskList({tasks}){
    const priorityLabels = {
        low: 'Baixa',
        medium: 'Média',
        high: 'Alta'
    };

    return (
        <table className="task-table">
            <thead>
                <tr>
                    <th className="task-header">
                        <AiOutlineFileText className="header-icon"/> Prioridade
                    </th>
                </tr>
            </thead>
            <tbody>
                {tasks.map((task, index) => (
                    <tr key={index}>
                        <td className={`task-cell`}>{task.task}</td>
                        <td>
                            <spam className={`priority-dot priority-${task.priority}`}/>
                            {priorityLabels[task.priority]}
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default TaskList;